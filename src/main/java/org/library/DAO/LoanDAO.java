package org.library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.library.Loan;
import org.library.Publication;

import java.util.List;

public class LoanDAO implements DAO<Loan, Long> {

    private EntityManager em;

    public LoanDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Loan loan) {
        this.em.getTransaction().begin();
        this.em.persist(loan);
        this.em.getTransaction().commit();
    }

    @Override
    public Loan getById(Long id) {
        this.em.getTransaction().begin();
        Loan loanFound = this.em.find(Loan.class, id);
        this.em.getTransaction().commit();
        return loanFound;
    }

    @Override
    public void deleteById(Long id) {
        this.em.getTransaction().begin();
        Loan loanToDelete = this.em.find(Loan.class, id);
        if (loanToDelete != null) {
            this.em.remove(loanToDelete);
            System.out.println("Prestito eliminato");
        } else System.out.println("Prestito non trovato");
        this.em.getTransaction().commit();
    }

    @Override
    public List<Loan> getAll() {
        this.em.getTransaction().begin();
        List<Loan> list = em.createQuery("SELECT l FROM Loan l", Loan.class).getResultList();
        this.em.getTransaction().commit();
        return list;
    }

    public List<Publication> getActivePublicationsByCardNumber(Long search) {
        this.em.getTransaction().begin();
        TypedQuery<Publication> query = em.createQuery("""
                SELECT p
                FROM Publication p, Loan l
                WHERE l.effectiveReturnDate IS NULL
                AND l.user.cardNumber = :search
                AND l.isbn.id = p.id""", Publication.class);
        List<Publication> list = query.setParameter("search", search).getResultList();
        this.em.getTransaction().commit();
        return list;
    }

    public List<Loan> getAllExpiredLoans() {
        this.em.getTransaction().begin();
        List<Loan> list = em.createQuery("""
                SELECT l FROM Loan l
                WHERE l.effectiveReturnDate IS NULL
                AND l.expectedReturnDate < CURRENT DATE""", Loan.class).getResultList();
        this.em.getTransaction().commit();
        return list;
    }
}