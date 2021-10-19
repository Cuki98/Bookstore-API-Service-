package net.javaguides.restfulapitest.controller;

import net.javaguides.restfulapitest.common.ApiResponse;
import net.javaguides.restfulapitest.dto.BookDto;
import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.model.User;
import net.javaguides.restfulapitest.model.WishList;
import net.javaguides.restfulapitest.repository.UserRepository;
import net.javaguides.restfulapitest.repository.WishListRepository;
import net.javaguides.restfulapitest.service.BookService;
import net.javaguides.restfulapitest.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListRepository wishListRepository;

    @GetMapping("/list")
    public List<WishList> getAllWishLists()
    {
        return this.wishListRepository.findAll();
    }

    @PostMapping("/add")
    public WishList createWishList(@Valid @RequestBody WishList wishList)
      {
        return this.wishListRepository.save(wishList);
      }




}
