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
@RequestMapping("/adm")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository conRepository;

	// get all clients
	@GetMapping("/companhias")
	public List<Projeto> lista() {
		return conRepository.findAll();
	}

	// create client rest api
	@PostMapping("/companhias")
	public Projeto createCompanhia(@RequestBody Projeto con) {
		return conRepository.save(con);
	}

	// get client by id rest api
	@GetMapping("/companhias/{id}")
	public Projeto detalhar(@PathVariable Long id) {
		return conRepository.findById(id).get();
	}

	// update client rest api

	@PutMapping("/companhias/{id}")
	public Projeto updateCompanhia(@PathVariable Long id, @RequestBody Projeto conDetails) {
		Projeto con = conRepository.findById(id).get();

		con.setNome(conDetails.getNome());
		con.setCnpj(conDetails.getCnpj());

		return conRepository.save(con);

	}

	// delete client rest api
	@DeleteMapping("/companhias/{id}")
	public void deleteCompanhia(@PathVariable Long id) {
		conRepository.deleteById(id);
	}
}
