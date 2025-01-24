package org.library;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends Publication {

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String title, Integer yearOfPublication, Integer pages, Genre genre, Author author) {
        super(title, yearOfPublication, pages);
        this.genre = genre;
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + getISBN() +
                ", title='" + getTitle() + '\'' +
                ", yearOfPublication=" + getYearOfPublication() +
                ", pages=" + getPages() +
                ", Author=" + getAuthor() +
                ", Genre=" + getGenre() +
                '}';
    }
}
