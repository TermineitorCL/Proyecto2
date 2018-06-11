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
import Data.Receta;
import java.util.ArrayList;
import java.util.Collection;
import Data.Producto;
import Data.Produccion;
import Data.UnidadMedida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author siberion
 */
public class UnidadMedidaJpaController implements Serializable {

    public UnidadMedidaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UnidadMedida unidadMedida) {
        if (unidadMedida.getRecetaCollection() == null) {
            unidadMedida.setRecetaCollection(new ArrayList<Receta>());
        }
        if (unidadMedida.getProductoCollection() == null) {
            unidadMedida.setProductoCollection(new ArrayList<Producto>());
        }
        if (unidadMedida.getProduccionCollection() == null) {
            unidadMedida.setProduccionCollection(new ArrayList<Produccion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Receta> attachedRecetaCollection = new ArrayList<Receta>();
            for (Receta recetaCollectionRecetaToAttach : unidadMedida.getRecetaCollection()) {
                recetaCollectionRecetaToAttach = em.getReference(recetaCollectionRecetaToAttach.getClass(), recetaCollectionRecetaToAttach.getId());
                attachedRecetaCollection.add(recetaCollectionRecetaToAttach);
            }
            unidadMedida.setRecetaCollection(attachedRecetaCollection);
            Collection<Producto> attachedProductoCollection = new ArrayList<Producto>();
            for (Producto productoCollectionProductoToAttach : unidadMedida.getProductoCollection()) {
                productoCollectionProductoToAttach = em.getReference(productoCollectionProductoToAttach.getClass(), productoCollectionProductoToAttach.getId());
                attachedProductoCollection.add(productoCollectionProductoToAttach);
            }
            unidadMedida.setProductoCollection(attachedProductoCollection);
            Collection<Produccion> attachedProduccionCollection = new ArrayList<Produccion>();
            for (Produccion produccionCollectionProduccionToAttach : unidadMedida.getProduccionCollection()) {
                produccionCollectionProduccionToAttach = em.getReference(produccionCollectionProduccionToAttach.getClass(), produccionCollectionProduccionToAttach.getId());
                attachedProduccionCollection.add(produccionCollectionProduccionToAttach);
            }
            unidadMedida.setProduccionCollection(attachedProduccionCollection);
            em.persist(unidadMedida);
            for (Receta recetaCollectionReceta : unidadMedida.getRecetaCollection()) {
                UnidadMedida oldUnidadMedidadIdOfRecetaCollectionReceta = recetaCollectionReceta.getUnidadMedidadId();
                recetaCollectionReceta.setUnidadMedidadId(unidadMedida);
                recetaCollectionReceta = em.merge(recetaCollectionReceta);
                if (oldUnidadMedidadIdOfRecetaCollectionReceta != null) {
                    oldUnidadMedidadIdOfRecetaCollectionReceta.getRecetaCollection().remove(recetaCollectionReceta);
                    oldUnidadMedidadIdOfRecetaCollectionReceta = em.merge(oldUnidadMedidadIdOfRecetaCollectionReceta);
                }
            }
            for (Producto productoCollectionProducto : unidadMedida.getProductoCollection()) {
                UnidadMedida oldUnidadMedidaIdOfProductoCollectionProducto = productoCollectionProducto.getUnidadMedidaId();
                productoCollectionProducto.setUnidadMedidaId(unidadMedida);
                productoCollectionProducto = em.merge(productoCollectionProducto);
                if (oldUnidadMedidaIdOfProductoCollectionProducto != null) {
                    oldUnidadMedidaIdOfProductoCollectionProducto.getProductoCollection().remove(productoCollectionProducto);
                    oldUnidadMedidaIdOfProductoCollectionProducto = em.merge(oldUnidadMedidaIdOfProductoCollectionProducto);
                }
            }
            for (Produccion produccionCollectionProduccion : unidadMedida.getProduccionCollection()) {
                UnidadMedida oldUnidadMedidaIdOfProduccionCollectionProduccion = produccionCollectionProduccion.getUnidadMedidaId();
                produccionCollectionProduccion.setUnidadMedidaId(unidadMedida);
                produccionCollectionProduccion = em.merge(produccionCollectionProduccion);
                if (oldUnidadMedidaIdOfProduccionCollectionProduccion != null) {
                    oldUnidadMedidaIdOfProduccionCollectionProduccion.getProduccionCollection().remove(produccionCollectionProduccion);
                    oldUnidadMedidaIdOfProduccionCollectionProduccion = em.merge(oldUnidadMedidaIdOfProduccionCollectionProduccion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UnidadMedida unidadMedida) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UnidadMedida persistentUnidadMedida = em.find(UnidadMedida.class, unidadMedida.getId());
            Collection<Receta> recetaCollectionOld = persistentUnidadMedida.getRecetaCollection();
            Collection<Receta> recetaCollectionNew = unidadMedida.getRecetaCollection();
            Collection<Producto> productoCollectionOld = persistentUnidadMedida.getProductoCollection();
            Collection<Producto> productoCollectionNew = unidadMedida.getProductoCollection();
            Collection<Produccion> produccionCollectionOld = persistentUnidadMedida.getProduccionCollection();
            Collection<Produccion> produccionCollectionNew = unidadMedida.getProduccionCollection();
            List<String> illegalOrphanMessages = null;
            for (Receta recetaCollectionOldReceta : recetaCollectionOld) {
                if (!recetaCollectionNew.contains(recetaCollectionOldReceta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Receta " + recetaCollectionOldReceta + " since its unidadMedidadId field is not nullable.");
                }
            }
            for (Producto productoCollectionOldProducto : productoCollectionOld) {
                if (!productoCollectionNew.contains(productoCollectionOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + productoCollectionOldProducto + " since its unidadMedidaId field is not nullable.");
                }
            }
            for (Produccion produccionCollectionOldProduccion : produccionCollectionOld) {
                if (!produccionCollectionNew.contains(produccionCollectionOldProduccion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Produccion " + produccionCollectionOldProduccion + " since its unidadMedidaId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Receta> attachedRecetaCollectionNew = new ArrayList<Receta>();
            for (Receta recetaCollectionNewRecetaToAttach : recetaCollectionNew) {
                recetaCollectionNewRecetaToAttach = em.getReference(recetaCollectionNewRecetaToAttach.getClass(), recetaCollectionNewRecetaToAttach.getId());
                attachedRecetaCollectionNew.add(recetaCollectionNewRecetaToAttach);
            }
            recetaCollectionNew = attachedRecetaCollectionNew;
            unidadMedida.setRecetaCollection(recetaCollectionNew);
            Collection<Producto> attachedProductoCollectionNew = new ArrayList<Producto>();
            for (Producto productoCollectionNewProductoToAttach : productoCollectionNew) {
                productoCollectionNewProductoToAttach = em.getReference(productoCollectionNewProductoToAttach.getClass(), productoCollectionNewProductoToAttach.getId());
                attachedProductoCollectionNew.add(productoCollectionNewProductoToAttach);
            }
            productoCollectionNew = attachedProductoCollectionNew;
            unidadMedida.setProductoCollection(productoCollectionNew);
            Collection<Produccion> attachedProduccionCollectionNew = new ArrayList<Produccion>();
            for (Produccion produccionCollectionNewProduccionToAttach : produccionCollectionNew) {
                produccionCollectionNewProduccionToAttach = em.getReference(produccionCollectionNewProduccionToAttach.getClass(), produccionCollectionNewProduccionToAttach.getId());
                attachedProduccionCollectionNew.add(produccionCollectionNewProduccionToAttach);
            }
            produccionCollectionNew = attachedProduccionCollectionNew;
            unidadMedida.setProduccionCollection(produccionCollectionNew);
            unidadMedida = em.merge(unidadMedida);
            for (Receta recetaCollectionNewReceta : recetaCollectionNew) {
                if (!recetaCollectionOld.contains(recetaCollectionNewReceta)) {
                    UnidadMedida oldUnidadMedidadIdOfRecetaCollectionNewReceta = recetaCollectionNewReceta.getUnidadMedidadId();
                    recetaCollectionNewReceta.setUnidadMedidadId(unidadMedida);
                    recetaCollectionNewReceta = em.merge(recetaCollectionNewReceta);
                    if (oldUnidadMedidadIdOfRecetaCollectionNewReceta != null && !oldUnidadMedidadIdOfRecetaCollectionNewReceta.equals(unidadMedida)) {
                        oldUnidadMedidadIdOfRecetaCollectionNewReceta.getRecetaCollection().remove(recetaCollectionNewReceta);
                        oldUnidadMedidadIdOfRecetaCollectionNewReceta = em.merge(oldUnidadMedidadIdOfRecetaCollectionNewReceta);
                    }
                }
            }
            for (Producto productoCollectionNewProducto : productoCollectionNew) {
                if (!productoCollectionOld.contains(productoCollectionNewProducto)) {
                    UnidadMedida oldUnidadMedidaIdOfProductoCollectionNewProducto = productoCollectionNewProducto.getUnidadMedidaId();
                    productoCollectionNewProducto.setUnidadMedidaId(unidadMedida);
                    productoCollectionNewProducto = em.merge(productoCollectionNewProducto);
                    if (oldUnidadMedidaIdOfProductoCollectionNewProducto != null && !oldUnidadMedidaIdOfProductoCollectionNewProducto.equals(unidadMedida)) {
                        oldUnidadMedidaIdOfProductoCollectionNewProducto.getProductoCollection().remove(productoCollectionNewProducto);
                        oldUnidadMedidaIdOfProductoCollectionNewProducto = em.merge(oldUnidadMedidaIdOfProductoCollectionNewProducto);
                    }
                }
            }
            for (Produccion produccionCollectionNewProduccion : produccionCollectionNew) {
                if (!produccionCollectionOld.contains(produccionCollectionNewProduccion)) {
                    UnidadMedida oldUnidadMedidaIdOfProduccionCollectionNewProduccion = produccionCollectionNewProduccion.getUnidadMedidaId();
                    produccionCollectionNewProduccion.setUnidadMedidaId(unidadMedida);
                    produccionCollectionNewProduccion = em.merge(produccionCollectionNewProduccion);
                    if (oldUnidadMedidaIdOfProduccionCollectionNewProduccion != null && !oldUnidadMedidaIdOfProduccionCollectionNewProduccion.equals(unidadMedida)) {
                        oldUnidadMedidaIdOfProduccionCollectionNewProduccion.getProduccionCollection().remove(produccionCollectionNewProduccion);
                        oldUnidadMedidaIdOfProduccionCollectionNewProduccion = em.merge(oldUnidadMedidaIdOfProduccionCollectionNewProduccion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = unidadMedida.getId();
                if (findUnidadMedida(id) == null) {
                    throw new NonexistentEntityException("The unidadMedida with id " + id + " no longer exists.");
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
            UnidadMedida unidadMedida;
            try {
                unidadMedida = em.getReference(UnidadMedida.class, id);
                unidadMedida.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The unidadMedida with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Receta> recetaCollectionOrphanCheck = unidadMedida.getRecetaCollection();
            for (Receta recetaCollectionOrphanCheckReceta : recetaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UnidadMedida (" + unidadMedida + ") cannot be destroyed since the Receta " + recetaCollectionOrphanCheckReceta + " in its recetaCollection field has a non-nullable unidadMedidadId field.");
            }
            Collection<Producto> productoCollectionOrphanCheck = unidadMedida.getProductoCollection();
            for (Producto productoCollectionOrphanCheckProducto : productoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UnidadMedida (" + unidadMedida + ") cannot be destroyed since the Producto " + productoCollectionOrphanCheckProducto + " in its productoCollection field has a non-nullable unidadMedidaId field.");
            }
            Collection<Produccion> produccionCollectionOrphanCheck = unidadMedida.getProduccionCollection();
            for (Produccion produccionCollectionOrphanCheckProduccion : produccionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This UnidadMedida (" + unidadMedida + ") cannot be destroyed since the Produccion " + produccionCollectionOrphanCheckProduccion + " in its produccionCollection field has a non-nullable unidadMedidaId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(unidadMedida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UnidadMedida> findUnidadMedidaEntities() {
        return findUnidadMedidaEntities(true, -1, -1);
    }

    public List<UnidadMedida> findUnidadMedidaEntities(int maxResults, int firstResult) {
        return findUnidadMedidaEntities(false, maxResults, firstResult);
    }

    private List<UnidadMedida> findUnidadMedidaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UnidadMedida.class));
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

    public UnidadMedida findUnidadMedida(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UnidadMedida.class, id);
        } finally {
            em.close();
        }
    }

    public int getUnidadMedidaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UnidadMedida> rt = cq.from(UnidadMedida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
