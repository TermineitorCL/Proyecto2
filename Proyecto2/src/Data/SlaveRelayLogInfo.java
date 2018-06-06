/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin2016
 */
@Entity
@Table(name = "slave_relay_log_info")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SlaveRelayLogInfo.findAll", query = "SELECT s FROM SlaveRelayLogInfo s")
    , @NamedQuery(name = "SlaveRelayLogInfo.findByNumberoflines", query = "SELECT s FROM SlaveRelayLogInfo s WHERE s.numberoflines = :numberoflines")
    , @NamedQuery(name = "SlaveRelayLogInfo.findByRelaylogpos", query = "SELECT s FROM SlaveRelayLogInfo s WHERE s.relaylogpos = :relaylogpos")
    , @NamedQuery(name = "SlaveRelayLogInfo.findByMasterlogpos", query = "SELECT s FROM SlaveRelayLogInfo s WHERE s.masterlogpos = :masterlogpos")
    , @NamedQuery(name = "SlaveRelayLogInfo.findBySqldelay", query = "SELECT s FROM SlaveRelayLogInfo s WHERE s.sqldelay = :sqldelay")
    , @NamedQuery(name = "SlaveRelayLogInfo.findByNumberofworkers", query = "SELECT s FROM SlaveRelayLogInfo s WHERE s.numberofworkers = :numberofworkers")
    , @NamedQuery(name = "SlaveRelayLogInfo.findById", query = "SELECT s FROM SlaveRelayLogInfo s WHERE s.id = :id")
    , @NamedQuery(name = "SlaveRelayLogInfo.findByChannelname", query = "SELECT s FROM SlaveRelayLogInfo s WHERE s.channelname = :channelname")})
public class SlaveRelayLogInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Number_of_lines")
    private int numberoflines;
    @Basic(optional = false)
    @Lob
    @Column(name = "Relay_log_name")
    private String relaylogname;
    @Basic(optional = false)
    @Column(name = "Relay_log_pos")
    private long relaylogpos;
    @Basic(optional = false)
    @Lob
    @Column(name = "Master_log_name")
    private String masterlogname;
    @Basic(optional = false)
    @Column(name = "Master_log_pos")
    private long masterlogpos;
    @Basic(optional = false)
    @Column(name = "Sql_delay")
    private int sqldelay;
    @Basic(optional = false)
    @Column(name = "Number_of_workers")
    private int numberofworkers;
    @Basic(optional = false)
    @Column(name = "Id")
    private int id;
    @Id
    @Basic(optional = false)
    @Column(name = "Channel_name")
    private String channelname;

    public SlaveRelayLogInfo() {
    }

    public SlaveRelayLogInfo(String channelname) {
        this.channelname = channelname;
    }

    public SlaveRelayLogInfo(String channelname, int numberoflines, String relaylogname, long relaylogpos, String masterlogname, long masterlogpos, int sqldelay, int numberofworkers, int id) {
        this.channelname = channelname;
        this.numberoflines = numberoflines;
        this.relaylogname = relaylogname;
        this.relaylogpos = relaylogpos;
        this.masterlogname = masterlogname;
        this.masterlogpos = masterlogpos;
        this.sqldelay = sqldelay;
        this.numberofworkers = numberofworkers;
        this.id = id;
    }

    public int getNumberoflines() {
        return numberoflines;
    }

    public void setNumberoflines(int numberoflines) {
        this.numberoflines = numberoflines;
    }

    public String getRelaylogname() {
        return relaylogname;
    }

    public void setRelaylogname(String relaylogname) {
        this.relaylogname = relaylogname;
    }

    public long getRelaylogpos() {
        return relaylogpos;
    }

    public void setRelaylogpos(long relaylogpos) {
        this.relaylogpos = relaylogpos;
    }

    public String getMasterlogname() {
        return masterlogname;
    }

    public void setMasterlogname(String masterlogname) {
        this.masterlogname = masterlogname;
    }

    public long getMasterlogpos() {
        return masterlogpos;
    }

    public void setMasterlogpos(long masterlogpos) {
        this.masterlogpos = masterlogpos;
    }

    public int getSqldelay() {
        return sqldelay;
    }

    public void setSqldelay(int sqldelay) {
        this.sqldelay = sqldelay;
    }

    public int getNumberofworkers() {
        return numberofworkers;
    }

    public void setNumberofworkers(int numberofworkers) {
        this.numberofworkers = numberofworkers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (channelname != null ? channelname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SlaveRelayLogInfo)) {
            return false;
        }
        SlaveRelayLogInfo other = (SlaveRelayLogInfo) object;
        if ((this.channelname == null && other.channelname != null) || (this.channelname != null && !this.channelname.equals(other.channelname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.SlaveRelayLogInfo[ channelname=" + channelname + " ]";
    }
    
}
