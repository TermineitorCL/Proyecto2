/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Data.Produccion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Data.UnidadMedida;
import Data.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author siberion
 */
public class ProduccionJpaController implements Serializable {

    public ProduccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produccion produccion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UnidadMedida unidadMedidaId = produccion.getUnidadMedidaId();
            if (unidadMedidaId != null) {
                unidadMedidaId = em.getReference(unidadMedidaId.getClass(), unidadMedidaId.getId());
                produccion.setUnidadMedidaId(unidadMedidaId);
            }
            Producto productoId = produccion.getProductoId();
            if (productoId != null) {
                productoId = em.getReference(productoId.getClass(), productoId.getId());
                produccion.setProductoId(productoId);
            }
            em.persist(produccion);
            if (unidadMedidaId != null) {
                unidadMedidaId.getProduccionCollection().add(produccion);
                unidadMedidaId = em.merge(unidadMedidaId);
            }
            if (productoId != null) {
                productoId.getProduccionCollection().add(produccion);
                productoId = em.merge(productoId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produccion produccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produccion persistentProduccion = em.find(Produccion.class, produccion.getId());
            UnidadMedida unidadMedidaIdOld = persistentProduccion.getUnidadMedidaId();
            UnidadMedida unidadMedidaIdNew = produccion.getUnidadMedidaId();
            Producto productoIdOld = persistentProduccion.getProductoId();
            Producto productoIdNew = produccion.getProductoId();
            if (unidadMedidaIdNew != null) {
                unidadMedidaIdNew = em.getReference(unidadMedidaIdNew.getClass(), unidadMedidaIdNew.getId());
                produccion.setUnidadMedidaId(unidadMedidaIdNew);
            }
            if (productoIdNew != null) {
                productoIdNew = em.getReference(productoIdNew.getClass(), productoIdNew.getId());
                produccion.setProductoId(productoIdNew);
            }
            produccion = em.merge(produccion);
            if (unidadMedidaIdOld != null && !unidadMedidaIdOld.equals(unidadMedidaIdNew)) {
                unidadMedidaIdOld.getProduccionCollection().remove(produccion);
                unidadMedidaIdOld = em.merge(unidadMedidaIdOld);
            }
            if (unidadMedidaIdNew != null && !unidadMedidaIdNew.equals(unidadMedidaIdOld)) {
                unidadMedidaIdNew.getProduccionCollection().add(produccion);
                unidadMedidaIdNew = em.merge(unidadMedidaIdNew);
            }
            if (productoIdOld != null && !productoIdOld.equals(productoIdNew)) {
                productoIdOld.getProduccionCollection().remove(produccion);
                productoIdOld = em.merge(productoIdOld);
            }
            if (productoIdNew != null && !productoIdNew.equals(productoIdOld)) {
                productoIdNew.getProduccionCollection().add(produccion);
                productoIdNew = em.merge(productoIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produccion.getId();
                if (findProduccion(id) == null) {
                    throw new NonexistentEntityException("The produccion with id " + id + " no longer exists.");
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
            Produccion produccion;
            try {
                produccion = em.getReference(Produccion.class, id);
                produccion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produccion with id " + id + " no longer exists.", enfe);
            }
            UnidadMedida unidadMedidaId = produccion.getUnidadMedidaId();
            if (unidadMedidaId != null) {
                unidadMedidaId.getProduccionCollection().remove(produccion);
                unidadMedidaId = em.merge(unidadMedidaId);
            }
            Producto productoId = produccion.getProductoId();
            if (productoId != null) {
                productoId.getProduccionCollection().remove(produccion);
                productoId = em.merge(productoId);
            }
            em.remove(produccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produccion> findProduccionEntities() {
        return findProduccionEntities(true, -1, -1);
    }

    public List<Produccion> findProduccionEntities(int maxResults, int firstResult) {
        return findProduccionEntities(false, maxResults, firstResult);
    }

    private List<Produccion> findProduccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produccion.class));
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

    public Produccion findProduccion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getProduccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produccion> rt = cq.from(Produccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
