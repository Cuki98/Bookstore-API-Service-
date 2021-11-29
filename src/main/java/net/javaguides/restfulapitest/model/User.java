package net.javaguides.restfulapitest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 */

@Entity
@Table(name = "users")
public class User {
    //Create a User with username(email), password and optional fields (name, email address, home address)
    //need to add in credit cards
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;
    @Column(unique = true)
    private String wishlist_name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private Set<Rating> ratings = new HashSet<Rating>(0);

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String username, String password, String name, String email, String address) {
        super();
        this.username = email;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return email;
    }
    public void setUsername(String username) {
        this.email = username;

    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }
    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    public Set<Rating> getRatings() {
        return ratings;
    }
    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
}
