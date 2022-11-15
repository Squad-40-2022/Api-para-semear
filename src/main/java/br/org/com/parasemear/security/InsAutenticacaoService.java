package br.org.com.parasemear.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.org.com.parasemear.model.Instituicao;
import br.org.com.parasemear.repository.InstituicaoRepository;

@Service
public class InsAutenticacaoService implements UserDetailsService {

	@Autowired
	private InstituicaoRepository insRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Instituicao> ins = insRepository.findByEmail(username);
		if (ins.isPresent()) {
			System.out.println("AutenticacaoService Achou");
			return ins.get();
		}

		throw new UsernameNotFoundException("DADOS INVALIDOS");

	}

}
