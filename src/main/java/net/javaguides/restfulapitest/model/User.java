package net.javaguides.restfulapitest.model;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CreditCard> creditCards = new HashSet<CreditCard>(0);

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WishList> wishList;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(String username, String password, String name, String email, String address) {
        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
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







}