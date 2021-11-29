package net.javaguides.restfulapitest.repository;

import net.javaguides.restfulapitest.model.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    public List<ShoppingCart> findAllByUserId(Long userId);
    ShoppingCart findByUserIdAndBookISBN(Long userId,Long ISBN);



}
