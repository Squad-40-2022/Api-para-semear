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
@RequestMapping("/instituicao/projeto")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository proRepository;

	@GetMapping("/")
	public List<Projeto> lista() {
		return proRepository.findAll();
	}

	@PostMapping("/")
	public Projeto createProjeto(@RequestBody Projeto pro) {
		return proRepository.save(pro);
	}

	@GetMapping("/{id}")
	public Projeto detalhar(@PathVariable Long id) {
		return proRepository.findById(id).get();
	}

	@PutMapping("/{id}")
	public Projeto updateProjeto(@PathVariable Long id, @RequestBody Projeto proDetails) {
		Projeto pro = proRepository.findById(id).get();

		pro.setAtivo(proDetails.getAtivo());
		pro.setContemplados(proDetails.getContemplados());
		pro.setDescricao(proDetails.getDescricao());
		pro.setNome(proDetails.getNome());
		pro.setQuantia(proDetails.getQuantia());

		return proRepository.save(pro);

	}

	@DeleteMapping("/{id}")
	public void deleteProjeto(@PathVariable Long id) {
		proRepository.deleteById(id);
	}
}
