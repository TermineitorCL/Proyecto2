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
@Table(name = "innodb_table_stats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InnodbTableStats.findAll", query = "SELECT i FROM InnodbTableStats i")
    , @NamedQuery(name = "InnodbTableStats.findByDatabaseName", query = "SELECT i FROM InnodbTableStats i WHERE i.innodbTableStatsPK.databaseName = :databaseName")
    , @NamedQuery(name = "InnodbTableStats.findByTableName", query = "SELECT i FROM InnodbTableStats i WHERE i.innodbTableStatsPK.tableName = :tableName")
    , @NamedQuery(name = "InnodbTableStats.findByLastUpdate", query = "SELECT i FROM InnodbTableStats i WHERE i.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "InnodbTableStats.findByNRows", query = "SELECT i FROM InnodbTableStats i WHERE i.nRows = :nRows")
    , @NamedQuery(name = "InnodbTableStats.findByClusteredIndexSize", query = "SELECT i FROM InnodbTableStats i WHERE i.clusteredIndexSize = :clusteredIndexSize")
    , @NamedQuery(name = "InnodbTableStats.findBySumOfOtherIndexSizes", query = "SELECT i FROM InnodbTableStats i WHERE i.sumOfOtherIndexSizes = :sumOfOtherIndexSizes")})
public class InnodbTableStats implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InnodbTableStatsPK innodbTableStatsPK;
    @Basic(optional = false)
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    @Column(name = "n_rows")
    private long nRows;
    @Basic(optional = false)
    @Column(name = "clustered_index_size")
    private long clusteredIndexSize;
    @Basic(optional = false)
    @Column(name = "sum_of_other_index_sizes")
    private long sumOfOtherIndexSizes;

    public InnodbTableStats() {
    }

    public InnodbTableStats(InnodbTableStatsPK innodbTableStatsPK) {
        this.innodbTableStatsPK = innodbTableStatsPK;
    }

    public InnodbTableStats(InnodbTableStatsPK innodbTableStatsPK, Date lastUpdate, long nRows, long clusteredIndexSize, long sumOfOtherIndexSizes) {
        this.innodbTableStatsPK = innodbTableStatsPK;
        this.lastUpdate = lastUpdate;
        this.nRows = nRows;
        this.clusteredIndexSize = clusteredIndexSize;
        this.sumOfOtherIndexSizes = sumOfOtherIndexSizes;
    }

    public InnodbTableStats(String databaseName, String tableName) {
        this.innodbTableStatsPK = new InnodbTableStatsPK(databaseName, tableName);
    }

    public InnodbTableStatsPK getInnodbTableStatsPK() {
        return innodbTableStatsPK;
    }

    public void setInnodbTableStatsPK(InnodbTableStatsPK innodbTableStatsPK) {
        this.innodbTableStatsPK = innodbTableStatsPK;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public long getNRows() {
        return nRows;
    }

    public void setNRows(long nRows) {
        this.nRows = nRows;
    }

    public long getClusteredIndexSize() {
        return clusteredIndexSize;
    }

    public void setClusteredIndexSize(long clusteredIndexSize) {
        this.clusteredIndexSize = clusteredIndexSize;
    }

    public long getSumOfOtherIndexSizes() {
        return sumOfOtherIndexSizes;
    }

    public void setSumOfOtherIndexSizes(long sumOfOtherIndexSizes) {
        this.sumOfOtherIndexSizes = sumOfOtherIndexSizes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (innodbTableStatsPK != null ? innodbTableStatsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InnodbTableStats)) {
            return false;
        }
        InnodbTableStats other = (InnodbTableStats) object;
        if ((this.innodbTableStatsPK == null && other.innodbTableStatsPK != null) || (this.innodbTableStatsPK != null && !this.innodbTableStatsPK.equals(other.innodbTableStatsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.InnodbTableStats[ innodbTableStatsPK=" + innodbTableStatsPK + " ]";
    }
    
}
