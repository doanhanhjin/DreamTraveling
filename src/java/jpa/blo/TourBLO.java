/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.blo;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.entity.Tour;

/**
 *
 * @author user
 */
public class TourBLO {

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

    public boolean createNewTour(Tour tour) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(tour);
            em.getTransaction().commit();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
    }

//    public Tour searchByPlace(String place) {
//        EntityManager em = emf.createEntityManager();
//
//        String jpql = "SELECT t FROM Tour t WHERE t.tourName LIKE :tourName";
//        Query query = em.createQuery(jpql);
//        query.setParameter("tourName", place);
//        Tour tour;
//        try {
//            tour = (Tour) query.getSingleResult();
//            return tour;
//        } catch (NoResultException ex) {
//            return null;
//        }
//    }
    public List<Tour> searchByDate(Date date) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Tour> result = em.createNamedQuery("Tour.findByDate", Tour.class)
                    .setParameter("toDate", date)
                    .getResultList();
            if (result != null && !result.isEmpty()) {
                return result;
            }
        } catch (Exception e) {
            Logger.getLogger(TourBLO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    public List<Tour> searchByPrice(int min, int max) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Tour> result = em.createNamedQuery("Tour.findByPrice", Tour.class)
                    .setParameter("minPrice", min)
                    .setParameter("maxPrice", max)
                    .getResultList();
            if (result != null && !result.isEmpty()) {
                return result;
            }
        } catch (Exception e) {
            Logger.getLogger(TourBLO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    public List<Tour> searchByPlace(String place) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Tour> result = em.createNamedQuery("Tour.findByToPlace", Tour.class)
                    .setParameter("toPlace", "%" + place + "%")
                    .getResultList();
            if (result != null && !result.isEmpty()) {
                return result;
            }
        } catch (Exception e) {
            Logger.getLogger(TourBLO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }
   
}
