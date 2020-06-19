/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.blo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.entity.Account;

/**
 *
 * @author user
 */
public class AccountBLO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DreamTravelingPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Account checkLogin(String username, String password) {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT a FROM Account a "
                + "WHERE a.userId = :userId And a.password = :password";
        Query query = em.createQuery(jpql);
        query.setParameter("userId", username);
        query.setParameter("password", password);
        Account account;
        try {
            account = (Account) query.getSingleResult();
            return account;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
