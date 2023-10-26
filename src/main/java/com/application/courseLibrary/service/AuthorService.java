package com.application.courseLibrary.service;

import com.application.courseLibrary.entity.Author;
import com.application.courseLibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthorById(Long id){
        Author author = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("author not found"));
        return author;
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        Author author = authorRepository.findById(id).orElseThrow(()-> new RuntimeException("author not found"));
        authorRepository.deleteById(author.getId());
    }

}


