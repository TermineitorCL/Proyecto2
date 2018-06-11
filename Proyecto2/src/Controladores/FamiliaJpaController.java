/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import Data.Familia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Data.Linea;
import Data.Producto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author siberion
 */
public class FamiliaJpaController implements Serializable {

    public FamiliaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Familia familia) {
        if (familia.getProductoCollection() == null) {
            familia.setProductoCollection(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Linea lineaId = familia.getLineaId();
            if (lineaId != null) {
                lineaId = em.getReference(lineaId.getClass(), lineaId.getId());
                familia.setLineaId(lineaId);
            }
            Collection<Producto> attachedProductoCollection = new ArrayList<Producto>();
            for (Producto productoCollectionProductoToAttach : familia.getProductoCollection()) {
                productoCollectionProductoToAttach = em.getReference(productoCollectionProductoToAttach.getClass(), productoCollectionProductoToAttach.getId());
                attachedProductoCollection.add(productoCollectionProductoToAttach);
            }
            familia.setProductoCollection(attachedProductoCollection);
            em.persist(familia);
            if (lineaId != null) {
                lineaId.getFamiliaCollection().add(familia);
                lineaId = em.merge(lineaId);
            }
            for (Producto productoCollectionProducto : familia.getProductoCollection()) {
                Familia oldFamiliaIdOfProductoCollectionProducto = productoCollectionProducto.getFamiliaId();
                productoCollectionProducto.setFamiliaId(familia);
                productoCollectionProducto = em.merge(productoCollectionProducto);
                if (oldFamiliaIdOfProductoCollectionProducto != null) {
                    oldFamiliaIdOfProductoCollectionProducto.getProductoCollection().remove(productoCollectionProducto);
                    oldFamiliaIdOfProductoCollectionProducto = em.merge(oldFamiliaIdOfProductoCollectionProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Familia familia) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familia persistentFamilia = em.find(Familia.class, familia.getId());
            Linea lineaIdOld = persistentFamilia.getLineaId();
            Linea lineaIdNew = familia.getLineaId();
            Collection<Producto> productoCollectionOld = persistentFamilia.getProductoCollection();
            Collection<Producto> productoCollectionNew = familia.getProductoCollection();
            List<String> illegalOrphanMessages = null;
            for (Producto productoCollectionOldProducto : productoCollectionOld) {
                if (!productoCollectionNew.contains(productoCollectionOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + productoCollectionOldProducto + " since its familiaId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (lineaIdNew != null) {
                lineaIdNew = em.getReference(lineaIdNew.getClass(), lineaIdNew.getId());
                familia.setLineaId(lineaIdNew);
            }
            Collection<Producto> attachedProductoCollectionNew = new ArrayList<Producto>();
            for (Producto productoCollectionNewProductoToAttach : productoCollectionNew) {
                productoCollectionNewProductoToAttach = em.getReference(productoCollectionNewProductoToAttach.getClass(), productoCollectionNewProductoToAttach.getId());
                attachedProductoCollectionNew.add(productoCollectionNewProductoToAttach);
            }
            productoCollectionNew = attachedProductoCollectionNew;
            familia.setProductoCollection(productoCollectionNew);
            familia = em.merge(familia);
            if (lineaIdOld != null && !lineaIdOld.equals(lineaIdNew)) {
                lineaIdOld.getFamiliaCollection().remove(familia);
                lineaIdOld = em.merge(lineaIdOld);
            }
            if (lineaIdNew != null && !lineaIdNew.equals(lineaIdOld)) {
                lineaIdNew.getFamiliaCollection().add(familia);
                lineaIdNew = em.merge(lineaIdNew);
            }
            for (Producto productoCollectionNewProducto : productoCollectionNew) {
                if (!productoCollectionOld.contains(productoCollectionNewProducto)) {
                    Familia oldFamiliaIdOfProductoCollectionNewProducto = productoCollectionNewProducto.getFamiliaId();
                    productoCollectionNewProducto.setFamiliaId(familia);
                    productoCollectionNewProducto = em.merge(productoCollectionNewProducto);
                    if (oldFamiliaIdOfProductoCollectionNewProducto != null && !oldFamiliaIdOfProductoCollectionNewProducto.equals(familia)) {
                        oldFamiliaIdOfProductoCollectionNewProducto.getProductoCollection().remove(productoCollectionNewProducto);
                        oldFamiliaIdOfProductoCollectionNewProducto = em.merge(oldFamiliaIdOfProductoCollectionNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = familia.getId();
                if (findFamilia(id) == null) {
                    throw new NonexistentEntityException("The familia with id " + id + " no longer exists.");
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
            Familia familia;
            try {
                familia = em.getReference(Familia.class, id);
                familia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The familia with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Producto> productoCollectionOrphanCheck = familia.getProductoCollection();
            for (Producto productoCollectionOrphanCheckProducto : productoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Familia (" + familia + ") cannot be destroyed since the Producto " + productoCollectionOrphanCheckProducto + " in its productoCollection field has a non-nullable familiaId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Linea lineaId = familia.getLineaId();
            if (lineaId != null) {
                lineaId.getFamiliaCollection().remove(familia);
                lineaId = em.merge(lineaId);
            }
            em.remove(familia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Familia> findFamiliaEntities() {
        return findFamiliaEntities(true, -1, -1);
    }

    public List<Familia> findFamiliaEntities(int maxResults, int firstResult) {
        return findFamiliaEntities(false, maxResults, firstResult);
    }

    private List<Familia> findFamiliaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Familia.class));
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

    public Familia findFamilia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Familia.class, id);
        } finally {
            em.close();
        }
    }

    public int getFamiliaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Familia> rt = cq.from(Familia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
