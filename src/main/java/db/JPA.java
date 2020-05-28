package db;

import webshop.objects.Orders;
import webshop.objects.Product;
import webshop.objects.Purchaser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * JPA class allows to work with JPA.
 *
 */
public class JPA {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

    /**
     * Return the list of {@code Products}, from the Database.
     *
     * @return the list of {@code Products}, from the Database.
     */
    public static List<Product> getProducts() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Product l ", Product.class).getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Return the list of {@code Purchaser}, from the Database.
     *
     * @return the list of {@code Purchaser}, from the Database.
     */
    public static List<Purchaser> getPurchaser() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Purchaser l ", Purchaser.class).getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Inserts a row into the Purchaser table in the database,row represents one purchaser.
     *
     * @param purchaser is contains the data.
     */
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

    /**
     * Inserts a row into the Orders table in the database,a row represents one order.
     *
     * @param orders is contains the data.
     */
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
