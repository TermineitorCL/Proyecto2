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
public class InnodbTableStatsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "database_name")
    private String databaseName;
    @Basic(optional = false)
    @Column(name = "table_name")
    private String tableName;

    public InnodbTableStatsPK() {
    }

    public InnodbTableStatsPK(String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (databaseName != null ? databaseName.hashCode() : 0);
        hash += (tableName != null ? tableName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InnodbTableStatsPK)) {
            return false;
        }
        InnodbTableStatsPK other = (InnodbTableStatsPK) object;
        if ((this.databaseName == null && other.databaseName != null) || (this.databaseName != null && !this.databaseName.equals(other.databaseName))) {
            return false;
        }
        if ((this.tableName == null && other.tableName != null) || (this.tableName != null && !this.tableName.equals(other.tableName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.InnodbTableStatsPK[ databaseName=" + databaseName + ", tableName=" + tableName + " ]";
    }
    
}
