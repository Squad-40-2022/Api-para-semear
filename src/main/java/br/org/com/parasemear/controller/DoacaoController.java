package br.org.com.parasemear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.org.com.parasemear.model.Doacao;
import br.org.com.parasemear.repository.DoacaoRepository;

@Controller
@ResponseBody
@RequestMapping("/colaborador")
public class DoacaoController {
	
	@Autowired
	private DoacaoRepository doaRepository;

	// get all doacoes
	@GetMapping("/doacoes/")
	public List<Doacao> lista() {
		return doaRepository.findAll();
	}

	// create doacao rest api
	@PostMapping("/doacoes/")
	public Doacao createDoacao(@RequestBody Doacao doa) {
		return doaRepository.save(doa);
	}

	// get doacao by id rest api
	@GetMapping("/doacoes/{id}")
	public Doacao detalhar(@PathVariable Long id) {
		return doaRepository.findById(id).get();
	}

}
