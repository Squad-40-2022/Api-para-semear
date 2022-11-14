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
@RequestMapping("/instituicao")
public class RelatorioController {

	@Autowired
	private RelatorioRepository relRepository;

	// get all relatorios
	@GetMapping("/relatorios/")
	public List<Relatorio> lista() {
		return relRepository.findAll();
	}

	// create relatorio rest api
	@PostMapping("/relatorios/")
	public Relatorio createRelatorio(@RequestBody Relatorio rel) {
		return relRepository.save(rel);
	}

	// get relatorio by id rest api
	@GetMapping("/relatorios/{id}")
	public Relatorio detalhar(@PathVariable Long id) {
		return relRepository.findById(id).get();
	}

	// update relatorio rest api

	@PutMapping("/relatorios/{id}")
	public Relatorio updateRelatorio(@PathVariable Long id, @RequestBody Relatorio relDetails) {
		Relatorio rel = relRepository.findById(id).get();

		rel.setMes(relDetails.getDescricao());
		rel.setDescricao(relDetails.getDescricao());
		rel.setQuantia(relDetails.getQuantia());
		rel.setContemplados(relDetails.getContemplados());
		rel.setProjetos(relDetails.getProjetos());
		rel.setVoluntarios(relDetails.getVoluntarios());
		rel.setInstituicao(relDetails.getInstituicao());

		return relRepository.save(rel);

	}

	// delete relatorio rest api
	@DeleteMapping("/relatorios/{id}")
	public void deleteRelatorio(@PathVariable Long id) {
		relRepository.deleteById(id);
	}
}
