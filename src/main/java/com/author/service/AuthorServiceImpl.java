package com.author.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.exception.AuthorNotFoundException;
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

	@Override
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
		
	}

	@Override
	public Author updateAuthor(Author author,Long id) {
		Author existingAuthor = authorRepository.findById(id).orElseThrow(
	()-> new AuthorNotFoundException("Author", "id", id));
		existingAuthor.setAuthorName(author.getAuthorName());
		existingAuthor.setBookName(author.getBookName());;
		existingAuthor.setCategory(author.getCategory());
		existingAuthor.setChapters(author.getChapters());
		existingAuthor.setLogo(author.getLogo());
		existingAuthor.setPrice(author.getPrice());
		existingAuthor.setPublishedDate(author.getPublishedDate());
		existingAuthor.setPublisher(author.getPublisher());
		existingAuthor.setStatus(author.isStatus());
		authorRepository.save(existingAuthor);
		
		
		return existingAuthor;
	}

}
