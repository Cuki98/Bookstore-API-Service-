package net.javaguides.restfulapitest.service;

import net.javaguides.restfulapitest.model.WishList;
import org.springframework.stereotype.Service;

@Service
public interface WishListService {
    WishList updateWishList(WishList wishList);

    void clearWishList(WishList wishList);

}