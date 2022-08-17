package com.author.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.author.model.Author;

public interface IAuthorRepository extends JpaRepository<Author, Long> {

}
