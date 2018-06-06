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
import javax.persistence.Id;
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
@Table(name = "server_cost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServerCost.findAll", query = "SELECT s FROM ServerCost s")
    , @NamedQuery(name = "ServerCost.findByCostName", query = "SELECT s FROM ServerCost s WHERE s.costName = :costName")
    , @NamedQuery(name = "ServerCost.findByCostValue", query = "SELECT s FROM ServerCost s WHERE s.costValue = :costValue")
    , @NamedQuery(name = "ServerCost.findByLastUpdate", query = "SELECT s FROM ServerCost s WHERE s.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "ServerCost.findByComment", query = "SELECT s FROM ServerCost s WHERE s.comment = :comment")})
public class ServerCost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cost_name")
    private String costName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost_value")
    private Float costValue;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "comment")
    private String comment;

    public ServerCost() {
    }

    public ServerCost(String costName) {
        this.costName = costName;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public Float getCostValue() {
        return costValue;
    }

    public void setCostValue(Float costValue) {
        this.costValue = costValue;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costName != null ? costName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServerCost)) {
            return false;
        }
        ServerCost other = (ServerCost) object;
        if ((this.costName == null && other.costName != null) || (this.costName != null && !this.costName.equals(other.costName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.ServerCost[ costName=" + costName + " ]";
    }
    
}
