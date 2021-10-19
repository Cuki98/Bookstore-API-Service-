package net.javaguides.restfulapitest.repository;

import net.javaguides.restfulapitest.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList,Long> {
    List<WishList> findAllByUserId(Long userId);
}
