package net.javaguides.restfulapitest.repository;

import net.javaguides.restfulapitest.model.Author;
import net.javaguides.restfulapitest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findByAuthorId(Long authorId);

	// *Get Average.
	@Query(value = "SELECT avg(rating) FROM ratings WHERE isbn = ?", nativeQuery = true)
	public Double avg(long isbn);

}
