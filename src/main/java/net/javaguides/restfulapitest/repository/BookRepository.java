package net.javaguides.restfulapitest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.restfulapitest.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>, JpaRepository<Book, Long> {

    public List<Book> findByAuthorId(Long authorId);

	// *Get Average
	@Query(value = "SELECT avg(rating) FROM ratings WHERE isbn = ?", nativeQuery = true)
	public Double avg(long isbn);

}
