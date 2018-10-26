package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutorRepository;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteExcpetion;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontratoExcpetion;

@Service
public class AutoresServices {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public List<Autor> listar(){
		return autorRepository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autorRepository.findOne(autor.getId());
			
			if(a != null) {
				throw new AutorExistenteExcpetion("O autor já existe.");
			}
		}
		
		return autorRepository.save(autor);
	}

	public Autor buscar(Long id) {
		Autor autor = autorRepository.findOne(id);
		if(autor == null) {
			throw new AutorNaoEncontratoExcpetion("O autor não pôde ser encontrado.");
		}
		
		return autor;
	}

}
