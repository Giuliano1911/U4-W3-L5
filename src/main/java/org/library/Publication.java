package org.library;

import jakarta.persistence.*;

@Entity
@Table(name="publication")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ISBN;

    private String title;

    @Column(name="year_of_publication")
    private Integer yearOfPublication;

    private Integer pages;

    public Publication() {
    }

    public Publication(String title, Integer yearOfPublication, Integer pages) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.pages = pages;
    }

    public Long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", pages=" + pages +
                '}';
    }
}
