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
public class SlaveWorkerInfoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Id")
    private int id;
    @Basic(optional = false)
    @Column(name = "Channel_name")
    private String channelname;

    public SlaveWorkerInfoPK() {
    }

    public SlaveWorkerInfoPK(int id, String channelname) {
        this.id = id;
        this.channelname = channelname;
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
        hash += (int) id;
        hash += (channelname != null ? channelname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SlaveWorkerInfoPK)) {
            return false;
        }
        SlaveWorkerInfoPK other = (SlaveWorkerInfoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.channelname == null && other.channelname != null) || (this.channelname != null && !this.channelname.equals(other.channelname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.SlaveWorkerInfoPK[ id=" + id + ", channelname=" + channelname + " ]";
    }
    
}
