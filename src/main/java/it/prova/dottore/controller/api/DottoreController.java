package it.prova.dottore.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.prova.dottore.dto.DottoreDTO;
import it.prova.dottore.exception.DottoreNotFoundException;
import it.prova.dottore.model.Dottore;
import it.prova.dottore.service.DoottoreService.DottoreService;

@RestController
@RequestMapping(value = "/dottore", produces = { MediaType.APPLICATION_JSON_VALUE})
public class DottoreController {

	@Autowired
	private DottoreService dottoreService;

	@GetMapping("/{idInput}")
	public Dottore getDottore(@PathVariable(required = true) Long idInput) {
		return dottoreService.get(idInput);
	}

	@GetMapping
	public List<Dottore> getAll() {
		return dottoreService.listAll();
	}

	@PostMapping("/search")
	public ResponseEntity<Page<Dottore>> searchAndPagination(@RequestBody Dottore dottoreExample,
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {

		Page<Dottore> results = dottoreService.searchAndPaginate(dottoreExample, pageNo, pageSize, sortBy);

		return new ResponseEntity<Page<Dottore>>(results, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public Dottore createNewDottore(@RequestBody Dottore dottoreInput) {
		return dottoreService.save(dottoreInput);
	}

	@PutMapping("/{id}")
	public Dottore updateDottore(@RequestBody Dottore dottoreInput, @PathVariable Long id) {
		Dottore dottoreToUpdate = dottoreService.get(id);
		dottoreToUpdate.setNome(dottoreInput.getNome());
		dottoreToUpdate.setCognome(dottoreInput.getCognome());
		dottoreToUpdate.setCodiceDipendente(dottoreInput.getCodiceDipendente());
		dottoreToUpdate.setInServizio(dottoreInput.isInServizio());
		dottoreToUpdate.setInVisita(dottoreInput.isInVisita());
		return dottoreService.save(dottoreToUpdate);
	}

	@DeleteMapping("/{id}")
	public void deleteDottore(@PathVariable(required = true) Long id) {
		dottoreService.delete(dottoreService.get(id));
	}

	@GetMapping("/verifica/{codiceDipendente}")
	public DottoreDTO verifica(@PathVariable(required = true) String codiceDipendente) {
		return DottoreDTO.buildDottoreDTOFromModel(dottoreService.findByCodiceDipendente(codiceDipendente));
	}

	@PostMapping("/impostaInVisita")
	public DottoreDTO impostaInVisita(@RequestBody Dottore dottore) {

		Dottore dottoreCaricato = dottoreService.impostaInVisita(dottore.getCodiceDipendente());

		if (dottoreCaricato == null || dottoreCaricato.getId() == null)
			throw new DottoreNotFoundException("Dottore non trovato con codice specificato");

		return DottoreDTO.buildDottoreDTOFromModel(dottoreService.impostaInVisita(dottore.getCodiceDipendente()));
	}

}