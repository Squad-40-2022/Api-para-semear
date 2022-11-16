package br.org.com.parasemear.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.com.parasemear.controller.dto.ColabTokenDTO;
import br.org.com.parasemear.controller.form.LoginForm;
import br.org.com.parasemear.security.ColabTokenService;

@RestController
@RequestMapping("/auth/colab")
public class ColabAutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private ColabTokenService tokenService;

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {

		UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(form.getEmail(),
				form.getSenha());
		System.out.println(form.getSenha());
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			System.out.println(token);
			return ResponseEntity.ok(new ColabTokenDTO(token, "Bearer", authentication));

		} catch (Exception e) {

			System.out.println("AutenticacaoController dando ruim aqui");
			return ResponseEntity.badRequest().build();
		}

	}
}
