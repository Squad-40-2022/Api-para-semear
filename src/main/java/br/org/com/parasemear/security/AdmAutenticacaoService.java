package br.org.com.parasemear.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.com.parasemear.model.Administrador;
import br.org.com.parasemear.repository.AdministradorRepository;

@Service
public class AdmAutenticacaoService implements UserDetailsService {

	@Autowired
	private AdministradorRepository admRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Administrador> adm = admRepository.findByEmail(username);
		if (adm.isPresent()) {
			System.out.println("AutenticacaoService Achou");
			return adm.get();
		}

		throw new UsernameNotFoundException("DADOS INVALIDOS");

	}

}
