package com.asius.bookshop.Entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String title;
    private String description;
    @Column(length = 1000)
    private String synopsis;
    private String img;
    private String author;
    private String editorial;
    private String dayPublication;
    private Integer pages;
    private String formats;
    private String isbn;
    private String genreLiterary;
    private String document;
    private String language;
    private String cost;
    private String status;
    public BooksEntity(){

    }
}
