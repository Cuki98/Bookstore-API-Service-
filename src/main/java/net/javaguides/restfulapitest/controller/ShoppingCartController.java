package net.javaguides.restfulapitest.controller;


import net.javaguides.restfulapitest.common.ApiResponse;
import net.javaguides.restfulapitest.exception.ResourceNotFoundException;
import net.javaguides.restfulapitest.model.*;
import net.javaguides.restfulapitest.repository.ShoppingCartRepository;
import net.javaguides.restfulapitest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    //get list of books by user_id
    @GetMapping("/{id}")
    public ResponseEntity<List<ShoppingCart>> getCart(@PathVariable(value = "id")Long id) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this ID ::" + id));
        List<ShoppingCart> list = new ArrayList<>();
        shoppingCartRepository.findAllByUserId(id).forEach(list::add);
        return ResponseEntity.ok().body(list);

    }
    //add book to user cart
    @PostMapping("/add/{user_id}")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody Book book, @PathVariable(value="user_id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this ID ::" + id));
        ShoppingCart shoppingCart = new ShoppingCart(user,book);
        shoppingCartRepository.save(shoppingCart);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, book.getName() + " added to wishlist."), HttpStatus.OK);

    }

    //delete book from cart
    @DeleteMapping("/{user_id}/{isbn}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable(value = "user_id") Long id, @PathVariable(value="isbn") Long isbn) throws ResourceNotFoundException
    {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserIdAndBookISBN(id,isbn);
        shoppingCartRepository.delete(shoppingCart);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"deleted"), HttpStatus.OK);
    }

}
