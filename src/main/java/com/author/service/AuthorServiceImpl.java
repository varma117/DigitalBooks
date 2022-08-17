package com.author.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.model.Author;

@Service
public class AuthorServiceImpl implements IAuthorService{
	
	@Autowired
	IAuthorRepository authorRepository;
	
	public Long saveAuthor(Author author) {
		Author savedAuthor = authorRepository.save(author);
		return savedAuthor.getId();
	}

	@Override
	public Optional<Author> getAuthor(Long id) {
		
		return authorRepository.findById(id);
	}

}
