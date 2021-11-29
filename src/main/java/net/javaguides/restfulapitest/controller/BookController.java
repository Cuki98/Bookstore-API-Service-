package net.javaguides.restfulapitest.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.restfulapitest.exception.ResourceNotFoundException;
import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/")
public class BookController {


	// Es
    @Autowired
    private BookRepository bookRepository;


    //get books
    @GetMapping("/books")
    public List<Book> getAllBooks()
    {
        return (List<Book>) this.bookRepository.findAll();


    }

	// Test comment

    //get book by id
    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookByID(@PathVariable(value = "isbn") Long bookISBN)
        throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookISBN).orElseThrow(() -> new ResourceNotFoundException("Book not found for this ID ::" + bookISBN));
        return ResponseEntity.ok().body(book);
    }

    //get books by author id
    @GetMapping("/books/authors/{authorID}")
    public List<Book> getByAuthorId(@PathVariable Long authorID)
    {
        List<Book> books = new ArrayList<>();
        bookRepository.findByAuthorId(authorID).forEach(books::add);
        return books;
    }

    //post book
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book)
    {
        return this.bookRepository.save(book);
    }

    //update book
    @PutMapping("books/{isbn}")
    public ResponseEntity<Book> updateBook (@PathVariable(value = "isbn") Long bookISBN, @Valid @RequestBody Book bookDetails) throws ResourceNotFoundException {
        Book book = bookRepository.findById(bookISBN).orElseThrow(() -> new ResourceNotFoundException("Book not found for this ID ::" + bookISBN));

        book.setISBN(bookDetails.getISBN());
        book.setGenre(bookDetails.getGenre());
        book.setName((bookDetails.getName()));
        book.setPrice(bookDetails.getPrice());
        book.setDescription(bookDetails.getDescription());
        book.setRatings(bookDetails.getRatings());
        book.setCopies_sold(bookDetails.getCopies_sold());
        book.setYear_published(bookDetails.getYear_published());

        return ResponseEntity.ok(this.bookRepository.save(book));
    }

    //delete book
    @DeleteMapping("books/{isbn}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "isbn") Long bookISBN) throws ResourceNotFoundException
    {
        Book book = bookRepository.findById(bookISBN).orElseThrow(() -> new ResourceNotFoundException("Book not found for this ID ::" + bookISBN));

        this.bookRepository.delete(book);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;

    }





}
