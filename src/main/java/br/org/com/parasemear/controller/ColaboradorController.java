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

import br.org.com.parasemear.controller.dto.ColaboradorDTO;
import br.org.com.parasemear.controller.form.ColaboradorForm;
import br.org.com.parasemear.model.Colaborador;
import br.org.com.parasemear.repository.ColaboradorRepository;

@Controller
@ResponseBody
@RequestMapping("/colaborador")
public class ColaboradorController {

	@Autowired
	private ColaboradorRepository colRepository;

	@GetMapping("/")
	public List<ColaboradorDTO> lista() {
		List<Colaborador> col = colRepository.findAll();
		return ColaboradorDTO.converter(col);
	}

	@GetMapping("/{id}")
	public ColaboradorDTO detalhar(@PathVariable Long id) {
		Colaborador colaborador = colRepository.getReferenceById(id);
		return new ColaboradorDTO(colaborador);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {

		colRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/")
	public ResponseEntity<ColaboradorDTO> cadastrar(@RequestBody @Valid ColaboradorForm form,
			UriComponentsBuilder uriBuilder) {

		Optional<Colaborador> col = colRepository.findByEmail(form.getEmail());

		if (col.isPresent()) {
			return ResponseEntity.badRequest().build();
		} else {

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Colaborador colaborador = form.converter(encoder);
			colRepository.save(colaborador);
			URI uri = uriBuilder.path("/{id}").buildAndExpand(colaborador.getId()).toUri();
			return ResponseEntity.created(uri).body(new ColaboradorDTO(colaborador));
		}

	}

}
