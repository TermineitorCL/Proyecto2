/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matia
 */
@Entity
@Table(name = "detalle_receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleReceta.findAll", query = "SELECT d FROM DetalleReceta d")
    , @NamedQuery(name = "DetalleReceta.findByCantidad", query = "SELECT d FROM DetalleReceta d WHERE d.detalleRecetaPK.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleReceta.findByRecetaId", query = "SELECT d FROM DetalleReceta d WHERE d.detalleRecetaPK.recetaId = :recetaId")
    , @NamedQuery(name = "DetalleReceta.findByProductoId", query = "SELECT d FROM DetalleReceta d WHERE d.detalleRecetaPK.productoId = :productoId")})
public class DetalleReceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleRecetaPK detalleRecetaPK;
    @JoinColumn(name = "producto_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "receta_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Receta receta;

    public DetalleReceta() {
    }

    public DetalleReceta(DetalleRecetaPK detalleRecetaPK) {
        this.detalleRecetaPK = detalleRecetaPK;
    }

    public DetalleReceta(float cantidad, int recetaId, int productoId) {
        this.detalleRecetaPK = new DetalleRecetaPK(cantidad, recetaId, productoId);
    }

    public DetalleRecetaPK getDetalleRecetaPK() {
        return detalleRecetaPK;
    }

    public void setDetalleRecetaPK(DetalleRecetaPK detalleRecetaPK) {
        this.detalleRecetaPK = detalleRecetaPK;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleRecetaPK != null ? detalleRecetaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleReceta)) {
            return false;
        }
        DetalleReceta other = (DetalleReceta) object;
        if ((this.detalleRecetaPK == null && other.detalleRecetaPK != null) || (this.detalleRecetaPK != null && !this.detalleRecetaPK.equals(other.detalleRecetaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.DetalleReceta[ detalleRecetaPK=" + detalleRecetaPK + " ]";
    }
    
}
