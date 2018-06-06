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
 * @author Kevin2016
 */
@Entity
@Table(name = "func")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Func.findAll", query = "SELECT f FROM Func f")
    , @NamedQuery(name = "Func.findByName", query = "SELECT f FROM Func f WHERE f.name = :name")
    , @NamedQuery(name = "Func.findByRet", query = "SELECT f FROM Func f WHERE f.ret = :ret")
    , @NamedQuery(name = "Func.findByDl", query = "SELECT f FROM Func f WHERE f.dl = :dl")
    , @NamedQuery(name = "Func.findByType", query = "SELECT f FROM Func f WHERE f.type = :type")})
public class Func implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "ret")
    private boolean ret;
    @Basic(optional = false)
    @Column(name = "dl")
    private String dl;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public Func() {
    }

    public Func(String name) {
        this.name = name;
    }

    public Func(String name, boolean ret, String dl, String type) {
        this.name = name;
        this.ret = ret;
        this.dl = dl;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Func)) {
            return false;
        }
        Func other = (Func) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Func[ name=" + name + " ]";
    }
    
}
