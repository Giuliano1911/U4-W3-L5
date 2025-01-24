package org.main;

import jakarta.persistence.EntityManager;
import org.library.*;
import org.library.DAO.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        try {
            AuthorDAO authorDAO = new AuthorDAO(em);
            BookDAO bookDAO = new BookDAO(em);
            GenreDAO genreDAO = new GenreDAO(em);
            LoanDAO loanDAO = new LoanDAO(em);
            MagazineDAO magazineDAO = new MagazineDAO(em);
            UserDAO userDAO = new UserDAO(em);

            //es.1

            /*

            //Dato un autore ed un libro recuperati dal db possiamo creare un new Book ed usare .save() per aggiungerlo al db.

            Author author1 = authorDAO.getById(1L);
            Genre genre1 = genreDAO.getById(1L);

            Book book1 = new Book("1984",1949,350,genre1,author1);
            bookDAO.save(book1);

            //Utilizzando l'ENUM possiamo creare un Magazine ed aggiungerlo al db

            Magazine magazine1 = new Magazine("Critica Sociale",1910,200,Periodicity.WEEKLY);
            magazineDAO.save(magazine1);
             */


            //es.2

            /*

            //Utilizzando il metodo DAO.deleteById sarà possibile cancellare sia dalla tabella publications che dalla tabella books o magazines

            bookDAO.deleteById(1L);

            magazineDAO.deleteById(1L);

             */


            //es.3

            /*

            //Utilizzando getById sarà possibile cercare una publication(book o magazine) tramite il suo codice ISBN

            bookDAO.getById(1L);

            magazineDAO.getById(1L);

             */


            //es.4

            /*

            //Basterà utilizzare il metodo getByPublicationYear ed inserire l'anno per avere la lista dei libri o delle riviste pubblicate in quell'anno

            System.out.println(bookDAO.getByPublicationYear(2000));

            System.out.println(magazineDAO.getByPublicationYear(1990));

             */


            //es.5

            //Cercando il nome dell'autore si riceverà una lista con tutti i libri scritti da quell'autore

            //System.out.println(bookDAO.searchByAuthor("George Orwell"));


            //es.6

            /*

            //Si può cercare per stringa parziale

            System.out.println(bookDAO.searchByTitle("19"));

            System.out.println(magazineDAO.searchByTitle("ritic"));

             */


            //es.7

            //Così è possibile ricevere una lista con tutte le publication dei loan non ancora restituiti dell'utente con CardNumber 1

            //System.out.println(loanDAO.getActivePublicationsByCardNumber(1L));


            //es.8

            //Con questo metodo verranno stampati in console tutti i prestiti scaduti e non restituiti

            //System.out.println(loanDAO.getAllExpiredLoans());


        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            EntityManagerUtil.close();
        }
    }
}