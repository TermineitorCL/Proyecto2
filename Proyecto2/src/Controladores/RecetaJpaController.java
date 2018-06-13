/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Data.Producto;
import Data.UnidadMedida;
import Data.DetalleReceta;
import Data.Receta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author siberion
 */
public class RecetaJpaController implements Serializable {

    public RecetaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Receta receta) {
        if (receta.getDetalleRecetaCollection() == null) {
            receta.setDetalleRecetaCollection(new ArrayList<DetalleReceta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto productoId = receta.getProductoId();
            if (productoId != null) {
                productoId = em.getReference(productoId.getClass(), productoId.getId());
                receta.setProductoId(productoId);
            }
            UnidadMedida unidadMedidadId = receta.getUnidadMedidadId();
            if (unidadMedidadId != null) {
                unidadMedidadId = em.getReference(unidadMedidadId.getClass(), unidadMedidadId.getId());
                receta.setUnidadMedidadId(unidadMedidadId);
            }
            Collection<DetalleReceta> attachedDetalleRecetaCollection = new ArrayList<DetalleReceta>();
            for (DetalleReceta detalleRecetaCollectionDetalleRecetaToAttach : receta.getDetalleRecetaCollection()) {
                detalleRecetaCollectionDetalleRecetaToAttach = em.getReference(detalleRecetaCollectionDetalleRecetaToAttach.getClass(), detalleRecetaCollectionDetalleRecetaToAttach.getDetalleRecetaPK());
                attachedDetalleRecetaCollection.add(detalleRecetaCollectionDetalleRecetaToAttach);
            }
            receta.setDetalleRecetaCollection(attachedDetalleRecetaCollection);
            em.persist(receta);
            if (productoId != null) {
                productoId.getRecetaCollection().add(receta);
                productoId = em.merge(productoId);
            }
            if (unidadMedidadId != null) {
                unidadMedidadId.getRecetaCollection().add(receta);
                unidadMedidadId = em.merge(unidadMedidadId);
            }
            for (DetalleReceta detalleRecetaCollectionDetalleReceta : receta.getDetalleRecetaCollection()) {
                Receta oldRecetaOfDetalleRecetaCollectionDetalleReceta = detalleRecetaCollectionDetalleReceta.getReceta();
                detalleRecetaCollectionDetalleReceta.setReceta(receta);
                detalleRecetaCollectionDetalleReceta = em.merge(detalleRecetaCollectionDetalleReceta);
                if (oldRecetaOfDetalleRecetaCollectionDetalleReceta != null) {
                    oldRecetaOfDetalleRecetaCollectionDetalleReceta.getDetalleRecetaCollection().remove(detalleRecetaCollectionDetalleReceta);
                    oldRecetaOfDetalleRecetaCollectionDetalleReceta = em.merge(oldRecetaOfDetalleRecetaCollectionDetalleReceta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Receta receta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Receta persistentReceta = em.find(Receta.class, receta.getId());
            Producto productoIdOld = persistentReceta.getProductoId();
            Producto productoIdNew = receta.getProductoId();
            UnidadMedida unidadMedidadIdOld = persistentReceta.getUnidadMedidadId();
            UnidadMedida unidadMedidadIdNew = receta.getUnidadMedidadId();
            Collection<DetalleReceta> detalleRecetaCollectionOld = persistentReceta.getDetalleRecetaCollection();
            Collection<DetalleReceta> detalleRecetaCollectionNew = receta.getDetalleRecetaCollection();
            List<String> illegalOrphanMessages = null;
            for (DetalleReceta detalleRecetaCollectionOldDetalleReceta : detalleRecetaCollectionOld) {
                if (!detalleRecetaCollectionNew.contains(detalleRecetaCollectionOldDetalleReceta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleReceta " + detalleRecetaCollectionOldDetalleReceta + " since its receta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (productoIdNew != null) {
                productoIdNew = em.getReference(productoIdNew.getClass(), productoIdNew.getId());
                receta.setProductoId(productoIdNew);
            }
            if (unidadMedidadIdNew != null) {
                unidadMedidadIdNew = em.getReference(unidadMedidadIdNew.getClass(), unidadMedidadIdNew.getId());
                receta.setUnidadMedidadId(unidadMedidadIdNew);
            }
            Collection<DetalleReceta> attachedDetalleRecetaCollectionNew = new ArrayList<DetalleReceta>();
            for (DetalleReceta detalleRecetaCollectionNewDetalleRecetaToAttach : detalleRecetaCollectionNew) {
                detalleRecetaCollectionNewDetalleRecetaToAttach = em.getReference(detalleRecetaCollectionNewDetalleRecetaToAttach.getClass(), detalleRecetaCollectionNewDetalleRecetaToAttach.getDetalleRecetaPK());
                attachedDetalleRecetaCollectionNew.add(detalleRecetaCollectionNewDetalleRecetaToAttach);
            }
            detalleRecetaCollectionNew = attachedDetalleRecetaCollectionNew;
            receta.setDetalleRecetaCollection(detalleRecetaCollectionNew);
            receta = em.merge(receta);
            if (productoIdOld != null && !productoIdOld.equals(productoIdNew)) {
                productoIdOld.getRecetaCollection().remove(receta);
                productoIdOld = em.merge(productoIdOld);
            }
            if (productoIdNew != null && !productoIdNew.equals(productoIdOld)) {
                productoIdNew.getRecetaCollection().add(receta);
                productoIdNew = em.merge(productoIdNew);
            }
            if (unidadMedidadIdOld != null && !unidadMedidadIdOld.equals(unidadMedidadIdNew)) {
                unidadMedidadIdOld.getRecetaCollection().remove(receta);
                unidadMedidadIdOld = em.merge(unidadMedidadIdOld);
            }
            if (unidadMedidadIdNew != null && !unidadMedidadIdNew.equals(unidadMedidadIdOld)) {
                unidadMedidadIdNew.getRecetaCollection().add(receta);
                unidadMedidadIdNew = em.merge(unidadMedidadIdNew);
            }
            for (DetalleReceta detalleRecetaCollectionNewDetalleReceta : detalleRecetaCollectionNew) {
                if (!detalleRecetaCollectionOld.contains(detalleRecetaCollectionNewDetalleReceta)) {
                    Receta oldRecetaOfDetalleRecetaCollectionNewDetalleReceta = detalleRecetaCollectionNewDetalleReceta.getReceta();
                    detalleRecetaCollectionNewDetalleReceta.setReceta(receta);
                    detalleRecetaCollectionNewDetalleReceta = em.merge(detalleRecetaCollectionNewDetalleReceta);
                    if (oldRecetaOfDetalleRecetaCollectionNewDetalleReceta != null && !oldRecetaOfDetalleRecetaCollectionNewDetalleReceta.equals(receta)) {
                        oldRecetaOfDetalleRecetaCollectionNewDetalleReceta.getDetalleRecetaCollection().remove(detalleRecetaCollectionNewDetalleReceta);
                        oldRecetaOfDetalleRecetaCollectionNewDetalleReceta = em.merge(oldRecetaOfDetalleRecetaCollectionNewDetalleReceta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = receta.getId();
                if (findReceta(id) == null) {
                    throw new NonexistentEntityException("The receta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Receta receta;
            try {
                receta = em.getReference(Receta.class, id);
                receta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The receta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetalleReceta> detalleRecetaCollectionOrphanCheck = receta.getDetalleRecetaCollection();
            for (DetalleReceta detalleRecetaCollectionOrphanCheckDetalleReceta : detalleRecetaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Receta (" + receta + ") cannot be destroyed since the DetalleReceta " + detalleRecetaCollectionOrphanCheckDetalleReceta + " in its detalleRecetaCollection field has a non-nullable receta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Producto productoId = receta.getProductoId();
            if (productoId != null) {
                productoId.getRecetaCollection().remove(receta);
                productoId = em.merge(productoId);
            }
            UnidadMedida unidadMedidadId = receta.getUnidadMedidadId();
            if (unidadMedidadId != null) {
                unidadMedidadId.getRecetaCollection().remove(receta);
                unidadMedidadId = em.merge(unidadMedidadId);
            }
            em.remove(receta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Receta> findRecetaEntities() {
        return findRecetaEntities(true, -1, -1);
    }

    public List<Receta> findRecetaEntities(int maxResults, int firstResult) {
        return findRecetaEntities(false, maxResults, firstResult);
    }

    private List<Receta> findRecetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Receta.class));
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

    public Receta findReceta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Receta.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Receta> rt = cq.from(Receta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
