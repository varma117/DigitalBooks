package com.author.service;

import java.util.Optional;

import com.author.model.Author;

public interface IAuthorService {
	
	Long saveAuthor(Author author);
	
	public Optional<Author> getAuthor(Long id);

}
