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
@Table(name = "plugin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plugin.findAll", query = "SELECT p FROM Plugin p")
    , @NamedQuery(name = "Plugin.findByName", query = "SELECT p FROM Plugin p WHERE p.name = :name")
    , @NamedQuery(name = "Plugin.findByDl", query = "SELECT p FROM Plugin p WHERE p.dl = :dl")})
public class Plugin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "dl")
    private String dl;

    public Plugin() {
    }

    public Plugin(String name) {
        this.name = name;
    }

    public Plugin(String name, String dl) {
        this.name = name;
        this.dl = dl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
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
        if (!(object instanceof Plugin)) {
            return false;
        }
        Plugin other = (Plugin) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Plugin[ name=" + name + " ]";
    }
    
}
