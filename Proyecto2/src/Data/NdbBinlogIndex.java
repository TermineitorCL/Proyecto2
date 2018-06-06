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
@Table(name = "ndb_binlog_index")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NdbBinlogIndex.findAll", query = "SELECT n FROM NdbBinlogIndex n")
    , @NamedQuery(name = "NdbBinlogIndex.findByPosition", query = "SELECT n FROM NdbBinlogIndex n WHERE n.position = :position")
    , @NamedQuery(name = "NdbBinlogIndex.findByFile", query = "SELECT n FROM NdbBinlogIndex n WHERE n.file = :file")
    , @NamedQuery(name = "NdbBinlogIndex.findByEpoch", query = "SELECT n FROM NdbBinlogIndex n WHERE n.ndbBinlogIndexPK.epoch = :epoch")
    , @NamedQuery(name = "NdbBinlogIndex.findByInserts", query = "SELECT n FROM NdbBinlogIndex n WHERE n.inserts = :inserts")
    , @NamedQuery(name = "NdbBinlogIndex.findByUpdates", query = "SELECT n FROM NdbBinlogIndex n WHERE n.updates = :updates")
    , @NamedQuery(name = "NdbBinlogIndex.findByDeletes", query = "SELECT n FROM NdbBinlogIndex n WHERE n.deletes = :deletes")
    , @NamedQuery(name = "NdbBinlogIndex.findBySchemaops", query = "SELECT n FROM NdbBinlogIndex n WHERE n.schemaops = :schemaops")
    , @NamedQuery(name = "NdbBinlogIndex.findByOrigServerId", query = "SELECT n FROM NdbBinlogIndex n WHERE n.ndbBinlogIndexPK.origServerId = :origServerId")
    , @NamedQuery(name = "NdbBinlogIndex.findByOrigEpoch", query = "SELECT n FROM NdbBinlogIndex n WHERE n.ndbBinlogIndexPK.origEpoch = :origEpoch")
    , @NamedQuery(name = "NdbBinlogIndex.findByGci", query = "SELECT n FROM NdbBinlogIndex n WHERE n.gci = :gci")
    , @NamedQuery(name = "NdbBinlogIndex.findByNextPosition", query = "SELECT n FROM NdbBinlogIndex n WHERE n.nextPosition = :nextPosition")
    , @NamedQuery(name = "NdbBinlogIndex.findByNextFile", query = "SELECT n FROM NdbBinlogIndex n WHERE n.nextFile = :nextFile")})
public class NdbBinlogIndex implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NdbBinlogIndexPK ndbBinlogIndexPK;
    @Basic(optional = false)
    @Column(name = "Position")
    private long position;
    @Basic(optional = false)
    @Column(name = "File")
    private String file;
    @Basic(optional = false)
    @Column(name = "inserts")
    private int inserts;
    @Basic(optional = false)
    @Column(name = "updates")
    private int updates;
    @Basic(optional = false)
    @Column(name = "deletes")
    private int deletes;
    @Basic(optional = false)
    @Column(name = "schemaops")
    private int schemaops;
    @Basic(optional = false)
    @Column(name = "gci")
    private int gci;
    @Basic(optional = false)
    @Column(name = "next_position")
    private long nextPosition;
    @Basic(optional = false)
    @Column(name = "next_file")
    private String nextFile;

    public NdbBinlogIndex() {
    }

    public NdbBinlogIndex(NdbBinlogIndexPK ndbBinlogIndexPK) {
        this.ndbBinlogIndexPK = ndbBinlogIndexPK;
    }

    public NdbBinlogIndex(NdbBinlogIndexPK ndbBinlogIndexPK, long position, String file, int inserts, int updates, int deletes, int schemaops, int gci, long nextPosition, String nextFile) {
        this.ndbBinlogIndexPK = ndbBinlogIndexPK;
        this.position = position;
        this.file = file;
        this.inserts = inserts;
        this.updates = updates;
        this.deletes = deletes;
        this.schemaops = schemaops;
        this.gci = gci;
        this.nextPosition = nextPosition;
        this.nextFile = nextFile;
    }

    public NdbBinlogIndex(long epoch, int origServerId, long origEpoch) {
        this.ndbBinlogIndexPK = new NdbBinlogIndexPK(epoch, origServerId, origEpoch);
    }

    public NdbBinlogIndexPK getNdbBinlogIndexPK() {
        return ndbBinlogIndexPK;
    }

    public void setNdbBinlogIndexPK(NdbBinlogIndexPK ndbBinlogIndexPK) {
        this.ndbBinlogIndexPK = ndbBinlogIndexPK;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getInserts() {
        return inserts;
    }

    public void setInserts(int inserts) {
        this.inserts = inserts;
    }

    public int getUpdates() {
        return updates;
    }

    public void setUpdates(int updates) {
        this.updates = updates;
    }

    public int getDeletes() {
        return deletes;
    }

    public void setDeletes(int deletes) {
        this.deletes = deletes;
    }

    public int getSchemaops() {
        return schemaops;
    }

    public void setSchemaops(int schemaops) {
        this.schemaops = schemaops;
    }

    public int getGci() {
        return gci;
    }

    public void setGci(int gci) {
        this.gci = gci;
    }

    public long getNextPosition() {
        return nextPosition;
    }

    public void setNextPosition(long nextPosition) {
        this.nextPosition = nextPosition;
    }

    public String getNextFile() {
        return nextFile;
    }

    public void setNextFile(String nextFile) {
        this.nextFile = nextFile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ndbBinlogIndexPK != null ? ndbBinlogIndexPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NdbBinlogIndex)) {
            return false;
        }
        NdbBinlogIndex other = (NdbBinlogIndex) object;
        if ((this.ndbBinlogIndexPK == null && other.ndbBinlogIndexPK != null) || (this.ndbBinlogIndexPK != null && !this.ndbBinlogIndexPK.equals(other.ndbBinlogIndexPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.NdbBinlogIndex[ ndbBinlogIndexPK=" + ndbBinlogIndexPK + " ]";
    }
    
}
