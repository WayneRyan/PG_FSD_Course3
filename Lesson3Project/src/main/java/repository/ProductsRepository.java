package repository;

import entity.ProductsEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {

    public static void  addProduct(int id, String details){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            ProductsEntity pe = new ProductsEntity();
            pe.setId(id);
            pe.setDetails(details);
            em.persist(pe);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
            emf.close();
        }
    }

    public static List<ProductsEntity> getAllProducts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        List<ProductsEntity> logEntries = new ArrayList<>();
        try {
            et.begin();
            String hql = "select e from ProductsEntity e";
            Query query = em.createQuery(hql);
            logEntries = query.getResultList();
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
            emf.close();
        }
        return logEntries;
    }
}
