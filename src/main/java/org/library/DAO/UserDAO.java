package org.library.DAO;

import jakarta.persistence.EntityManager;
import org.library.User;

import java.util.List;

public class UserDAO implements DAO<User,Long> {

    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(User user) {
        this.em.getTransaction().begin();
        this.em.persist(user);
        this.em.getTransaction().commit();
    }

    @Override
    public User getById(Long id) {
        this.em.getTransaction().begin();
        User userFound = this.em.find(User.class, id);
        this.em.getTransaction().commit();
        return userFound;
    }

    @Override
    public void deleteById(Long id) {
        this.em.getTransaction().begin();
        User userToDelete = this.em.find(User.class, id);
        if (userToDelete != null) {
            this.em.remove(userToDelete);
            System.out.println("Utente eliminato");
        } else System.out.println("Utente non trovato");
        this.em.getTransaction().commit();
    }

    @Override
    public List<User> getAll() {
        this.em.getTransaction().begin();
        List<User> list = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        this.em.getTransaction().commit();
        return list;
    }
}
