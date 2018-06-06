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
public class InnodbIndexStatsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "database_name")
    private String databaseName;
    @Basic(optional = false)
    @Column(name = "table_name")
    private String tableName;
    @Basic(optional = false)
    @Column(name = "index_name")
    private String indexName;
    @Basic(optional = false)
    @Column(name = "stat_name")
    private String statName;

    public InnodbIndexStatsPK() {
    }

    public InnodbIndexStatsPK(String databaseName, String tableName, String indexName, String statName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.indexName = indexName;
        this.statName = statName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (databaseName != null ? databaseName.hashCode() : 0);
        hash += (tableName != null ? tableName.hashCode() : 0);
        hash += (indexName != null ? indexName.hashCode() : 0);
        hash += (statName != null ? statName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InnodbIndexStatsPK)) {
            return false;
        }
        InnodbIndexStatsPK other = (InnodbIndexStatsPK) object;
        if ((this.databaseName == null && other.databaseName != null) || (this.databaseName != null && !this.databaseName.equals(other.databaseName))) {
            return false;
        }
        if ((this.tableName == null && other.tableName != null) || (this.tableName != null && !this.tableName.equals(other.tableName))) {
            return false;
        }
        if ((this.indexName == null && other.indexName != null) || (this.indexName != null && !this.indexName.equals(other.indexName))) {
            return false;
        }
        if ((this.statName == null && other.statName != null) || (this.statName != null && !this.statName.equals(other.statName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.InnodbIndexStatsPK[ databaseName=" + databaseName + ", tableName=" + tableName + ", indexName=" + indexName + ", statName=" + statName + " ]";
    }
    
}
