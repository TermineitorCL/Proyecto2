/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Matia
 */
@Entity
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f")
    , @NamedQuery(name = "Familia.findById", query = "SELECT f FROM Familia f WHERE f.id = :id")
    , @NamedQuery(name = "Familia.findByNombre", query = "SELECT f FROM Familia f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Familia.findByCreadoEl", query = "SELECT f FROM Familia f WHERE f.creadoEl = :creadoEl")
    , @NamedQuery(name = "Familia.findByModificadoEl", query = "SELECT f FROM Familia f WHERE f.modificadoEl = :modificadoEl")
    , @NamedQuery(name = "Familia.findByEliminadoEl", query = "SELECT f FROM Familia f WHERE f.eliminadoEl = :eliminadoEl")})
public class Familia implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familiaId")
    private Collection<Producto> productoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
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
    @JoinColumn(name = "linea_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Linea lineaId;

    public Familia() {
    }

    public Familia(Integer id) {
        this.id = id;
    }

    public Familia(Integer id, String nombre, Date creadoEl, Date modificadoEl, Date eliminadoEl) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
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

    public Linea getLineaId() {
        return lineaId;
    }

    public void setLineaId(Linea lineaId) {
        Linea oldLineaId = this.lineaId;
        this.lineaId = lineaId;
        changeSupport.firePropertyChange("lineaId", oldLineaId, lineaId);
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
        if (!(object instanceof Familia)) {
            return false;
        }
        Familia other = (Familia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
