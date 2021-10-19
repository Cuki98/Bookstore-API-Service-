package net.javaguides.restfulapitest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ISBN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    private List<WishList> wishlist;


    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private double price;
    @Column(name = "publisher")
    private String publisher;

    @Column(name = "description")
    private String description;

    @Column(name = "year_published")
    private int year_published;

    @Column(name = "copies_sold")
    private int copies_sold;

    @Column(name = "rating")
    private double rating;



    public Book() {
        super();
    }

    public Book(String name, String genre, double price,String publisher,int year_published,String description,int copies_sold, double rating) {
        super();
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.publisher = publisher;
        this.description = description;
        this.year_published = year_published;
        this.copies_sold = copies_sold;
        this.rating = rating;
    }
    public long getAuthor() {
        return author.getId();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear_published() {
        return year_published;
    }

    public void setYear_published(int year_published) {
        this.year_published = year_published;
    }

    public int getCopies_sold() {
        return copies_sold;
    }

    public void setCopies_sold(int copies_sold) {
        this.copies_sold = copies_sold;
    }

    public double getRating() {
        return rating;
    }

    public List<WishList> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<WishList> wishlist) {
        this.wishlist = wishlist;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }




}
