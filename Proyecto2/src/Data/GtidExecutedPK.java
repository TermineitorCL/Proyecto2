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
public class GtidExecutedPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "source_uuid")
    private String sourceUuid;
    @Basic(optional = false)
    @Column(name = "interval_start")
    private long intervalStart;

    public GtidExecutedPK() {
    }

    public GtidExecutedPK(String sourceUuid, long intervalStart) {
        this.sourceUuid = sourceUuid;
        this.intervalStart = intervalStart;
    }

    public String getSourceUuid() {
        return sourceUuid;
    }

    public void setSourceUuid(String sourceUuid) {
        this.sourceUuid = sourceUuid;
    }

    public long getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(long intervalStart) {
        this.intervalStart = intervalStart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sourceUuid != null ? sourceUuid.hashCode() : 0);
        hash += (int) intervalStart;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GtidExecutedPK)) {
            return false;
        }
        GtidExecutedPK other = (GtidExecutedPK) object;
        if ((this.sourceUuid == null && other.sourceUuid != null) || (this.sourceUuid != null && !this.sourceUuid.equals(other.sourceUuid))) {
            return false;
        }
        if (this.intervalStart != other.intervalStart) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.GtidExecutedPK[ sourceUuid=" + sourceUuid + ", intervalStart=" + intervalStart + " ]";
    }
    
}
