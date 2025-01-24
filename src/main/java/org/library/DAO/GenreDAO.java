package org.library.DAO;

import jakarta.persistence.EntityManager;
import org.library.Genre;

import java.util.List;

public class GenreDAO implements DAO<Genre,Long>{

    private EntityManager em;

    public GenreDAO(EntityManager em){
        this.em=em;
    }

    @Override
    public void save(Genre genre) {
        this.em.getTransaction().begin();
        this.em.persist(genre);
        this.em.getTransaction().commit();
    }

    @Override
    public Genre getById(Long id) {
        this.em.getTransaction().begin();
        Genre genreFound = this.em.find(Genre.class, id);
        this.em.getTransaction().commit();
        return genreFound;
    }

    @Override
    public void deleteById(Long id) {
        this.em.getTransaction().begin();
        Genre genreToDelete = this.em.find(Genre.class, id);
        if (genreToDelete != null) {
            this.em.remove(genreToDelete);
            System.out.println("Genere eliminato");
        } else System.out.println("Genere non trovato");
        this.em.getTransaction().commit();
    }

    @Override
    public List<Genre> getAll() {
        this.em.getTransaction().begin();
        List<Genre> list = em.createQuery("SELECT g FROM Genre g",Genre.class).getResultList();
        this.em.getTransaction().commit();
        return list;
    }
}
