package br.org.com.parasemear.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.org.com.parasemear.controller.dto.AdministradorDTO;
import br.org.com.parasemear.controller.form.AdministradorForm;
import br.org.com.parasemear.model.Administrador;
import br.org.com.parasemear.repository.AdministradorRepository;

@Controller
@ResponseBody
@RequestMapping("/adm")
public class AdministradorController {
	
	@Autowired
	private AdministradorRepository userRepository;

	@GetMapping("/user/")
	public List<AdministradorDTO> lista() {
		List<Administrador> users = userRepository.findAll();
		return AdministradorDTO.converter(users);
	}

	@GetMapping("/user/{id}")
	public AdministradorDTO detalhar(@PathVariable Long id) {
		Administrador user = userRepository.getReferenceById(id);
		return new AdministradorDTO(user);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {

		userRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/user/")
	public ResponseEntity<AdministradorDTO> cadastrar(@RequestBody @Valid AdministradorForm form, UriComponentsBuilder uriBuilder) {

		Optional<Administrador> users = userRepository.findByEmail(form.getEmail());

		if (users.isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Administrador user = form.converter(encoder);
			userRepository.save(user);
			URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(uri).body(new AdministradorDTO(user));
		}
		

	}
}
