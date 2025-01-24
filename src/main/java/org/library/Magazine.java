package org.library;


import jakarta.persistence.*;

@Entity
@Table(name = "magazine")
public class Magazine extends Publication {

    @Column(name = "periodicity")
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(String title, Integer yearOfPublication, Integer pages, Periodicity periodicity) {
        super(title, yearOfPublication, pages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                '}';
    }
}
