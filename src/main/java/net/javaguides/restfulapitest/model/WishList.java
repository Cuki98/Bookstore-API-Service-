package net.javaguides.restfulapitest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wishlist")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(nullable = false,name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name ="book_id")
    private Book book;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WishList()
    {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
