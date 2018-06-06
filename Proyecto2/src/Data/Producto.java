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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByMarca", query = "SELECT p FROM Producto p WHERE p.marca = :marca")
    , @NamedQuery(name = "Producto.findByFormato", query = "SELECT p FROM Producto p WHERE p.formato = :formato")
    , @NamedQuery(name = "Producto.findByCreadoEl", query = "SELECT p FROM Producto p WHERE p.creadoEl = :creadoEl")
    , @NamedQuery(name = "Producto.findByModificadoEl", query = "SELECT p FROM Producto p WHERE p.modificadoEl = :modificadoEl")
    , @NamedQuery(name = "Producto.findByEliminadoEl", query = "SELECT p FROM Producto p WHERE p.eliminadoEl = :eliminadoEl")})
public class Producto implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<Produccion> produccionCollection;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Basic(optional = false)
    @Column(name = "formato")
    private String formato;
    @Basic(optional = false)
    @Column(name = "codigo_barra")
    private int codigoBarra;
    @JoinColumn(name = "linea_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Linea lineaId;

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
    @Column(name = "marca")
    private String marca;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<Receta> recetaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<Costo> costoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private Collection<DetalleReceta> detalleRecetaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private Collection<PrecioVenta> precioVentaCollection;
    @JoinColumn(name = "familia_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Familia familiaId;
    @JoinColumn(name = "unidad_medida_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnidadMedida unidadMedidaId;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, String marca, String formato, Date creadoEl, Date modificadoEl, Date eliminadoEl) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.formato = formato;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        changeSupport.firePropertyChange("marca", oldMarca, marca);
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

    @XmlTransient
    public Collection<Receta> getRecetaCollection() {
        return recetaCollection;
    }

    public void setRecetaCollection(Collection<Receta> recetaCollection) {
        this.recetaCollection = recetaCollection;
    }

    @XmlTransient
    public Collection<Costo> getCostoCollection() {
        return costoCollection;
    }

    public void setCostoCollection(Collection<Costo> costoCollection) {
        this.costoCollection = costoCollection;
    }

    @XmlTransient
    public Collection<DetalleReceta> getDetalleRecetaCollection() {
        return detalleRecetaCollection;
    }

    public void setDetalleRecetaCollection(Collection<DetalleReceta> detalleRecetaCollection) {
        this.detalleRecetaCollection = detalleRecetaCollection;
    }

    @XmlTransient
    public Collection<PrecioVenta> getPrecioVentaCollection() {
        return precioVentaCollection;
    }

    public void setPrecioVentaCollection(Collection<PrecioVenta> precioVentaCollection) {
        this.precioVentaCollection = precioVentaCollection;
    }

    public Familia getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(Familia familiaId) {
        Familia oldFamiliaId = this.familiaId;
        this.familiaId = familiaId;
        changeSupport.firePropertyChange("familiaId", oldFamiliaId, familiaId);
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        String oldFormato = this.formato;
        this.formato = formato;
        changeSupport.firePropertyChange("formato", oldFormato, formato);
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        int oldCodigoBarra = this.codigoBarra;
        this.codigoBarra = codigoBarra;
        changeSupport.firePropertyChange("codigoBarra", oldCodigoBarra, codigoBarra);
    }

    public Linea getLineaId() {
        return lineaId;
    }

    public void setLineaId(Linea lineaId) {
        Linea oldLineaId = this.lineaId;
        this.lineaId = lineaId;
        changeSupport.firePropertyChange("lineaId", oldLineaId, lineaId);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @XmlTransient
    public Collection<Produccion> getProduccionCollection() {
        return produccionCollection;
    }

    public void setProduccionCollection(Collection<Produccion> produccionCollection) {
        this.produccionCollection = produccionCollection;
    }
   
    
}
