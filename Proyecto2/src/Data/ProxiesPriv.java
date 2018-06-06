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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin2016
 */
@Entity
@Table(name = "proxies_priv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProxiesPriv.findAll", query = "SELECT p FROM ProxiesPriv p")
    , @NamedQuery(name = "ProxiesPriv.findByHost", query = "SELECT p FROM ProxiesPriv p WHERE p.proxiesPrivPK.host = :host")
    , @NamedQuery(name = "ProxiesPriv.findByUser", query = "SELECT p FROM ProxiesPriv p WHERE p.proxiesPrivPK.user = :user")
    , @NamedQuery(name = "ProxiesPriv.findByProxiedhost", query = "SELECT p FROM ProxiesPriv p WHERE p.proxiesPrivPK.proxiedhost = :proxiedhost")
    , @NamedQuery(name = "ProxiesPriv.findByProxieduser", query = "SELECT p FROM ProxiesPriv p WHERE p.proxiesPrivPK.proxieduser = :proxieduser")
    , @NamedQuery(name = "ProxiesPriv.findByWithgrant", query = "SELECT p FROM ProxiesPriv p WHERE p.withgrant = :withgrant")
    , @NamedQuery(name = "ProxiesPriv.findByGrantor", query = "SELECT p FROM ProxiesPriv p WHERE p.grantor = :grantor")
    , @NamedQuery(name = "ProxiesPriv.findByTimestamp", query = "SELECT p FROM ProxiesPriv p WHERE p.timestamp = :timestamp")})
public class ProxiesPriv implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProxiesPrivPK proxiesPrivPK;
    @Basic(optional = false)
    @Column(name = "With_grant")
    private boolean withgrant;
    @Basic(optional = false)
    @Column(name = "Grantor")
    private String grantor;
    @Basic(optional = false)
    @Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public ProxiesPriv() {
    }

    public ProxiesPriv(ProxiesPrivPK proxiesPrivPK) {
        this.proxiesPrivPK = proxiesPrivPK;
    }

    public ProxiesPriv(ProxiesPrivPK proxiesPrivPK, boolean withgrant, String grantor, Date timestamp) {
        this.proxiesPrivPK = proxiesPrivPK;
        this.withgrant = withgrant;
        this.grantor = grantor;
        this.timestamp = timestamp;
    }

    public ProxiesPriv(String host, String user, String proxiedhost, String proxieduser) {
        this.proxiesPrivPK = new ProxiesPrivPK(host, user, proxiedhost, proxieduser);
    }

    public ProxiesPrivPK getProxiesPrivPK() {
        return proxiesPrivPK;
    }

    public void setProxiesPrivPK(ProxiesPrivPK proxiesPrivPK) {
        this.proxiesPrivPK = proxiesPrivPK;
    }

    public boolean getWithgrant() {
        return withgrant;
    }

    public void setWithgrant(boolean withgrant) {
        this.withgrant = withgrant;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proxiesPrivPK != null ? proxiesPrivPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProxiesPriv)) {
            return false;
        }
        ProxiesPriv other = (ProxiesPriv) object;
        if ((this.proxiesPrivPK == null && other.proxiesPrivPK != null) || (this.proxiesPrivPK != null && !this.proxiesPrivPK.equals(other.proxiesPrivPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.ProxiesPriv[ proxiesPrivPK=" + proxiesPrivPK + " ]";
    }
    
}
