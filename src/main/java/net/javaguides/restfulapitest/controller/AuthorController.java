package net.javaguides.restfulapitest.controller;

import net.javaguides.restfulapitest.exception.ResourceNotFoundException;
import net.javaguides.restfulapitest.model.Author;
import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")

public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    //gets all authors
    @GetMapping("/authors")
    public List<Author> getAllAuthors()
    {
        return this.authorRepository.findAll();
    }

    //posts author
    @PostMapping("/authors")
    public Author createAuthor(@Valid @RequestBody Author author)
    {
        return this.authorRepository.save(author);
    }
    //delete book by id
    @DeleteMapping("/authors/{authorID}")
    public Map<String, Boolean> deleteAuthor(@PathVariable(value = "authorID") Long authorID) throws ResourceNotFoundException
    {

        Author author = authorRepository.findById(authorID).orElseThrow(() -> new ResourceNotFoundException("Book not found for this ID ::" + authorID));
        this.authorRepository.delete(author);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;

    }



}
