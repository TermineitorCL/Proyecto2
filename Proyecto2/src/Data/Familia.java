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
@Table(name = "familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Familia.findAll", query = "SELECT f FROM Familia f")
    , @NamedQuery(name = "Familia.findById", query = "SELECT f FROM Familia f WHERE f.id = :id")
    , @NamedQuery(name = "Familia.findByNombre", query = "SELECT f FROM Familia f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Familia.findByCreadoEl", query = "SELECT f FROM Familia f WHERE f.creadoEl = :creadoEl")
    , @NamedQuery(name = "Familia.findByModificadoEl", query = "SELECT f FROM Familia f WHERE f.modificadoEl = :modificadoEl")
    , @NamedQuery(name = "Familia.findByEliminadoEl", query = "SELECT f FROM Familia f WHERE f.eliminadoEl = :eliminadoEl")
    , @NamedQuery(name = "Familia.findByLineaId", query = "SELECT f FROM Familia f WHERE f.lineaId = :lineaId")})
public class Familia implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "linea_id")
    private int lineaId;

    public Familia() {
    }

    public Familia(Integer id) {
        this.id = id;
    }

    public Familia(Integer id, String nombre, Date creadoEl, Date modificadoEl, Date eliminadoEl, int lineaId) {
        this.id = id;
        this.nombre = nombre;
        this.creadoEl = creadoEl;
        this.modificadoEl = modificadoEl;
        this.eliminadoEl = eliminadoEl;
        this.lineaId = lineaId;
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

    public int getLineaId() {
        return lineaId;
    }

    public void setLineaId(int lineaId) {
        this.lineaId = lineaId;
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
        return "Data.Familia[ id=" + id + " ]";
    }
    
}
