package net.javaguides.restfulapitest.controller;


import net.javaguides.restfulapitest.common.ApiResponse;
import net.javaguides.restfulapitest.exception.ResourceNotFoundException;
import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.model.User;
import net.javaguides.restfulapitest.model.WishList;
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

    //get wishlist by user id
    @GetMapping("/{id}")
    public ResponseEntity<List<WishList>> getWishList(@PathVariable(value = "id")Long id) throws ResourceNotFoundException
    {
        List<WishList> list = new ArrayList<>();
        wishListRepository.findAllByUserId(id).forEach(list::add);

//        WishList wishList = wishListRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("wishlist not found for this user id:" + id));
        return ResponseEntity.ok().body(list);


    }
    //post a wishlist to user by user id
    @PostMapping("/add/{user_id}")
    public ResponseEntity<ApiResponse> addWishList(@RequestBody Book book, @PathVariable(value="user_id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this ID ::" + id));
        WishList wishListIn = new WishList(user, book);
        wishListService.createWishlist(wishListIn);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"add to wishlist"), HttpStatus.OK);
    }

//    @PutMapping("/update/{user_id}")
//    public ResponseEntity<ApiResponse> updateWishList(@RequestBody Book book, @PathVariable(value = "user_id") Long id) throws ResourceNotFoundException
//    {
//        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this ID ::" + id));
//        WishList wishList = new WishList();
//        wishList.setBook(book);
//        wishList.setUser(user);
//
//    }
    @DeleteMapping("{user_id}/{isbn}")
    public  ResponseEntity<ApiResponse> deleteWishList(@PathVariable(value = "user_id") Long id, @PathVariable(value="isbn") Long isbn) throws ResourceNotFoundException {
        //
        WishList wishList = wishListRepository.findByUserIdAndBookISBN(id,isbn);
        wishListRepository.delete(wishList);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"deleted"), HttpStatus.OK);
    }
}
