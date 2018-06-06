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
@Table(name = "procs_priv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcsPriv.findAll", query = "SELECT p FROM ProcsPriv p")
    , @NamedQuery(name = "ProcsPriv.findByHost", query = "SELECT p FROM ProcsPriv p WHERE p.procsPrivPK.host = :host")
    , @NamedQuery(name = "ProcsPriv.findByDb", query = "SELECT p FROM ProcsPriv p WHERE p.procsPrivPK.db = :db")
    , @NamedQuery(name = "ProcsPriv.findByUser", query = "SELECT p FROM ProcsPriv p WHERE p.procsPrivPK.user = :user")
    , @NamedQuery(name = "ProcsPriv.findByRoutinename", query = "SELECT p FROM ProcsPriv p WHERE p.procsPrivPK.routinename = :routinename")
    , @NamedQuery(name = "ProcsPriv.findByRoutinetype", query = "SELECT p FROM ProcsPriv p WHERE p.procsPrivPK.routinetype = :routinetype")
    , @NamedQuery(name = "ProcsPriv.findByGrantor", query = "SELECT p FROM ProcsPriv p WHERE p.grantor = :grantor")
    , @NamedQuery(name = "ProcsPriv.findByProcpriv", query = "SELECT p FROM ProcsPriv p WHERE p.procpriv = :procpriv")
    , @NamedQuery(name = "ProcsPriv.findByTimestamp", query = "SELECT p FROM ProcsPriv p WHERE p.timestamp = :timestamp")})
public class ProcsPriv implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcsPrivPK procsPrivPK;
    @Basic(optional = false)
    @Column(name = "Grantor")
    private String grantor;
    @Basic(optional = false)
    @Column(name = "Proc_priv")
    private String procpriv;
    @Basic(optional = false)
    @Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public ProcsPriv() {
    }

    public ProcsPriv(ProcsPrivPK procsPrivPK) {
        this.procsPrivPK = procsPrivPK;
    }

    public ProcsPriv(ProcsPrivPK procsPrivPK, String grantor, String procpriv, Date timestamp) {
        this.procsPrivPK = procsPrivPK;
        this.grantor = grantor;
        this.procpriv = procpriv;
        this.timestamp = timestamp;
    }

    public ProcsPriv(String host, String db, String user, String routinename, String routinetype) {
        this.procsPrivPK = new ProcsPrivPK(host, db, user, routinename, routinetype);
    }

    public ProcsPrivPK getProcsPrivPK() {
        return procsPrivPK;
    }

    public void setProcsPrivPK(ProcsPrivPK procsPrivPK) {
        this.procsPrivPK = procsPrivPK;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public String getProcpriv() {
        return procpriv;
    }

    public void setProcpriv(String procpriv) {
        this.procpriv = procpriv;
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
        hash += (procsPrivPK != null ? procsPrivPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcsPriv)) {
            return false;
        }
        ProcsPriv other = (ProcsPriv) object;
        if ((this.procsPrivPK == null && other.procsPrivPK != null) || (this.procsPrivPK != null && !this.procsPrivPK.equals(other.procsPrivPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.ProcsPriv[ procsPrivPK=" + procsPrivPK + " ]";
    }
    
}
