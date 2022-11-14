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
@RequestMapping("/instituicao")
public class InstituicaoController {

	@Autowired
	private AdministradorRepository admRepository;

	@GetMapping("/")
	public List<AdministradorDTO> lista() {
		List<Administrador> adm = admRepository.findAll();
		return AdministradorDTO.converter(adm);
	}

	@GetMapping("/{id}")
	public AdministradorDTO detalhar(@PathVariable Long id) {
		Administrador administrador = admRepository.getReferenceById(id);
		return new AdministradorDTO(administrador);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {

		admRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/")
	public ResponseEntity<AdministradorDTO> cadastrar(@RequestBody @Valid AdministradorForm form,
			UriComponentsBuilder uriBuilder) {

		Optional<Administrador> adm = admRepository.findByEmail(form.getEmail());

		if (adm.isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Administrador administrador = form.converter(encoder);
			admRepository.save(administrador);
			URI uri = uriBuilder.path("/{id}").buildAndExpand(administrador.getId()).toUri();
			return ResponseEntity.created(uri).body(new AdministradorDTO(administrador));
		}

	}


}
