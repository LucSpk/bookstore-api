package com.lucas.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.repositories.LivroRepository;
import com.lucas.bookstore.service.exceptions.ObjectNotFoundException;

@Service				// Injetar Livro Service em Livro Resource e cria uma dependencia
public class LivroService {

	@Autowired 			// Informa para o Spring que é o Spring quem vai gerenciar essa instancia de LivroRepository
	private LivroRepository repository;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
}
