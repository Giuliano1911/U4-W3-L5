package org.library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.library.Book;

import java.util.List;

public class BookDAO implements DAO<Book,Long>{

    private EntityManager em;

    public BookDAO(EntityManager em){
        this.em=em;
    }

    @Override
    public void save(Book book) {
        this.em.getTransaction().begin();
        this.em.persist(book);
        this.em.getTransaction().commit();
    }

    @Override
    public Book getById(Long id) {
        this.em.getTransaction().begin();
        Book bookFound = this.em.find(Book.class, id);
        this.em.getTransaction().commit();
        return bookFound;
    }

    @Override
    public void deleteById(Long id) {
        this.em.getTransaction().begin();
        Book bookToDelete = this.em.find(Book.class, id);
        if (bookToDelete != null) {
            this.em.remove(bookToDelete);
            System.out.println("Libro eliminato");
        } else System.out.println("Libro non trovato");
        this.em.getTransaction().commit();
    }

    @Override
    public List<Book> getAll() {
        this.em.getTransaction().begin();
        List<Book> list = em.createQuery("SELECT b FROM Book b",Book.class).getResultList();
        this.em.getTransaction().commit();
        return list;
    }

    public List<Book> getByPublicationYear (Integer search){
        this.em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.yearOfPublication = :search",Book.class);
        List<Book> list = query.setParameter("search",search).getResultList();
        this.em.getTransaction().commit();
        return list;
    }

    public List<Book> searchByAuthor (String search){
        this.em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.author.name = :search",Book.class);
        List<Book> list = query.setParameter("search",search).getResultList();
        this.em.getTransaction().commit();
        return list;
    }

    public List<Book> searchByTitle (String search){
        this.em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE CONCAT('%', :search, '%')",Book.class);
        List<Book> list = query.setParameter("search",search).getResultList();
        this.em.getTransaction().commit();
        return list;
    }
}
