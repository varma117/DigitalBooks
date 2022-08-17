package com.author.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.author.model.Author;
import com.author.service.IAuthorService;

@RestController
public class AuthorController {
	
@Autowired
IAuthorService authorService;

@PostMapping("/saveauthor")
Long createAuthor(@RequestBody Author author) {
	Long id = authorService.saveAuthor(author);
	System.out.println(id);
	return id;
}
@GetMapping("/getAuthor/{id}")
public Optional<Author> getAuthor(@PathVariable Long id){
	Optional<Author> author = authorService.getAuthor(id);
	return author;
}

}
