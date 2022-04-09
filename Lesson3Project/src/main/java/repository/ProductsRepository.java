package repository;

import entity.ProductsEntity;
import org.hibernate.Session;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {

    public static ProductsEntity getProduct(int id) {
        Transaction tr = null;
        ProductsEntity selectedProduct = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            String hql = "select e FROM ProductsEntity e where e.id = :productID";
            Query query = em.createQuery(hql);
            query.setParameter("productID", id);
            List results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                selectedProduct = (ProductsEntity) results.get(0);
            }
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
            emf.close();
        }
        return selectedProduct;
    }

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

    public static boolean productExists(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        long result = 0;
        try {
            String hql = "select count(e) from ProductsEntity e where e.id = ?1";
            Query query = em.createQuery(hql);
            query.setParameter(1,id);
            result = (Long)query.getSingleResult();
        } finally {
            em.close();
            emf.close();
        }
        return result == 1;
    }

    public static void updateProduct(int id, String details){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            String hql = "update ProductsEntity set details = :productDetails where id = :productID";
            Query query = em.createQuery(hql);
            query.setParameter("productID", id);
            query.setParameter("productDetails", details);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
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
