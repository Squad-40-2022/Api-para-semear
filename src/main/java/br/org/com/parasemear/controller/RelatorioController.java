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

import br.org.com.parasemear.model.Relatorio;
import br.org.com.parasemear.repository.RelatorioRepository;

@Controller
@ResponseBody
@RequestMapping("/instituicao/relatorio")
public class RelatorioController {
	
	@Autowired
	private RelatorioRepository relRepository;

	@GetMapping("/")
	public List<Relatorio> lista() {
		return relRepository.findAll();
	}
	
	@PostMapping("/")
	public Relatorio createRelatorio(@RequestBody Relatorio rel) {
		return relRepository.save(rel);
	}

	@GetMapping("/{id}")
	public Relatorio detalhar(@PathVariable Long id) {
		return relRepository.findById(id).get();
	}

	@PutMapping("/{id}")
	public Relatorio updateRelatorio(@PathVariable Long id, @RequestBody Relatorio relDetails) {
		Relatorio rel = relRepository.findById(id).get();

		rel.setContemplados(relDetails.getContemplados());
		rel.setDescricao(relDetails.getDescricao());
		rel.setMes(relDetails.getMes());
		rel.setQuantia(relDetails.getQuantia());
		rel.setVoluntarios(relDetails.getVoluntarios());

		return relRepository.save(rel);

	}

	@DeleteMapping("/hospedagens/{id}")
	public void deleteRelatorio(@PathVariable Long id) {
		relRepository.deleteById(id);
	}
	
	

	
}
