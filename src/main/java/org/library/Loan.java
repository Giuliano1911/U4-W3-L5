package org.library;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ISBN")
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    @Column(name = "excepted_return_date")
    private LocalDate exceptedReturnDate;

    @Column(name = "effective_return_date")
    private LocalDate effectiveReturnDate;

    public Loan() {
    }

    public Loan(Publication publication, User user, LocalDate loanDate) {
        this.publication = publication;
        this.user = user;
        this.loanDate = loanDate;
        this.exceptedReturnDate = loanDate.plusDays(30);
    }

    public Loan(Publication publication, User user, LocalDate loanDate, LocalDate effectiveReturnDate) {
        this.publication = publication;
        this.user = user;
        this.loanDate = loanDate;
        this.exceptedReturnDate = loanDate.plusDays(30);
        this.effectiveReturnDate = effectiveReturnDate;
    }

    public Long getId() {
        return id;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getExceptedReturnDate() {
        return exceptedReturnDate;
    }

    public void setExceptedReturnDate(LocalDate exceptedReturnDate) {
        this.exceptedReturnDate = exceptedReturnDate;
    }

    public LocalDate getEffectiveReturnDate() {
        return effectiveReturnDate;
    }

    public void setEffectiveReturnDate(LocalDate effectiveReturnDate) {
        this.effectiveReturnDate = effectiveReturnDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", publication=" + publication +
                ", user=" + user +
                ", loanDate=" + loanDate +
                ", exceptedReturnDate=" + exceptedReturnDate +
                ", effectiveReturnDate=" + effectiveReturnDate +
                '}';
    }
}
