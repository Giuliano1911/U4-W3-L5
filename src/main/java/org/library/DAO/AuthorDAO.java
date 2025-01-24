package org.library.DAO;

import jakarta.persistence.EntityManager;
import org.library.Author;

import java.util.List;

public class AuthorDAO implements DAO<Author,Long>{

    private EntityManager em;

    public AuthorDAO(EntityManager em){
        this.em=em;
    }

    @Override
    public void save(Author author) {
        this.em.getTransaction().begin();
        this.em.persist(author);
        this.em.getTransaction().commit();
    }

    @Override
    public Author getById(Long id) {
        this.em.getTransaction().begin();
        Author authorFound = this.em.find(Author.class, id);
        this.em.getTransaction().commit();
        return authorFound;
    }

    @Override
    public void deleteById(Long id) {
        this.em.getTransaction().begin();
        Author authorToDelete = this.em.find(Author.class, id);
        if (authorToDelete != null) {
            this.em.remove(authorToDelete);
            System.out.println("Autore eliminato");
        } else System.out.println("Autore non trovato");
        this.em.getTransaction().commit();
    }

    @Override
    public List<Author> getAll() {
        this.em.getTransaction().begin();
        List<Author> list = em.createQuery("SELECT a FROM Author a",Author.class).getResultList();
        this.em.getTransaction().commit();
        return list;
    }
}
