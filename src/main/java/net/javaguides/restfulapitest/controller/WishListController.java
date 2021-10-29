package net.javaguides.restfulapitest.controller;


import net.javaguides.restfulapitest.common.ApiResponse;
import net.javaguides.restfulapitest.exception.ResourceNotFoundException;
import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.model.User;
import net.javaguides.restfulapitest.model.WishList;
import net.javaguides.restfulapitest.repository.UserRepository;
import net.javaguides.restfulapitest.service.impl.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;

    @Autowired
    UserRepository userRepository;


    @PostMapping("/add/{id}")
    public ResponseEntity<ApiResponse> addWishList(@RequestBody Book book, @PathVariable(value="id") Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this ID ::" + id));
        WishList wishList = new WishList(user, book);
        wishListService.createWishlist(wishList);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true,"add to wishlist"), HttpStatus.OK);
    }
}
