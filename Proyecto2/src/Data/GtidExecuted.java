/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin2016
 */
@Entity
@Table(name = "gtid_executed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GtidExecuted.findAll", query = "SELECT g FROM GtidExecuted g")
    , @NamedQuery(name = "GtidExecuted.findBySourceUuid", query = "SELECT g FROM GtidExecuted g WHERE g.gtidExecutedPK.sourceUuid = :sourceUuid")
    , @NamedQuery(name = "GtidExecuted.findByIntervalStart", query = "SELECT g FROM GtidExecuted g WHERE g.gtidExecutedPK.intervalStart = :intervalStart")
    , @NamedQuery(name = "GtidExecuted.findByIntervalEnd", query = "SELECT g FROM GtidExecuted g WHERE g.intervalEnd = :intervalEnd")})
public class GtidExecuted implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GtidExecutedPK gtidExecutedPK;
    @Basic(optional = false)
    @Column(name = "interval_end")
    private long intervalEnd;

    public GtidExecuted() {
    }

    public GtidExecuted(GtidExecutedPK gtidExecutedPK) {
        this.gtidExecutedPK = gtidExecutedPK;
    }

    public GtidExecuted(GtidExecutedPK gtidExecutedPK, long intervalEnd) {
        this.gtidExecutedPK = gtidExecutedPK;
        this.intervalEnd = intervalEnd;
    }

    public GtidExecuted(String sourceUuid, long intervalStart) {
        this.gtidExecutedPK = new GtidExecutedPK(sourceUuid, intervalStart);
    }

    public GtidExecutedPK getGtidExecutedPK() {
        return gtidExecutedPK;
    }

    public void setGtidExecutedPK(GtidExecutedPK gtidExecutedPK) {
        this.gtidExecutedPK = gtidExecutedPK;
    }

    public long getIntervalEnd() {
        return intervalEnd;
    }

    public void setIntervalEnd(long intervalEnd) {
        this.intervalEnd = intervalEnd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gtidExecutedPK != null ? gtidExecutedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GtidExecuted)) {
            return false;
        }
        GtidExecuted other = (GtidExecuted) object;
        if ((this.gtidExecutedPK == null && other.gtidExecutedPK != null) || (this.gtidExecutedPK != null && !this.gtidExecutedPK.equals(other.gtidExecutedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.GtidExecuted[ gtidExecutedPK=" + gtidExecutedPK + " ]";
    }
    
}
