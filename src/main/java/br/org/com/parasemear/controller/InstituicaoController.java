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

import br.org.com.parasemear.controller.dto.InstituicaoDTO;
import br.org.com.parasemear.controller.form.InstituicaoForm;
import br.org.com.parasemear.model.Instituicao;
import br.org.com.parasemear.repository.InstituicaoRepository;

@Controller
@ResponseBody
@RequestMapping("/instituicao")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoRepository clienteRepository;
	
	@GetMapping("/")
	  public List<InstituicaoDTO> lista() {
	    List<Instituicao> cli = clienteRepository.findAll();
	    return InstituicaoDTO.converter(cli);
	  }

	  @GetMapping("/{id}")
	  public InstituicaoDTO detalhar(@PathVariable Long id) {
		  Instituicao cliente = clienteRepository.getReferenceById(id);
	    return new InstituicaoDTO(cliente);
	  }

	  @DeleteMapping("/{id}")
	  public ResponseEntity<?> remove(@PathVariable Long id) {

	    clienteRepository.deleteById(id);

	    return ResponseEntity.ok().build();
	  }

	  @PostMapping("/")
	  public ResponseEntity<InstituicaoDTO> cadastrar(@RequestBody @Valid InstituicaoForm form, UriComponentsBuilder uriBuilder) {

	    Optional<Instituicao> cli = clienteRepository.findByEmail(form.getEmail());

	    if (cli.isPresent()) {
	      return ResponseEntity.badRequest().build();
	    } else {

	      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	      Instituicao cliente = form.converter(encoder);
	      clienteRepository.save(cliente);
	      URI uri = uriBuilder.path("/{id}").buildAndExpand(cliente.getId()).toUri();
	      return ResponseEntity.created(uri).body(new InstituicaoDTO(cliente));
	    }

	  }
}
