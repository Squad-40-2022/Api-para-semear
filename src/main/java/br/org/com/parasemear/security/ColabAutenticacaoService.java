package br.org.com.parasemear.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.com.parasemear.model.Colaborador;
import br.org.com.parasemear.repository.ColaboradorRepository;

@Service
public class ColabAutenticacaoService implements UserDetailsService {

	@Autowired
	private ColaboradorRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Colaborador> cliente = clienteRepository.findByEmail(username);
		if (cliente.isPresent()) {
			System.out.println("AutenticacaoService Achou");
			return cliente.get();
		}

		throw new UsernameNotFoundException("DADOS INVALIDOS");

	}

}
