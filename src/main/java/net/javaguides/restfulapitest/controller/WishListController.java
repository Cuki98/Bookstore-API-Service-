package net.javaguides.restfulapitest.controller;

import net.javaguides.restfulapitest.model.WishList;
import net.javaguides.restfulapitest.repository.WishListRepository;
import net.javaguides.restfulapitest.service.BookService;
import net.javaguides.restfulapitest.service.WishListItemService;
import net.javaguides.restfulapitest.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private WishListService wishListService;

    @Autowired
    private WishListItemService wishListItemService;

//    @GetMapping("/list")
//    public List<WishList> getAllWishLists()
//    {
//        return this.wishListRepository.findAll();
//    }



    @PostMapping("/add")
    public WishList createWishList(@Valid @RequestBody WishList wishList)
      {
        return this.wishListRepository.save(wishList);
      }




}
