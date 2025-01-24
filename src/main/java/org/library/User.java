package org.library;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNumber;

    private String name;

    private String surname;

    private LocalDate birth;

    public User() {
    }

    public User(String name, String surname, LocalDate birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public Long getCard_number() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "card_number=" + cardNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                '}';
    }
}
