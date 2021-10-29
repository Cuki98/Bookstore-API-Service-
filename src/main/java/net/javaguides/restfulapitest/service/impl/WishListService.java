package net.javaguides.restfulapitest.service.impl;

import net.javaguides.restfulapitest.model.WishList;
import net.javaguides.restfulapitest.repository.WishListRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<WishList> readWishList(Long userId) {
        return wishListRepository.findAllByUserId(userId);
    }
}

