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
public interface BookService {
    List<Book> findAll();

    Book findOne(Long id);
    List<Book> findByGenre(String genre);
    List<Book> blurrySearch(String title);

}
