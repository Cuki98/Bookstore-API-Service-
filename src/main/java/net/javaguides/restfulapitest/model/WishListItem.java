package net.javaguides.restfulapitest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class WishListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quant;

    @OneToOne
    private Book book;

    @OneToMany(mappedBy = "wishListItem")
    @JsonIgnore
    private List<WishListToBook> wishListToBookList;

    @ManyToOne
    @JoinColumn(name="wishlist_id")
    private WishList wishList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<WishListToBook> getWishListToBookList() {
        return wishListToBookList;
    }

    public void setWishListToBookList(List<WishListToBook> wishListToBookList) {
        this.wishListToBookList = wishListToBookList;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }
}
