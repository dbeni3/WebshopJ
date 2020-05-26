package db;

import webshop.Orders;
import webshop.Product;
import webshop.Purchaser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPA {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

    public static List<Product> getProducts() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Product l ", Product.class).getResultList();
        } finally {
            em.close();
        }
    }
    public static List<Purchaser> getLastPurchaser() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Purchaser l ", Purchaser.class).getResultList();
        } finally {
            em.close();
        }
    }

    public static void createPurcasher(Purchaser purchaser) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(purchaser);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public static void createOrders(Orders orders) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(orders);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


}
