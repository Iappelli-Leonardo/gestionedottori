package it.prova.dottore.service;

import java.util.List;

import org.springframework.data.domain.Page;

import it.prova.dottore.model.Dottore;

public interface DoottoreService {

	public interface DottoreService {
		
		public Dottore inserisciNuovo(Dottore transientInstance);

		public List<Dottore> listAll();

		public Dottore cariscaSingoloElemento(Long id);

		public Page<Dottore> searchAndPaginate(Dottore automobileExample, Integer pageNo, Integer pageSize, String sortBy);

		public Dottore get(Long idInput);

		public Dottore save(Dottore input);

		public void delete(Dottore input);
		
		public Dottore findByCodiceDipendente(String codiceInput);

		public Dottore impostaInVisita(String codiceDipendente);

	}
}
