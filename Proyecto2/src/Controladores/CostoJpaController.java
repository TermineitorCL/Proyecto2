/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Data.Costo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Data.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author siberion
 */
public class CostoJpaController implements Serializable {

    public CostoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Costo costo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto productoId = costo.getProductoId();
            if (productoId != null) {
                productoId = em.getReference(productoId.getClass(), productoId.getId());
                costo.setProductoId(productoId);
            }
            em.persist(costo);
            if (productoId != null) {
                productoId.getCostoCollection().add(costo);
                productoId = em.merge(productoId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Costo costo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Costo persistentCosto = em.find(Costo.class, costo.getId());
            Producto productoIdOld = persistentCosto.getProductoId();
            Producto productoIdNew = costo.getProductoId();
            if (productoIdNew != null) {
                productoIdNew = em.getReference(productoIdNew.getClass(), productoIdNew.getId());
                costo.setProductoId(productoIdNew);
            }
            costo = em.merge(costo);
            if (productoIdOld != null && !productoIdOld.equals(productoIdNew)) {
                productoIdOld.getCostoCollection().remove(costo);
                productoIdOld = em.merge(productoIdOld);
            }
            if (productoIdNew != null && !productoIdNew.equals(productoIdOld)) {
                productoIdNew.getCostoCollection().add(costo);
                productoIdNew = em.merge(productoIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = costo.getId();
                if (findCosto(id) == null) {
                    throw new NonexistentEntityException("The costo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Costo costo;
            try {
                costo = em.getReference(Costo.class, id);
                costo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The costo with id " + id + " no longer exists.", enfe);
            }
            Producto productoId = costo.getProductoId();
            if (productoId != null) {
                productoId.getCostoCollection().remove(costo);
                productoId = em.merge(productoId);
            }
            em.remove(costo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Costo> findCostoEntities() {
        return findCostoEntities(true, -1, -1);
    }

    public List<Costo> findCostoEntities(int maxResults, int firstResult) {
        return findCostoEntities(false, maxResults, firstResult);
    }

    private List<Costo> findCostoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Costo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Costo findCosto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Costo.class, id);
        } finally {
            em.close();
        }
    }

    public int getCostoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Costo> rt = cq.from(Costo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
