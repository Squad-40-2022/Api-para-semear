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

import br.org.com.parasemear.controller.dto.AdmTokenDTO;
import br.org.com.parasemear.controller.form.LoginForm;
import br.org.com.parasemear.security.AdmTokenService;

@RestController
@RequestMapping("/auth/administrador")
public class AdmAutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private AdmTokenService admTokenService;

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {

		UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(form.getEmail(),
				form.getSenha());
		System.out.println(form.getSenha());
		System.out.println(form.getEmail());
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = admTokenService.gerarToken(authentication);
			System.out.println(token);
			System.out.println("passou aqui");
			return ResponseEntity.ok(new AdmTokenDTO(token, "Bearer", authentication));

		} catch (Exception e) {

			System.out.println("user     AutenticacaoController dando ruim aqui");
			return ResponseEntity.badRequest().build();
		}

	}

}
