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
import Data.Familia;
import Data.Linea;
import java.util.ArrayList;
import java.util.Collection;
import Data.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author siberion
 */
public class LineaJpaController implements Serializable {

    public LineaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Linea linea) {
        if (linea.getFamiliaCollection() == null) {
            linea.setFamiliaCollection(new ArrayList<Familia>());
        }
        if (linea.getProductoCollection() == null) {
            linea.setProductoCollection(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Familia> attachedFamiliaCollection = new ArrayList<Familia>();
            for (Familia familiaCollectionFamiliaToAttach : linea.getFamiliaCollection()) {
                familiaCollectionFamiliaToAttach = em.getReference(familiaCollectionFamiliaToAttach.getClass(), familiaCollectionFamiliaToAttach.getId());
                attachedFamiliaCollection.add(familiaCollectionFamiliaToAttach);
            }
            linea.setFamiliaCollection(attachedFamiliaCollection);
            Collection<Producto> attachedProductoCollection = new ArrayList<Producto>();
            for (Producto productoCollectionProductoToAttach : linea.getProductoCollection()) {
                productoCollectionProductoToAttach = em.getReference(productoCollectionProductoToAttach.getClass(), productoCollectionProductoToAttach.getId());
                attachedProductoCollection.add(productoCollectionProductoToAttach);
            }
            linea.setProductoCollection(attachedProductoCollection);
            em.persist(linea);
            for (Familia familiaCollectionFamilia : linea.getFamiliaCollection()) {
                Linea oldLineaIdOfFamiliaCollectionFamilia = familiaCollectionFamilia.getLineaId();
                familiaCollectionFamilia.setLineaId(linea);
                familiaCollectionFamilia = em.merge(familiaCollectionFamilia);
                if (oldLineaIdOfFamiliaCollectionFamilia != null) {
                    oldLineaIdOfFamiliaCollectionFamilia.getFamiliaCollection().remove(familiaCollectionFamilia);
                    oldLineaIdOfFamiliaCollectionFamilia = em.merge(oldLineaIdOfFamiliaCollectionFamilia);
                }
            }
            for (Producto productoCollectionProducto : linea.getProductoCollection()) {
                Linea oldLineaIdOfProductoCollectionProducto = productoCollectionProducto.getLineaId();
                productoCollectionProducto.setLineaId(linea);
                productoCollectionProducto = em.merge(productoCollectionProducto);
                if (oldLineaIdOfProductoCollectionProducto != null) {
                    oldLineaIdOfProductoCollectionProducto.getProductoCollection().remove(productoCollectionProducto);
                    oldLineaIdOfProductoCollectionProducto = em.merge(oldLineaIdOfProductoCollectionProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Linea linea) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Linea persistentLinea = em.find(Linea.class, linea.getId());
            Collection<Familia> familiaCollectionOld = persistentLinea.getFamiliaCollection();
            Collection<Familia> familiaCollectionNew = linea.getFamiliaCollection();
            Collection<Producto> productoCollectionOld = persistentLinea.getProductoCollection();
            Collection<Producto> productoCollectionNew = linea.getProductoCollection();
            List<String> illegalOrphanMessages = null;
            for (Familia familiaCollectionOldFamilia : familiaCollectionOld) {
                if (!familiaCollectionNew.contains(familiaCollectionOldFamilia)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Familia " + familiaCollectionOldFamilia + " since its lineaId field is not nullable.");
                }
            }
            for (Producto productoCollectionOldProducto : productoCollectionOld) {
                if (!productoCollectionNew.contains(productoCollectionOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + productoCollectionOldProducto + " since its lineaId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Familia> attachedFamiliaCollectionNew = new ArrayList<Familia>();
            for (Familia familiaCollectionNewFamiliaToAttach : familiaCollectionNew) {
                familiaCollectionNewFamiliaToAttach = em.getReference(familiaCollectionNewFamiliaToAttach.getClass(), familiaCollectionNewFamiliaToAttach.getId());
                attachedFamiliaCollectionNew.add(familiaCollectionNewFamiliaToAttach);
            }
            familiaCollectionNew = attachedFamiliaCollectionNew;
            linea.setFamiliaCollection(familiaCollectionNew);
            Collection<Producto> attachedProductoCollectionNew = new ArrayList<Producto>();
            for (Producto productoCollectionNewProductoToAttach : productoCollectionNew) {
                productoCollectionNewProductoToAttach = em.getReference(productoCollectionNewProductoToAttach.getClass(), productoCollectionNewProductoToAttach.getId());
                attachedProductoCollectionNew.add(productoCollectionNewProductoToAttach);
            }
            productoCollectionNew = attachedProductoCollectionNew;
            linea.setProductoCollection(productoCollectionNew);
            linea = em.merge(linea);
            for (Familia familiaCollectionNewFamilia : familiaCollectionNew) {
                if (!familiaCollectionOld.contains(familiaCollectionNewFamilia)) {
                    Linea oldLineaIdOfFamiliaCollectionNewFamilia = familiaCollectionNewFamilia.getLineaId();
                    familiaCollectionNewFamilia.setLineaId(linea);
                    familiaCollectionNewFamilia = em.merge(familiaCollectionNewFamilia);
                    if (oldLineaIdOfFamiliaCollectionNewFamilia != null && !oldLineaIdOfFamiliaCollectionNewFamilia.equals(linea)) {
                        oldLineaIdOfFamiliaCollectionNewFamilia.getFamiliaCollection().remove(familiaCollectionNewFamilia);
                        oldLineaIdOfFamiliaCollectionNewFamilia = em.merge(oldLineaIdOfFamiliaCollectionNewFamilia);
                    }
                }
            }
            for (Producto productoCollectionNewProducto : productoCollectionNew) {
                if (!productoCollectionOld.contains(productoCollectionNewProducto)) {
                    Linea oldLineaIdOfProductoCollectionNewProducto = productoCollectionNewProducto.getLineaId();
                    productoCollectionNewProducto.setLineaId(linea);
                    productoCollectionNewProducto = em.merge(productoCollectionNewProducto);
                    if (oldLineaIdOfProductoCollectionNewProducto != null && !oldLineaIdOfProductoCollectionNewProducto.equals(linea)) {
                        oldLineaIdOfProductoCollectionNewProducto.getProductoCollection().remove(productoCollectionNewProducto);
                        oldLineaIdOfProductoCollectionNewProducto = em.merge(oldLineaIdOfProductoCollectionNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = linea.getId();
                if (findLinea(id) == null) {
                    throw new NonexistentEntityException("The linea with id " + id + " no longer exists.");
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
            Linea linea;
            try {
                linea = em.getReference(Linea.class, id);
                linea.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The linea with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Familia> familiaCollectionOrphanCheck = linea.getFamiliaCollection();
            for (Familia familiaCollectionOrphanCheckFamilia : familiaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Linea (" + linea + ") cannot be destroyed since the Familia " + familiaCollectionOrphanCheckFamilia + " in its familiaCollection field has a non-nullable lineaId field.");
            }
            Collection<Producto> productoCollectionOrphanCheck = linea.getProductoCollection();
            for (Producto productoCollectionOrphanCheckProducto : productoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Linea (" + linea + ") cannot be destroyed since the Producto " + productoCollectionOrphanCheckProducto + " in its productoCollection field has a non-nullable lineaId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(linea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Linea> findLineaEntities() {
        return findLineaEntities(true, -1, -1);
    }

    public List<Linea> findLineaEntities(int maxResults, int firstResult) {
        return findLineaEntities(false, maxResults, firstResult);
    }

    private List<Linea> findLineaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Linea.class));
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

    public Linea findLinea(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Linea.class, id);
        } finally {
            em.close();
        }
    }

    public int getLineaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Linea> rt = cq.from(Linea.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
