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
@Table(name = "unidad_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u")
    , @NamedQuery(name = "UnidadMedida.findById", query = "SELECT u FROM UnidadMedida u WHERE u.id = :id")
    , @NamedQuery(name = "UnidadMedida.findByCodigo", query = "SELECT u FROM UnidadMedida u WHERE u.codigo = :codigo")
    , @NamedQuery(name = "UnidadMedida.findByDescripcion", query = "SELECT u FROM UnidadMedida u WHERE u.descripcion = :descripcion")
    , @NamedQuery(name = "UnidadMedida.findByCreadoEl", query = "SELECT u FROM UnidadMedida u WHERE u.creadoEl = :creadoEl")
    , @NamedQuery(name = "UnidadMedida.findByModificadoEl", query = "SELECT u FROM UnidadMedida u WHERE u.modificadoEl = :modificadoEl")
    , @NamedQuery(name = "UnidadMedida.findByEliminadoEl", query = "SELECT u FROM UnidadMedida u WHERE u.eliminadoEl = :eliminadoEl")})
public class UnidadMedida implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedidadId")
    private Collection<Receta> recetaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedidaId")
    private Collection<Producto> productoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadMedidaId")
    private Collection<Produccion> produccionCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
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

    public UnidadMedida() {
    }

    public UnidadMedida(Integer id) {
        this.id = id;
    }

    public UnidadMedida(Integer id, String codigo, String descripcion, Date creadoEl, Date modificadoEl, Date eliminadoEl) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        String oldDescripcion = this.descripcion;
        this.descripcion = descripcion;
        changeSupport.firePropertyChange("descripcion", oldDescripcion, descripcion);
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    @XmlTransient
    public Collection<Receta> getRecetaCollection() {
        return recetaCollection;
    }

    public void setRecetaCollection(Collection<Receta> recetaCollection) {
        this.recetaCollection = recetaCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<Produccion> getProduccionCollection() {
        return produccionCollection;
    }

    public void setProduccionCollection(Collection<Produccion> produccionCollection) {
        this.produccionCollection = produccionCollection;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
