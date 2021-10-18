package net.javaguides.restfulapitest.model;

import javax.persistence.*;

@Entity
@Table(name = "books")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ISBN;

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private double price;


    public Book() {
        super();
    }

    public Book(String name, String genre, double price) {
        super();
        this.name = name;
        this.genre = genre;
        this.price = price;
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




}