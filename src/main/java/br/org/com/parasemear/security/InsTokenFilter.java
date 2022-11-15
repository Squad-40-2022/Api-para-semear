package br.org.com.parasemear.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.org.com.parasemear.model.Instituicao;
import br.org.com.parasemear.repository.InstituicaoRepository;

public class InsTokenFilter extends OncePerRequestFilter {

	private InsTokenService tokenService;
	private InstituicaoRepository insRepository;

	public InsTokenFilter(InsTokenService tokenService, InstituicaoRepository insRepository) {
		this.tokenService = tokenService;
		this.insRepository = insRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);

		boolean valido = tokenService.isTokenValid(token);
		System.out.println("AutenticacaoTokenFilter" + valido);
		if (valido) {

			autenticarInstituicao(token);
		}

		filterChain.doFilter(request, response);

	}

	private void autenticarInstituicao(String token) {

		Long idIns = tokenService.getIdInstituicao(token);

		Instituicao ins = insRepository.findById(idIns).get();

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(ins, null,
				ins.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);

	}

	private String recuperarToken(HttpServletRequest request) {

		String token = request.getHeader("Authorization");

		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			System.out.println("AutenticacaoTokenFilter AQUI TBM");
			return null;
		} else {
			return token.substring(7, token.length());
		}
	}

}
