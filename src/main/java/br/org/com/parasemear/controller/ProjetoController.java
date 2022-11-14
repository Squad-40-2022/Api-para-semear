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

import br.org.com.parasemear.model.Projeto;
import br.org.com.parasemear.repository.ProjetoRepository;

@Controller
@ResponseBody
@RequestMapping("/instituicao")
public class ProjetoController {

	@Autowired
	private ProjetoRepository proRepository;

	// get all projetos
	@GetMapping("/projetos/")
	public List<Projeto> lista() {
		return proRepository.findAll();
	}

	// create projeto rest api
	@PostMapping("/projetos/")
	public Projeto createProjeto(@RequestBody Projeto pro) {
		return proRepository.save(pro);
	}

	// get projeto by id rest api
	@GetMapping("/projetos/{id}")
	public Projeto detalhar(@PathVariable Long id) {
		return proRepository.findById(id).get();
	}

	// update projeto rest api

	@PutMapping("/projetos/{id}")
	public Projeto updateProjeto(@PathVariable Long id, @RequestBody Projeto proDetails) {
		Projeto pro = proRepository.findById(id).get();

		pro.setId(proDetails.getId());
		pro.setNome(proDetails.getNome());
		pro.setDescricao(proDetails.getDescricao());
		pro.setQuantia(proDetails.getQuantia());
		pro.setContemplados(proDetails.getContemplados());
		pro.setInstituicao(proDetails.getInstituicao());

		return proRepository.save(pro);

	}

	// delete projeto rest api
	@DeleteMapping("/projetos/{id}")
	public void deleteProjeto(@PathVariable Long id) {
		proRepository.deleteById(id);
	}
}
