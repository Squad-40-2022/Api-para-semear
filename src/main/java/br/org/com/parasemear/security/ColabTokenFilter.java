package br.org.com.parasemear.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.org.com.parasemear.model.Colaborador;
import br.org.com.parasemear.repository.ColaboradorRepository;

public class ColabTokenFilter extends OncePerRequestFilter {

	private ColabTokenService tokenService;
	private ColaboradorRepository colRepository;

	public ColabTokenFilter(ColabTokenService tokenService, ColaboradorRepository colRepository) {
		this.tokenService = tokenService;
		this.colRepository = colRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);

		boolean valido = tokenService.isTokenValid(token);
		System.out.println("AutenticacaoTokenFilter" + valido);
		if (valido) {

			autenticarColab(token);
		}

		filterChain.doFilter(request, response);

	}

	private void autenticarColab(String token) {

		Long idCol = tokenService.getIdColaborador(token);

		Colaborador col = colRepository.findById(idCol).get();

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(col, null,
				col.getAuthorities());
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
