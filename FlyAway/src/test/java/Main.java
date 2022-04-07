import entity.PlacesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            PlacesEntity pl = new PlacesEntity();
            pl.setId(1);
            pl.setName("Chicago");
            em.persist(pl);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
            emf.close();
        }

    }
}
