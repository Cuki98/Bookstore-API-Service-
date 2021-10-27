package net.javaguides.restfulapitest.service;

import net.javaguides.restfulapitest.model.Book;
import net.javaguides.restfulapitest.model.User;
import net.javaguides.restfulapitest.model.WishList;
import net.javaguides.restfulapitest.model.WishListItem;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WishListItemService {
    List<WishListItem> findByWishList(WishList wishList);

    WishListItem updateWishListItem(WishListItem wishListItem);

    WishListItem addBookToWishListItem(Book book, User user, int quant);

    WishListItem findById(Long id);

    void removeWishListItem(WishListItem wishListItem);

    WishListItem save(WishListItem wishListItem);

}
