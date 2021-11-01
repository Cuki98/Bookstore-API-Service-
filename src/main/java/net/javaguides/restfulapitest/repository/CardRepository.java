package net.javaguides.restfulapitest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.restfulapitest.model.CreditCard;

@Repository
public interface CardRepository extends JpaRepository<CreditCard, Long>{
		public List<CreditCard> findByUserId(long id);
}
