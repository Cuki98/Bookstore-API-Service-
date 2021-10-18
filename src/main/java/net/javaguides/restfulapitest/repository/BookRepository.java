package net.javaguides.restfulapitest.repository;

import net.javaguides.restfulapitest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}