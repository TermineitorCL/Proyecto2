/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Matia
 */
@Embeddable
public class DetalleRecetaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cantidad")
    private float cantidad;
    @Basic(optional = false)
    @Column(name = "receta_id")
    private int recetaId;
    @Basic(optional = false)
    @Column(name = "producto_id")
    private int productoId;

    public DetalleRecetaPK() {
    }

    public DetalleRecetaPK(float cantidad, int recetaId, int productoId) {
        this.cantidad = cantidad;
        this.recetaId = recetaId;
        this.productoId = productoId;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cantidad;
        hash += (int) recetaId;
        hash += (int) productoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleRecetaPK)) {
            return false;
        }
        DetalleRecetaPK other = (DetalleRecetaPK) object;
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.recetaId != other.recetaId) {
            return false;
        }
        if (this.productoId != other.productoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.DetalleRecetaPK[ cantidad=" + cantidad + ", recetaId=" + recetaId + ", productoId=" + productoId + " ]";
    }
    
}
