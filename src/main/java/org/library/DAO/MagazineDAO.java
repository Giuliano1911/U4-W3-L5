package org.library.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.library.Magazine;

import java.util.List;

public class MagazineDAO implements DAO<Magazine,Long> {

    private EntityManager em;

    public MagazineDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Magazine magazine) {
        this.em.getTransaction().begin();
        this.em.persist(magazine);
        this.em.getTransaction().commit();
    }

    @Override
    public Magazine getById(Long id) {
        this.em.getTransaction().begin();
        Magazine magazineFound = this.em.find(Magazine.class, id);
        this.em.getTransaction().commit();
        return magazineFound;
    }

    @Override
    public void deleteById(Long id) {
        this.em.getTransaction().begin();
        Magazine magazineToDelete = this.em.find(Magazine.class, id);
        if (magazineToDelete != null) {
            this.em.remove(magazineToDelete);
            System.out.println("Rivista eliminata");
        } else System.out.println("Rivista non trovata");
        this.em.getTransaction().commit();
    }

    @Override
    public List<Magazine> getAll() {
        this.em.getTransaction().begin();
        List<Magazine> list = em.createQuery("SELECT m FROM Magazine m", Magazine.class).getResultList();
        this.em.getTransaction().commit();
        return list;
    }

    public List<Magazine> getByPublicationYear (Integer search){
        this.em.getTransaction().begin();
        TypedQuery<Magazine> query = em.createQuery("SELECT m FROM Magazine m WHERE m.yearOfPublication = :search",Magazine.class);
        List<Magazine> list = query.setParameter("search",search).getResultList();
        this.em.getTransaction().commit();
        return list;
    }

    public List<Magazine> searchByTitle (String search){
        this.em.getTransaction().begin();
        TypedQuery<Magazine> query = em.createQuery("SELECT m FROM Magazine m WHERE m.title LIKE CONCAT('%', :search, '%')",Magazine.class);
        List<Magazine> list = query.setParameter("search",search).getResultList();
        this.em.getTransaction().commit();
        return list;
    }
}
