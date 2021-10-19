package net.javaguides.restfulapitest.service;


import net.javaguides.restfulapitest.dto.BookDto;
import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.repository.AuthorRepository;
import net.javaguides.restfulapitest.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public List<BookDto> listBooks()
    {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for(Book book : books)
        {
            BookDto bookDto = getDtoFromBook(book);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    public static BookDto getDtoFromBook(Book book)
    {
        BookDto bookDto = new BookDto(book);
        return bookDto;
    }

}
