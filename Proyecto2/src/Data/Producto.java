/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

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
    , @NamedQuery(name = "Producto.findByFamiliaId", query = "SELECT p FROM Producto p WHERE p.familiaId = :familiaId")
    , @NamedQuery(name = "Producto.findByUnidadMedidaId", query = "SELECT p FROM Producto p WHERE p.unidadMedidaId = :unidadMedidaId")
    , @NamedQuery(name = "Producto.findByCreadoEl", query = "SELECT p FROM Producto p WHERE p.creadoEl = :creadoEl")
    , @NamedQuery(name = "Producto.findByModificadoEl", query = "SELECT p FROM Producto p WHERE p.modificadoEl = :modificadoEl")
    , @NamedQuery(name = "Producto.findByEliminadoEl", query = "SELECT p FROM Producto p WHERE p.eliminadoEl = :eliminadoEl")})
public class Producto implements Serializable {

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
    @Column(name = "formato")
    private int formato;
    @Basic(optional = false)
    @Column(name = "familia_id")
    private int familiaId;
    @Basic(optional = false)
    @Column(name = "unidad_medida_id")
    private int unidadMedidaId;
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

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, String marca, int formato, int familiaId, int unidadMedidaId, Date creadoEl, Date modificadoEl, Date eliminadoEl) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.formato = formato;
        this.familiaId = familiaId;
        this.unidadMedidaId = unidadMedidaId;
        this.creadoEl = creadoEl;
        this.modificadoEl = modificadoEl;
        this.eliminadoEl = eliminadoEl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getFormato() {
        return formato;
    }

    public void setFormato(int formato) {
        this.formato = formato;
    }

    public int getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(int familiaId) {
        this.familiaId = familiaId;
    }

    public int getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(int unidadMedidaId) {
        this.unidadMedidaId = unidadMedidaId;
    }

    public Date getCreadoEl() {
        return creadoEl;
    }

    public void setCreadoEl(Date creadoEl) {
        this.creadoEl = creadoEl;
    }

    public Date getModificadoEl() {
        return modificadoEl;
    }

    public void setModificadoEl(Date modificadoEl) {
        this.modificadoEl = modificadoEl;
    }

    public Date getEliminadoEl() {
        return eliminadoEl;
    }

    public void setEliminadoEl(Date eliminadoEl) {
        this.eliminadoEl = eliminadoEl;
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
        return "Data.Producto[ id=" + id + " ]";
    }
    
}
