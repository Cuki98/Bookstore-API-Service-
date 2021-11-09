package net.javaguides.restfulapitest.controller;


import net.javaguides.restfulapitest.common.ApiResponse;
import net.javaguides.restfulapitest.exception.ResourceNotFoundException;
import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.model.User;
import net.javaguides.restfulapitest.model.WishList;
import net.javaguides.restfulapitest.repository.BookRepository;
import net.javaguides.restfulapitest.repository.UserRepository;
import net.javaguides.restfulapitest.repository.WishListRepository;
import net.javaguides.restfulapitest.service.impl.WishListService;
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
    WishListService wishListService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    BookRepository bookRepository;

    //get wishlist by user id
    @GetMapping("/{id}")
    public ResponseEntity<List<WishList>> getWishList(@PathVariable(value = "id")Long id) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this ID ::" + id));
        List<WishList> list = new ArrayList<>();
        wishListRepository.findAllByUserId(id).forEach(list::add);

//        WishList wishList = wishListRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("wishlist not found for this user id:" + id));
        return ResponseEntity.ok().body(list);

    }

    //post a wishlist to user by user id
    @PostMapping("/add/{user_id}")
    public ResponseEntity<ApiResponse> addWishList(@RequestBody Book book, @PathVariable(value="user_id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this ID ::" + id));
        WishList wishListIn = new WishList(user, book,user.getWishlist_name());
        wishListService.createWishlist(wishListIn);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, book.getName() + " added to wishlist."), HttpStatus.OK);

    }
    //create wishlist name for user
    @PostMapping("/create/{user_id}/{name}")
    public ResponseEntity<ApiResponse> createWishList(@PathVariable(value = "user_id") Long id,@PathVariable(value = "name")String name) throws ResourceNotFoundException
    {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found for this ID ::" + id));
        user.setWishlist_name(name);
        userRepository.save(user);
        return new ResponseEntity<>(new ApiResponse(true,"Wishlist created with name: " + name),HttpStatus.OK);
    }

    //delete wishlist item
    @DeleteMapping("{user_id}/{isbn}")
    public  ResponseEntity<ApiResponse> deleteWishList(@PathVariable(value = "user_id") Long id, @PathVariable(value="isbn") Long isbn) throws ResourceNotFoundException {
        //
        WishList wishList = wishListRepository.findByUserIdAndBookISBN(id,isbn);
        wishListRepository.delete(wishList);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"deleted"), HttpStatus.OK);
    }
}
