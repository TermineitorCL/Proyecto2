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
import Data.UnidadMedida;
import Data.Linea;
import Data.Receta;
import java.util.ArrayList;
import java.util.Collection;
import Data.Costo;
import Data.DetalleReceta;
import Data.PrecioVenta;
import Data.Produccion;
import Data.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author siberion
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getRecetaCollection() == null) {
            producto.setRecetaCollection(new ArrayList<Receta>());
        }
        if (producto.getCostoCollection() == null) {
            producto.setCostoCollection(new ArrayList<Costo>());
        }
        if (producto.getDetalleRecetaCollection() == null) {
            producto.setDetalleRecetaCollection(new ArrayList<DetalleReceta>());
        }
        if (producto.getPrecioVentaCollection() == null) {
            producto.setPrecioVentaCollection(new ArrayList<PrecioVenta>());
        }
        if (producto.getProduccionCollection() == null) {
            producto.setProduccionCollection(new ArrayList<Produccion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Familia familiaId = producto.getFamiliaId();
            if (familiaId != null) {
                familiaId = em.getReference(familiaId.getClass(), familiaId.getId());
                producto.setFamiliaId(familiaId);
            }
            UnidadMedida unidadMedidaId = producto.getUnidadMedidaId();
            if (unidadMedidaId != null) {
                unidadMedidaId = em.getReference(unidadMedidaId.getClass(), unidadMedidaId.getId());
                producto.setUnidadMedidaId(unidadMedidaId);
            }
            Linea lineaId = producto.getLineaId();
            if (lineaId != null) {
                lineaId = em.getReference(lineaId.getClass(), lineaId.getId());
                producto.setLineaId(lineaId);
            }
            Collection<Receta> attachedRecetaCollection = new ArrayList<Receta>();
            for (Receta recetaCollectionRecetaToAttach : producto.getRecetaCollection()) {
                recetaCollectionRecetaToAttach = em.getReference(recetaCollectionRecetaToAttach.getClass(), recetaCollectionRecetaToAttach.getId());
                attachedRecetaCollection.add(recetaCollectionRecetaToAttach);
            }
            producto.setRecetaCollection(attachedRecetaCollection);
            Collection<Costo> attachedCostoCollection = new ArrayList<Costo>();
            for (Costo costoCollectionCostoToAttach : producto.getCostoCollection()) {
                costoCollectionCostoToAttach = em.getReference(costoCollectionCostoToAttach.getClass(), costoCollectionCostoToAttach.getId());
                attachedCostoCollection.add(costoCollectionCostoToAttach);
            }
            producto.setCostoCollection(attachedCostoCollection);
            Collection<DetalleReceta> attachedDetalleRecetaCollection = new ArrayList<DetalleReceta>();
            for (DetalleReceta detalleRecetaCollectionDetalleRecetaToAttach : producto.getDetalleRecetaCollection()) {
                detalleRecetaCollectionDetalleRecetaToAttach = em.getReference(detalleRecetaCollectionDetalleRecetaToAttach.getClass(), detalleRecetaCollectionDetalleRecetaToAttach.getDetalleRecetaPK());
                attachedDetalleRecetaCollection.add(detalleRecetaCollectionDetalleRecetaToAttach);
            }
            producto.setDetalleRecetaCollection(attachedDetalleRecetaCollection);
            Collection<PrecioVenta> attachedPrecioVentaCollection = new ArrayList<PrecioVenta>();
            for (PrecioVenta precioVentaCollectionPrecioVentaToAttach : producto.getPrecioVentaCollection()) {
                precioVentaCollectionPrecioVentaToAttach = em.getReference(precioVentaCollectionPrecioVentaToAttach.getClass(), precioVentaCollectionPrecioVentaToAttach.getId());
                attachedPrecioVentaCollection.add(precioVentaCollectionPrecioVentaToAttach);
            }
            producto.setPrecioVentaCollection(attachedPrecioVentaCollection);
            Collection<Produccion> attachedProduccionCollection = new ArrayList<Produccion>();
            for (Produccion produccionCollectionProduccionToAttach : producto.getProduccionCollection()) {
                produccionCollectionProduccionToAttach = em.getReference(produccionCollectionProduccionToAttach.getClass(), produccionCollectionProduccionToAttach.getId());
                attachedProduccionCollection.add(produccionCollectionProduccionToAttach);
            }
            producto.setProduccionCollection(attachedProduccionCollection);
            em.persist(producto);
            if (familiaId != null) {
                familiaId.getProductoCollection().add(producto);
                familiaId = em.merge(familiaId);
            }
            if (unidadMedidaId != null) {
                unidadMedidaId.getProductoCollection().add(producto);
                unidadMedidaId = em.merge(unidadMedidaId);
            }
            if (lineaId != null) {
                lineaId.getProductoCollection().add(producto);
                lineaId = em.merge(lineaId);
            }
            for (Receta recetaCollectionReceta : producto.getRecetaCollection()) {
                Producto oldProductoIdOfRecetaCollectionReceta = recetaCollectionReceta.getProductoId();
                recetaCollectionReceta.setProductoId(producto);
                recetaCollectionReceta = em.merge(recetaCollectionReceta);
                if (oldProductoIdOfRecetaCollectionReceta != null) {
                    oldProductoIdOfRecetaCollectionReceta.getRecetaCollection().remove(recetaCollectionReceta);
                    oldProductoIdOfRecetaCollectionReceta = em.merge(oldProductoIdOfRecetaCollectionReceta);
                }
            }
            for (Costo costoCollectionCosto : producto.getCostoCollection()) {
                Producto oldProductoIdOfCostoCollectionCosto = costoCollectionCosto.getProductoId();
                costoCollectionCosto.setProductoId(producto);
                costoCollectionCosto = em.merge(costoCollectionCosto);
                if (oldProductoIdOfCostoCollectionCosto != null) {
                    oldProductoIdOfCostoCollectionCosto.getCostoCollection().remove(costoCollectionCosto);
                    oldProductoIdOfCostoCollectionCosto = em.merge(oldProductoIdOfCostoCollectionCosto);
                }
            }
            for (DetalleReceta detalleRecetaCollectionDetalleReceta : producto.getDetalleRecetaCollection()) {
                Producto oldProductoOfDetalleRecetaCollectionDetalleReceta = detalleRecetaCollectionDetalleReceta.getProducto();
                detalleRecetaCollectionDetalleReceta.setProducto(producto);
                detalleRecetaCollectionDetalleReceta = em.merge(detalleRecetaCollectionDetalleReceta);
                if (oldProductoOfDetalleRecetaCollectionDetalleReceta != null) {
                    oldProductoOfDetalleRecetaCollectionDetalleReceta.getDetalleRecetaCollection().remove(detalleRecetaCollectionDetalleReceta);
                    oldProductoOfDetalleRecetaCollectionDetalleReceta = em.merge(oldProductoOfDetalleRecetaCollectionDetalleReceta);
                }
            }
            for (PrecioVenta precioVentaCollectionPrecioVenta : producto.getPrecioVentaCollection()) {
                Producto oldProductoIdOfPrecioVentaCollectionPrecioVenta = precioVentaCollectionPrecioVenta.getProductoId();
                precioVentaCollectionPrecioVenta.setProductoId(producto);
                precioVentaCollectionPrecioVenta = em.merge(precioVentaCollectionPrecioVenta);
                if (oldProductoIdOfPrecioVentaCollectionPrecioVenta != null) {
                    oldProductoIdOfPrecioVentaCollectionPrecioVenta.getPrecioVentaCollection().remove(precioVentaCollectionPrecioVenta);
                    oldProductoIdOfPrecioVentaCollectionPrecioVenta = em.merge(oldProductoIdOfPrecioVentaCollectionPrecioVenta);
                }
            }
            for (Produccion produccionCollectionProduccion : producto.getProduccionCollection()) {
                Producto oldProductoIdOfProduccionCollectionProduccion = produccionCollectionProduccion.getProductoId();
                produccionCollectionProduccion.setProductoId(producto);
                produccionCollectionProduccion = em.merge(produccionCollectionProduccion);
                if (oldProductoIdOfProduccionCollectionProduccion != null) {
                    oldProductoIdOfProduccionCollectionProduccion.getProduccionCollection().remove(produccionCollectionProduccion);
                    oldProductoIdOfProduccionCollectionProduccion = em.merge(oldProductoIdOfProduccionCollectionProduccion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getId());
            Familia familiaIdOld = persistentProducto.getFamiliaId();
            Familia familiaIdNew = producto.getFamiliaId();
            UnidadMedida unidadMedidaIdOld = persistentProducto.getUnidadMedidaId();
            UnidadMedida unidadMedidaIdNew = producto.getUnidadMedidaId();
            Linea lineaIdOld = persistentProducto.getLineaId();
            Linea lineaIdNew = producto.getLineaId();
            Collection<Receta> recetaCollectionOld = persistentProducto.getRecetaCollection();
            Collection<Receta> recetaCollectionNew = producto.getRecetaCollection();
            Collection<Costo> costoCollectionOld = persistentProducto.getCostoCollection();
            Collection<Costo> costoCollectionNew = producto.getCostoCollection();
            Collection<DetalleReceta> detalleRecetaCollectionOld = persistentProducto.getDetalleRecetaCollection();
            Collection<DetalleReceta> detalleRecetaCollectionNew = producto.getDetalleRecetaCollection();
            Collection<PrecioVenta> precioVentaCollectionOld = persistentProducto.getPrecioVentaCollection();
            Collection<PrecioVenta> precioVentaCollectionNew = producto.getPrecioVentaCollection();
            Collection<Produccion> produccionCollectionOld = persistentProducto.getProduccionCollection();
            Collection<Produccion> produccionCollectionNew = producto.getProduccionCollection();
            List<String> illegalOrphanMessages = null;
            for (Receta recetaCollectionOldReceta : recetaCollectionOld) {
                if (!recetaCollectionNew.contains(recetaCollectionOldReceta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Receta " + recetaCollectionOldReceta + " since its productoId field is not nullable.");
                }
            }
            for (Costo costoCollectionOldCosto : costoCollectionOld) {
                if (!costoCollectionNew.contains(costoCollectionOldCosto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Costo " + costoCollectionOldCosto + " since its productoId field is not nullable.");
                }
            }
            for (DetalleReceta detalleRecetaCollectionOldDetalleReceta : detalleRecetaCollectionOld) {
                if (!detalleRecetaCollectionNew.contains(detalleRecetaCollectionOldDetalleReceta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleReceta " + detalleRecetaCollectionOldDetalleReceta + " since its producto field is not nullable.");
                }
            }
            for (PrecioVenta precioVentaCollectionOldPrecioVenta : precioVentaCollectionOld) {
                if (!precioVentaCollectionNew.contains(precioVentaCollectionOldPrecioVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PrecioVenta " + precioVentaCollectionOldPrecioVenta + " since its productoId field is not nullable.");
                }
            }
            for (Produccion produccionCollectionOldProduccion : produccionCollectionOld) {
                if (!produccionCollectionNew.contains(produccionCollectionOldProduccion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Produccion " + produccionCollectionOldProduccion + " since its productoId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (familiaIdNew != null) {
                familiaIdNew = em.getReference(familiaIdNew.getClass(), familiaIdNew.getId());
                producto.setFamiliaId(familiaIdNew);
            }
            if (unidadMedidaIdNew != null) {
                unidadMedidaIdNew = em.getReference(unidadMedidaIdNew.getClass(), unidadMedidaIdNew.getId());
                producto.setUnidadMedidaId(unidadMedidaIdNew);
            }
            if (lineaIdNew != null) {
                lineaIdNew = em.getReference(lineaIdNew.getClass(), lineaIdNew.getId());
                producto.setLineaId(lineaIdNew);
            }
            Collection<Receta> attachedRecetaCollectionNew = new ArrayList<Receta>();
            for (Receta recetaCollectionNewRecetaToAttach : recetaCollectionNew) {
                recetaCollectionNewRecetaToAttach = em.getReference(recetaCollectionNewRecetaToAttach.getClass(), recetaCollectionNewRecetaToAttach.getId());
                attachedRecetaCollectionNew.add(recetaCollectionNewRecetaToAttach);
            }
            recetaCollectionNew = attachedRecetaCollectionNew;
            producto.setRecetaCollection(recetaCollectionNew);
            Collection<Costo> attachedCostoCollectionNew = new ArrayList<Costo>();
            for (Costo costoCollectionNewCostoToAttach : costoCollectionNew) {
                costoCollectionNewCostoToAttach = em.getReference(costoCollectionNewCostoToAttach.getClass(), costoCollectionNewCostoToAttach.getId());
                attachedCostoCollectionNew.add(costoCollectionNewCostoToAttach);
            }
            costoCollectionNew = attachedCostoCollectionNew;
            producto.setCostoCollection(costoCollectionNew);
            Collection<DetalleReceta> attachedDetalleRecetaCollectionNew = new ArrayList<DetalleReceta>();
            for (DetalleReceta detalleRecetaCollectionNewDetalleRecetaToAttach : detalleRecetaCollectionNew) {
                detalleRecetaCollectionNewDetalleRecetaToAttach = em.getReference(detalleRecetaCollectionNewDetalleRecetaToAttach.getClass(), detalleRecetaCollectionNewDetalleRecetaToAttach.getDetalleRecetaPK());
                attachedDetalleRecetaCollectionNew.add(detalleRecetaCollectionNewDetalleRecetaToAttach);
            }
            detalleRecetaCollectionNew = attachedDetalleRecetaCollectionNew;
            producto.setDetalleRecetaCollection(detalleRecetaCollectionNew);
            Collection<PrecioVenta> attachedPrecioVentaCollectionNew = new ArrayList<PrecioVenta>();
            for (PrecioVenta precioVentaCollectionNewPrecioVentaToAttach : precioVentaCollectionNew) {
                precioVentaCollectionNewPrecioVentaToAttach = em.getReference(precioVentaCollectionNewPrecioVentaToAttach.getClass(), precioVentaCollectionNewPrecioVentaToAttach.getId());
                attachedPrecioVentaCollectionNew.add(precioVentaCollectionNewPrecioVentaToAttach);
            }
            precioVentaCollectionNew = attachedPrecioVentaCollectionNew;
            producto.setPrecioVentaCollection(precioVentaCollectionNew);
            Collection<Produccion> attachedProduccionCollectionNew = new ArrayList<Produccion>();
            for (Produccion produccionCollectionNewProduccionToAttach : produccionCollectionNew) {
                produccionCollectionNewProduccionToAttach = em.getReference(produccionCollectionNewProduccionToAttach.getClass(), produccionCollectionNewProduccionToAttach.getId());
                attachedProduccionCollectionNew.add(produccionCollectionNewProduccionToAttach);
            }
            produccionCollectionNew = attachedProduccionCollectionNew;
            producto.setProduccionCollection(produccionCollectionNew);
            producto = em.merge(producto);
            if (familiaIdOld != null && !familiaIdOld.equals(familiaIdNew)) {
                familiaIdOld.getProductoCollection().remove(producto);
                familiaIdOld = em.merge(familiaIdOld);
            }
            if (familiaIdNew != null && !familiaIdNew.equals(familiaIdOld)) {
                familiaIdNew.getProductoCollection().add(producto);
                familiaIdNew = em.merge(familiaIdNew);
            }
            if (unidadMedidaIdOld != null && !unidadMedidaIdOld.equals(unidadMedidaIdNew)) {
                unidadMedidaIdOld.getProductoCollection().remove(producto);
                unidadMedidaIdOld = em.merge(unidadMedidaIdOld);
            }
            if (unidadMedidaIdNew != null && !unidadMedidaIdNew.equals(unidadMedidaIdOld)) {
                unidadMedidaIdNew.getProductoCollection().add(producto);
                unidadMedidaIdNew = em.merge(unidadMedidaIdNew);
            }
            if (lineaIdOld != null && !lineaIdOld.equals(lineaIdNew)) {
                lineaIdOld.getProductoCollection().remove(producto);
                lineaIdOld = em.merge(lineaIdOld);
            }
            if (lineaIdNew != null && !lineaIdNew.equals(lineaIdOld)) {
                lineaIdNew.getProductoCollection().add(producto);
                lineaIdNew = em.merge(lineaIdNew);
            }
            for (Receta recetaCollectionNewReceta : recetaCollectionNew) {
                if (!recetaCollectionOld.contains(recetaCollectionNewReceta)) {
                    Producto oldProductoIdOfRecetaCollectionNewReceta = recetaCollectionNewReceta.getProductoId();
                    recetaCollectionNewReceta.setProductoId(producto);
                    recetaCollectionNewReceta = em.merge(recetaCollectionNewReceta);
                    if (oldProductoIdOfRecetaCollectionNewReceta != null && !oldProductoIdOfRecetaCollectionNewReceta.equals(producto)) {
                        oldProductoIdOfRecetaCollectionNewReceta.getRecetaCollection().remove(recetaCollectionNewReceta);
                        oldProductoIdOfRecetaCollectionNewReceta = em.merge(oldProductoIdOfRecetaCollectionNewReceta);
                    }
                }
            }
            for (Costo costoCollectionNewCosto : costoCollectionNew) {
                if (!costoCollectionOld.contains(costoCollectionNewCosto)) {
                    Producto oldProductoIdOfCostoCollectionNewCosto = costoCollectionNewCosto.getProductoId();
                    costoCollectionNewCosto.setProductoId(producto);
                    costoCollectionNewCosto = em.merge(costoCollectionNewCosto);
                    if (oldProductoIdOfCostoCollectionNewCosto != null && !oldProductoIdOfCostoCollectionNewCosto.equals(producto)) {
                        oldProductoIdOfCostoCollectionNewCosto.getCostoCollection().remove(costoCollectionNewCosto);
                        oldProductoIdOfCostoCollectionNewCosto = em.merge(oldProductoIdOfCostoCollectionNewCosto);
                    }
                }
            }
            for (DetalleReceta detalleRecetaCollectionNewDetalleReceta : detalleRecetaCollectionNew) {
                if (!detalleRecetaCollectionOld.contains(detalleRecetaCollectionNewDetalleReceta)) {
                    Producto oldProductoOfDetalleRecetaCollectionNewDetalleReceta = detalleRecetaCollectionNewDetalleReceta.getProducto();
                    detalleRecetaCollectionNewDetalleReceta.setProducto(producto);
                    detalleRecetaCollectionNewDetalleReceta = em.merge(detalleRecetaCollectionNewDetalleReceta);
                    if (oldProductoOfDetalleRecetaCollectionNewDetalleReceta != null && !oldProductoOfDetalleRecetaCollectionNewDetalleReceta.equals(producto)) {
                        oldProductoOfDetalleRecetaCollectionNewDetalleReceta.getDetalleRecetaCollection().remove(detalleRecetaCollectionNewDetalleReceta);
                        oldProductoOfDetalleRecetaCollectionNewDetalleReceta = em.merge(oldProductoOfDetalleRecetaCollectionNewDetalleReceta);
                    }
                }
            }
            for (PrecioVenta precioVentaCollectionNewPrecioVenta : precioVentaCollectionNew) {
                if (!precioVentaCollectionOld.contains(precioVentaCollectionNewPrecioVenta)) {
                    Producto oldProductoIdOfPrecioVentaCollectionNewPrecioVenta = precioVentaCollectionNewPrecioVenta.getProductoId();
                    precioVentaCollectionNewPrecioVenta.setProductoId(producto);
                    precioVentaCollectionNewPrecioVenta = em.merge(precioVentaCollectionNewPrecioVenta);
                    if (oldProductoIdOfPrecioVentaCollectionNewPrecioVenta != null && !oldProductoIdOfPrecioVentaCollectionNewPrecioVenta.equals(producto)) {
                        oldProductoIdOfPrecioVentaCollectionNewPrecioVenta.getPrecioVentaCollection().remove(precioVentaCollectionNewPrecioVenta);
                        oldProductoIdOfPrecioVentaCollectionNewPrecioVenta = em.merge(oldProductoIdOfPrecioVentaCollectionNewPrecioVenta);
                    }
                }
            }
            for (Produccion produccionCollectionNewProduccion : produccionCollectionNew) {
                if (!produccionCollectionOld.contains(produccionCollectionNewProduccion)) {
                    Producto oldProductoIdOfProduccionCollectionNewProduccion = produccionCollectionNewProduccion.getProductoId();
                    produccionCollectionNewProduccion.setProductoId(producto);
                    produccionCollectionNewProduccion = em.merge(produccionCollectionNewProduccion);
                    if (oldProductoIdOfProduccionCollectionNewProduccion != null && !oldProductoIdOfProduccionCollectionNewProduccion.equals(producto)) {
                        oldProductoIdOfProduccionCollectionNewProduccion.getProduccionCollection().remove(produccionCollectionNewProduccion);
                        oldProductoIdOfProduccionCollectionNewProduccion = em.merge(oldProductoIdOfProduccionCollectionNewProduccion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getId();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Receta> recetaCollectionOrphanCheck = producto.getRecetaCollection();
            for (Receta recetaCollectionOrphanCheckReceta : recetaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Receta " + recetaCollectionOrphanCheckReceta + " in its recetaCollection field has a non-nullable productoId field.");
            }
            Collection<Costo> costoCollectionOrphanCheck = producto.getCostoCollection();
            for (Costo costoCollectionOrphanCheckCosto : costoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Costo " + costoCollectionOrphanCheckCosto + " in its costoCollection field has a non-nullable productoId field.");
            }
            Collection<DetalleReceta> detalleRecetaCollectionOrphanCheck = producto.getDetalleRecetaCollection();
            for (DetalleReceta detalleRecetaCollectionOrphanCheckDetalleReceta : detalleRecetaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the DetalleReceta " + detalleRecetaCollectionOrphanCheckDetalleReceta + " in its detalleRecetaCollection field has a non-nullable producto field.");
            }
            Collection<PrecioVenta> precioVentaCollectionOrphanCheck = producto.getPrecioVentaCollection();
            for (PrecioVenta precioVentaCollectionOrphanCheckPrecioVenta : precioVentaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the PrecioVenta " + precioVentaCollectionOrphanCheckPrecioVenta + " in its precioVentaCollection field has a non-nullable productoId field.");
            }
            Collection<Produccion> produccionCollectionOrphanCheck = producto.getProduccionCollection();
            for (Produccion produccionCollectionOrphanCheckProduccion : produccionCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Produccion " + produccionCollectionOrphanCheckProduccion + " in its produccionCollection field has a non-nullable productoId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Familia familiaId = producto.getFamiliaId();
            if (familiaId != null) {
                familiaId.getProductoCollection().remove(producto);
                familiaId = em.merge(familiaId);
            }
            UnidadMedida unidadMedidaId = producto.getUnidadMedidaId();
            if (unidadMedidaId != null) {
                unidadMedidaId.getProductoCollection().remove(producto);
                unidadMedidaId = em.merge(unidadMedidaId);
            }
            Linea lineaId = producto.getLineaId();
            if (lineaId != null) {
                lineaId.getProductoCollection().remove(producto);
                lineaId = em.merge(lineaId);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
