package net.javaguides.restfulapitest.model;


import javax.persistence.*;

@Entity
public class WishListToBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name="wihslist_item_id")
    private WishListItem wishListItem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public WishListItem getWishListItem() {
        return wishListItem;
    }

    public void setWishListItem(WishListItem wishListItem) {
        this.wishListItem = wishListItem;
    }
}
