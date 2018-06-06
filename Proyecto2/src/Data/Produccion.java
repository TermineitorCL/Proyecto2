/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matia
 */
@Entity
@Table(name = "produccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccion.findAll", query = "SELECT p FROM Produccion p")
    , @NamedQuery(name = "Produccion.findById", query = "SELECT p FROM Produccion p WHERE p.id = :id")
    , @NamedQuery(name = "Produccion.findByProduccionCantidad", query = "SELECT p FROM Produccion p WHERE p.produccionCantidad = :produccionCantidad")})
public class Produccion implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto productoId;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "produccion_cantidad")
    private int produccionCantidad;
    @JoinColumn(name = "unidad_medida_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnidadMedida unidadMedidaId;

    public Produccion() {
    }

    public Produccion(Integer id) {
        this.id = id;
    }

    public Produccion(Integer id, int produccionCantidad) {
        this.id = id;
        this.produccionCantidad = produccionCantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getProduccionCantidad() {
        return produccionCantidad;
    }

    public void setProduccionCantidad(int produccionCantidad) {
        int oldProduccionCantidad = this.produccionCantidad;
        this.produccionCantidad = produccionCantidad;
        changeSupport.firePropertyChange("produccionCantidad", oldProduccionCantidad, produccionCantidad);
    }

    public UnidadMedida getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(UnidadMedida unidadMedidaId) {
        UnidadMedida oldUnidadMedidaId = this.unidadMedidaId;
        this.unidadMedidaId = unidadMedidaId;
        changeSupport.firePropertyChange("unidadMedidaId", oldUnidadMedidaId, unidadMedidaId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Produccion[ id=" + id + " ]";
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        Producto oldProductoId = this.productoId;
        this.productoId = productoId;
        changeSupport.firePropertyChange("productoId", oldProductoId, productoId);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
