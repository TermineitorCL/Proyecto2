/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Kevin2016
 */
@Embeddable
public class EngineCostPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "engine_name")
    private String engineName;
    @Basic(optional = false)
    @Column(name = "device_type")
    private int deviceType;
    @Basic(optional = false)
    @Column(name = "cost_name")
    private String costName;

    public EngineCostPK() {
    }

    public EngineCostPK(String engineName, int deviceType, String costName) {
        this.engineName = engineName;
        this.deviceType = deviceType;
        this.costName = costName;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (engineName != null ? engineName.hashCode() : 0);
        hash += (int) deviceType;
        hash += (costName != null ? costName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EngineCostPK)) {
            return false;
        }
        EngineCostPK other = (EngineCostPK) object;
        if ((this.engineName == null && other.engineName != null) || (this.engineName != null && !this.engineName.equals(other.engineName))) {
            return false;
        }
        if (this.deviceType != other.deviceType) {
            return false;
        }
        if ((this.costName == null && other.costName != null) || (this.costName != null && !this.costName.equals(other.costName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.EngineCostPK[ engineName=" + engineName + ", deviceType=" + deviceType + ", costName=" + costName + " ]";
    }
    
}
