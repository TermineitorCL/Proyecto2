/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    , @NamedQuery(name = "DetalleReceta.findByRecetaId", query = "SELECT d FROM DetalleReceta d WHERE d.recetaId = :recetaId")
    , @NamedQuery(name = "DetalleReceta.findByProductoId", query = "SELECT d FROM DetalleReceta d WHERE d.productoId = :productoId")
    , @NamedQuery(name = "DetalleReceta.findByCantidad", query = "SELECT d FROM DetalleReceta d WHERE d.cantidad = :cantidad")})
public class DetalleReceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "receta_id")
    private int recetaId;
    @Basic(optional = false)
    @Column(name = "producto_id")
    private int productoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "cantidad")
    private Float cantidad;

    public DetalleReceta() {
    }

    public DetalleReceta(Float cantidad) {
        this.cantidad = cantidad;
    }

    public DetalleReceta(Float cantidad, int recetaId, int productoId) {
        this.cantidad = cantidad;
        this.recetaId = recetaId;
        this.productoId = productoId;
    }

    public int getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(int recetaId) {
        this.recetaId = recetaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantidad != null ? cantidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleReceta)) {
            return false;
        }
        DetalleReceta other = (DetalleReceta) object;
        if ((this.cantidad == null && other.cantidad != null) || (this.cantidad != null && !this.cantidad.equals(other.cantidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.DetalleReceta[ cantidad=" + cantidad + " ]";
    }
    
}
