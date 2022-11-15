package br.org.com.parasemear.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.org.com.parasemear.model.Administrador;
import br.org.com.parasemear.repository.AdministradorRepository;

public class AdmTokenFilter extends OncePerRequestFilter {

	private AdmTokenService tokenService;
	private AdministradorRepository admRepository;

	public AdmTokenFilter(AdmTokenService tokenService, AdministradorRepository admRepository) {
		this.tokenService = tokenService;
		this.admRepository = admRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = recuperarToken(request);

		boolean valido = tokenService.isTokenValid(token);
		System.out.println("AutenticacaoTokenFilter" + valido);
		if (valido) {

			autenticarAdministrador(token);
		}

		filterChain.doFilter(request, response);

	}

	private void autenticarAdministrador(String token) {

		Long idAdm = tokenService.getIdAdministrador(token);

		Administrador adm = admRepository.findById(idAdm).get();

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(adm, null,
				adm.getAuthorities());
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
