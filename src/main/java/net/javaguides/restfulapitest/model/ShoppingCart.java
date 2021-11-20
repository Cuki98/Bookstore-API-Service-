package net.javaguides.restfulapitest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    @JsonIgnore
    private User user;


    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;

    public ShoppingCart()
    {

    }
    public ShoppingCart(User user,Book book)
    {
        this.user=user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

