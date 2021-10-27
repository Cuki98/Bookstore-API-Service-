package net.javaguides.restfulapitest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wishlist")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToMany(mappedBy = "wishList", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    private List<WishListItem> wishListItemList;


    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User user;

    public WishList()
    {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public List<WishListItem> getWishListItemList() {
        return wishListItemList;
    }

    public void setWishListItemList(List<WishListItem> wishListItemList) {
        this.wishListItemList = wishListItemList;
    }




}
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id",nullable = false)
//    private User user;
//
//    @OneToOne
//    private WishListInstance wishListInstance;
//
//    public WishList()
//    {
//        super();
//    }
//
//    public WishList( User user) {
//        super();
//
//        this.user = user;
//    }
//
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
