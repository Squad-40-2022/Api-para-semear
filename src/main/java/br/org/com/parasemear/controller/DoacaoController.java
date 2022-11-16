package br.org.com.parasemear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.org.com.parasemear.model.Doacao;
import br.org.com.parasemear.repository.DoacaoRepository;

@Controller
@ResponseBody
@RequestMapping("/colaborador/doacao")
public class DoacaoController {
	
	@Autowired
	private DoacaoRepository doaRepository;

	// get all clients
	@GetMapping("/")
	public List<Doacao> lista() {
		return doaRepository.findAll();
	}

	// create client rest api
	@PostMapping("/")
	public Doacao createDoacao(@RequestBody Doacao doa) {
		return doaRepository.save(doa);
	}

	// get client by id rest api
	@GetMapping("/{id}")
	public Doacao detalhar(@PathVariable Long id) {
		return doaRepository.findById(id).get();
	}

	// update client rest api

	@PutMapping("/{id}")
	public Doacao updateDoacao(@PathVariable Long id, @RequestBody Doacao doaDetails) {
		Doacao doa = doaRepository.findById(id).get();

		
		doa.setAnonimo(doaDetails.getAnonimo());
		doa.setData(doaDetails.getData());
		doa.setDescricao(doaDetails.getDescricao());
		doa.setQuantia(doaDetails.getQuantia());
		doa.setTipo(doaDetails.getTipo());

		return doaRepository.save(doa);

	}

	// delete client rest api
	@DeleteMapping("/{id}")
	public void deleteDoacao(@PathVariable Long id) {
		doaRepository.deleteById(id);
	}
}
