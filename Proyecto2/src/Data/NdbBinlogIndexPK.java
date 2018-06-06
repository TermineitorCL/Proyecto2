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
public class NdbBinlogIndexPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "epoch")
    private long epoch;
    @Basic(optional = false)
    @Column(name = "orig_server_id")
    private int origServerId;
    @Basic(optional = false)
    @Column(name = "orig_epoch")
    private long origEpoch;

    public NdbBinlogIndexPK() {
    }

    public NdbBinlogIndexPK(long epoch, int origServerId, long origEpoch) {
        this.epoch = epoch;
        this.origServerId = origServerId;
        this.origEpoch = origEpoch;
    }

    public long getEpoch() {
        return epoch;
    }

    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }

    public int getOrigServerId() {
        return origServerId;
    }

    public void setOrigServerId(int origServerId) {
        this.origServerId = origServerId;
    }

    public long getOrigEpoch() {
        return origEpoch;
    }

    public void setOrigEpoch(long origEpoch) {
        this.origEpoch = origEpoch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) epoch;
        hash += (int) origServerId;
        hash += (int) origEpoch;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NdbBinlogIndexPK)) {
            return false;
        }
        NdbBinlogIndexPK other = (NdbBinlogIndexPK) object;
        if (this.epoch != other.epoch) {
            return false;
        }
        if (this.origServerId != other.origServerId) {
            return false;
        }
        if (this.origEpoch != other.origEpoch) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.NdbBinlogIndexPK[ epoch=" + epoch + ", origServerId=" + origServerId + ", origEpoch=" + origEpoch + " ]";
    }
    
}
