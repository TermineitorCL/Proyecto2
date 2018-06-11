/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Data.DetalleReceta;
import Data.DetalleRecetaPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Data.Producto;
import Data.Receta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author siberion
 */
public class DetalleRecetaJpaController implements Serializable {

    public DetalleRecetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleReceta detalleReceta) throws PreexistingEntityException, Exception {
        if (detalleReceta.getDetalleRecetaPK() == null) {
            detalleReceta.setDetalleRecetaPK(new DetalleRecetaPK());
        }
        detalleReceta.getDetalleRecetaPK().setRecetaId(detalleReceta.getReceta().getId());
        detalleReceta.getDetalleRecetaPK().setProductoId(detalleReceta.getProducto().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = detalleReceta.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getId());
                detalleReceta.setProducto(producto);
            }
            Receta receta = detalleReceta.getReceta();
            if (receta != null) {
                receta = em.getReference(receta.getClass(), receta.getId());
                detalleReceta.setReceta(receta);
            }
            em.persist(detalleReceta);
            if (producto != null) {
                producto.getDetalleRecetaCollection().add(detalleReceta);
                producto = em.merge(producto);
            }
            if (receta != null) {
                receta.getDetalleRecetaCollection().add(detalleReceta);
                receta = em.merge(receta);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalleReceta(detalleReceta.getDetalleRecetaPK()) != null) {
                throw new PreexistingEntityException("DetalleReceta " + detalleReceta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleReceta detalleReceta) throws NonexistentEntityException, Exception {
        detalleReceta.getDetalleRecetaPK().setRecetaId(detalleReceta.getReceta().getId());
        detalleReceta.getDetalleRecetaPK().setProductoId(detalleReceta.getProducto().getId());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleReceta persistentDetalleReceta = em.find(DetalleReceta.class, detalleReceta.getDetalleRecetaPK());
            Producto productoOld = persistentDetalleReceta.getProducto();
            Producto productoNew = detalleReceta.getProducto();
            Receta recetaOld = persistentDetalleReceta.getReceta();
            Receta recetaNew = detalleReceta.getReceta();
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getId());
                detalleReceta.setProducto(productoNew);
            }
            if (recetaNew != null) {
                recetaNew = em.getReference(recetaNew.getClass(), recetaNew.getId());
                detalleReceta.setReceta(recetaNew);
            }
            detalleReceta = em.merge(detalleReceta);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getDetalleRecetaCollection().remove(detalleReceta);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getDetalleRecetaCollection().add(detalleReceta);
                productoNew = em.merge(productoNew);
            }
            if (recetaOld != null && !recetaOld.equals(recetaNew)) {
                recetaOld.getDetalleRecetaCollection().remove(detalleReceta);
                recetaOld = em.merge(recetaOld);
            }
            if (recetaNew != null && !recetaNew.equals(recetaOld)) {
                recetaNew.getDetalleRecetaCollection().add(detalleReceta);
                recetaNew = em.merge(recetaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetalleRecetaPK id = detalleReceta.getDetalleRecetaPK();
                if (findDetalleReceta(id) == null) {
                    throw new NonexistentEntityException("The detalleReceta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetalleRecetaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleReceta detalleReceta;
            try {
                detalleReceta = em.getReference(DetalleReceta.class, id);
                detalleReceta.getDetalleRecetaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleReceta with id " + id + " no longer exists.", enfe);
            }
            Producto producto = detalleReceta.getProducto();
            if (producto != null) {
                producto.getDetalleRecetaCollection().remove(detalleReceta);
                producto = em.merge(producto);
            }
            Receta receta = detalleReceta.getReceta();
            if (receta != null) {
                receta.getDetalleRecetaCollection().remove(detalleReceta);
                receta = em.merge(receta);
            }
            em.remove(detalleReceta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleReceta> findDetalleRecetaEntities() {
        return findDetalleRecetaEntities(true, -1, -1);
    }

    public List<DetalleReceta> findDetalleRecetaEntities(int maxResults, int firstResult) {
        return findDetalleRecetaEntities(false, maxResults, firstResult);
    }

    private List<DetalleReceta> findDetalleRecetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleReceta.class));
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

    public DetalleReceta findDetalleReceta(DetalleRecetaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleReceta.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleRecetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleReceta> rt = cq.from(DetalleReceta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
