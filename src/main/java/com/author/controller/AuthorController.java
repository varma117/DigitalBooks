package com.author.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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
@GetMapping("/getauthor/{id}")
public Optional<Author> getAuthor(@PathVariable Long id){
	Optional<Author> author = authorService.getAuthor(id);
	return author;
}

@DeleteMapping("/deleteauthor/{id}")
public ResponseEntity<Author> deleteAuthor(@PathVariable("id") Long id){
	System.out.println(id);
	ResponseEntity<Author> responseEntity = new ResponseEntity<>(HttpStatus.OK);
	try {
		authorService.deleteAuthor(id);
	}
	catch(Exception e) {
		e.printStackTrace();
		responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	return responseEntity;
}

@PutMapping("/update/{id}")
public ResponseEntity<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody Author author){
	return new ResponseEntity<Author>(authorService.updateAuthor(author, id),HttpStatus.OK);
}

}
