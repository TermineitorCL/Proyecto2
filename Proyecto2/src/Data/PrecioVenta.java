/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matia
 */
@Entity
@Table(name = "precio_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioVenta.findAll", query = "SELECT p FROM PrecioVenta p")
    , @NamedQuery(name = "PrecioVenta.findById", query = "SELECT p FROM PrecioVenta p WHERE p.id = :id")
    , @NamedQuery(name = "PrecioVenta.findByFecha", query = "SELECT p FROM PrecioVenta p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "PrecioVenta.findByValor", query = "SELECT p FROM PrecioVenta p WHERE p.valor = :valor")
    , @NamedQuery(name = "PrecioVenta.findByEsActual", query = "SELECT p FROM PrecioVenta p WHERE p.esActual = :esActual")
    , @NamedQuery(name = "PrecioVenta.findByCreadoEl", query = "SELECT p FROM PrecioVenta p WHERE p.creadoEl = :creadoEl")
    , @NamedQuery(name = "PrecioVenta.findByModificadoEl", query = "SELECT p FROM PrecioVenta p WHERE p.modificadoEl = :modificadoEl")
    , @NamedQuery(name = "PrecioVenta.findByEliminadoEl", query = "SELECT p FROM PrecioVenta p WHERE p.eliminadoEl = :eliminadoEl")})
public class PrecioVenta implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "valor")
    private int valor;
    @Basic(optional = false)
    @Column(name = "es_actual")
    private int esActual;
    @Basic(optional = false)
    @Column(name = "creado_el")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creadoEl;
    @Basic(optional = false)
    @Column(name = "modificado_el")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificadoEl;
    @Basic(optional = false)
    @Column(name = "eliminado_el")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eliminadoEl;
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto productoId;

    public PrecioVenta() {
    }

    public PrecioVenta(Integer id) {
        this.id = id;
    }

    public PrecioVenta(Integer id, Date fecha, int valor, int esActual, Date creadoEl, Date modificadoEl, Date eliminadoEl) {
        this.id = id;
        this.fecha = fecha;
        this.valor = valor;
        this.esActual = esActual;
        this.creadoEl = creadoEl;
        this.modificadoEl = modificadoEl;
        this.eliminadoEl = eliminadoEl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        changeSupport.firePropertyChange("fecha", oldFecha, fecha);
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        int oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public int getEsActual() {
        return esActual;
    }

    public void setEsActual(int esActual) {
        int oldEsActual = this.esActual;
        this.esActual = esActual;
        changeSupport.firePropertyChange("esActual", oldEsActual, esActual);
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        Date oldCreadoEl = this.creadoEl;
        this.creadoEl = creadoEl;
        changeSupport.firePropertyChange("creadoEl", oldCreadoEl, creadoEl);
    }

    public Date getModificadoEl() {
        return modificadoEl;
    }

    public void setModificadoEl(Date modificadoEl) {
        Date oldModificadoEl = this.modificadoEl;
        this.modificadoEl = modificadoEl;
        changeSupport.firePropertyChange("modificadoEl", oldModificadoEl, modificadoEl);
    }

    public Date getEliminadoEl() {
        return eliminadoEl;
    }

    public void setEliminadoEl(Date eliminadoEl) {
        Date oldEliminadoEl = this.eliminadoEl;
        this.eliminadoEl = eliminadoEl;
        changeSupport.firePropertyChange("eliminadoEl", oldEliminadoEl, eliminadoEl);
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        Producto oldProductoId = this.productoId;
        this.productoId = productoId;
        changeSupport.firePropertyChange("productoId", oldProductoId, productoId);
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
        if (!(object instanceof PrecioVenta)) {
            return false;
        }
        PrecioVenta other = (PrecioVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.PrecioVenta[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
