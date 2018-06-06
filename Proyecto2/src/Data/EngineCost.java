/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "engine_cost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngineCost.findAll", query = "SELECT e FROM EngineCost e")
    , @NamedQuery(name = "EngineCost.findByEngineName", query = "SELECT e FROM EngineCost e WHERE e.engineCostPK.engineName = :engineName")
    , @NamedQuery(name = "EngineCost.findByDeviceType", query = "SELECT e FROM EngineCost e WHERE e.engineCostPK.deviceType = :deviceType")
    , @NamedQuery(name = "EngineCost.findByCostName", query = "SELECT e FROM EngineCost e WHERE e.engineCostPK.costName = :costName")
    , @NamedQuery(name = "EngineCost.findByCostValue", query = "SELECT e FROM EngineCost e WHERE e.costValue = :costValue")
    , @NamedQuery(name = "EngineCost.findByLastUpdate", query = "SELECT e FROM EngineCost e WHERE e.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "EngineCost.findByComment", query = "SELECT e FROM EngineCost e WHERE e.comment = :comment")})
public class EngineCost implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EngineCostPK engineCostPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost_value")
    private Float costValue;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Column(name = "comment")
    private String comment;

    public EngineCost() {
    }

    public EngineCost(EngineCostPK engineCostPK) {
        this.engineCostPK = engineCostPK;
    }

    public EngineCost(String engineName, int deviceType, String costName) {
        this.engineCostPK = new EngineCostPK(engineName, deviceType, costName);
    }

    public EngineCostPK getEngineCostPK() {
        return engineCostPK;
    }

    public void setEngineCostPK(EngineCostPK engineCostPK) {
        this.engineCostPK = engineCostPK;
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
        hash += (engineCostPK != null ? engineCostPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngineCost)) {
            return false;
        }
        EngineCost other = (EngineCost) object;
        if ((this.engineCostPK == null && other.engineCostPK != null) || (this.engineCostPK != null && !this.engineCostPK.equals(other.engineCostPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.EngineCost[ engineCostPK=" + engineCostPK + " ]";
    }
    
}
