package net.javaguides.restfulapitest.service;


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

    public void createWishList(WishList wishList)
    {
        wishListRepository.save(wishList);
    }
    public List<WishList> readWishList(long userId) {
        return wishListRepository.findAllByUserId(userId);
    }
}
