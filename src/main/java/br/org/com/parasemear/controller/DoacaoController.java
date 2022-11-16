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
@RequestMapping("/adm")
public class DoacaoController {
	
	@Autowired
	private DoacaoRepository aerRepository;

	// get all clients
	@GetMapping("/aeroportos/")
	public List<Doacao> lista() {
		return aerRepository.findAll();
	}

	// create client rest api
	@PostMapping("/aeroportos/")
	public Doacao createAeroporto(@RequestBody Doacao aer) {
		return aerRepository.save(aer);
	}

	// get client by id rest api
	@GetMapping("/aeroportos/{id}")
	public Doacao detalhar(@PathVariable Long id) {
		return aerRepository.findById(id).get();
	}

	// update client rest api

	@PutMapping("/aeroportos/{id}")
	public Doacao updateAeroporto(@PathVariable Long id, @RequestBody Doacao aerDetails) {
		Doacao aer = aerRepository.findById(id).get();

		aer.setNome(aerDetails.getNome());
		aer.setCnpj(aerDetails.getCnpj());
		aer.setCidade(aerDetails.getCidade());

		return aerRepository.save(aer);

	}

	// delete client rest api
	@DeleteMapping("/aeroportos/{id}")
	public void deleteAeroporto(@PathVariable Long id) {
		aerRepository.deleteById(id);
	}
}
