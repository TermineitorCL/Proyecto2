/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "innodb_index_stats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InnodbIndexStats.findAll", query = "SELECT i FROM InnodbIndexStats i")
    , @NamedQuery(name = "InnodbIndexStats.findByDatabaseName", query = "SELECT i FROM InnodbIndexStats i WHERE i.innodbIndexStatsPK.databaseName = :databaseName")
    , @NamedQuery(name = "InnodbIndexStats.findByTableName", query = "SELECT i FROM InnodbIndexStats i WHERE i.innodbIndexStatsPK.tableName = :tableName")
    , @NamedQuery(name = "InnodbIndexStats.findByIndexName", query = "SELECT i FROM InnodbIndexStats i WHERE i.innodbIndexStatsPK.indexName = :indexName")
    , @NamedQuery(name = "InnodbIndexStats.findByLastUpdate", query = "SELECT i FROM InnodbIndexStats i WHERE i.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "InnodbIndexStats.findByStatName", query = "SELECT i FROM InnodbIndexStats i WHERE i.innodbIndexStatsPK.statName = :statName")
    , @NamedQuery(name = "InnodbIndexStats.findByStatValue", query = "SELECT i FROM InnodbIndexStats i WHERE i.statValue = :statValue")
    , @NamedQuery(name = "InnodbIndexStats.findBySampleSize", query = "SELECT i FROM InnodbIndexStats i WHERE i.sampleSize = :sampleSize")
    , @NamedQuery(name = "InnodbIndexStats.findByStatDescription", query = "SELECT i FROM InnodbIndexStats i WHERE i.statDescription = :statDescription")})
public class InnodbIndexStats implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InnodbIndexStatsPK innodbIndexStatsPK;
    @Basic(optional = false)
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    @Column(name = "stat_value")
    private long statValue;
    @Column(name = "sample_size")
    private BigInteger sampleSize;
    @Basic(optional = false)
    @Column(name = "stat_description")
    private String statDescription;

    public InnodbIndexStats() {
    }

    public InnodbIndexStats(InnodbIndexStatsPK innodbIndexStatsPK) {
        this.innodbIndexStatsPK = innodbIndexStatsPK;
    }

    public InnodbIndexStats(InnodbIndexStatsPK innodbIndexStatsPK, Date lastUpdate, long statValue, String statDescription) {
        this.innodbIndexStatsPK = innodbIndexStatsPK;
        this.lastUpdate = lastUpdate;
        this.statValue = statValue;
        this.statDescription = statDescription;
    }

    public InnodbIndexStats(String databaseName, String tableName, String indexName, String statName) {
        this.innodbIndexStatsPK = new InnodbIndexStatsPK(databaseName, tableName, indexName, statName);
    }

    public InnodbIndexStatsPK getInnodbIndexStatsPK() {
        return innodbIndexStatsPK;
    }

    public void setInnodbIndexStatsPK(InnodbIndexStatsPK innodbIndexStatsPK) {
        this.innodbIndexStatsPK = innodbIndexStatsPK;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public long getStatValue() {
        return statValue;
    }

    public void setStatValue(long statValue) {
        this.statValue = statValue;
    }

    public BigInteger getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(BigInteger sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getStatDescription() {
        return statDescription;
    }

    public void setStatDescription(String statDescription) {
        this.statDescription = statDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (innodbIndexStatsPK != null ? innodbIndexStatsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InnodbIndexStats)) {
            return false;
        }
        InnodbIndexStats other = (InnodbIndexStats) object;
        if ((this.innodbIndexStatsPK == null && other.innodbIndexStatsPK != null) || (this.innodbIndexStatsPK != null && !this.innodbIndexStatsPK.equals(other.innodbIndexStatsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.InnodbIndexStats[ innodbIndexStatsPK=" + innodbIndexStatsPK + " ]";
    }
    
}
