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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin2016
 */
@Entity
@Table(name = "time_zone_name")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeZoneName.findAll", query = "SELECT t FROM TimeZoneName t")
    , @NamedQuery(name = "TimeZoneName.findByName", query = "SELECT t FROM TimeZoneName t WHERE t.name = :name")
    , @NamedQuery(name = "TimeZoneName.findByTimezoneid", query = "SELECT t FROM TimeZoneName t WHERE t.timezoneid = :timezoneid")})
public class TimeZoneName implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Time_zone_id")
    private int timezoneid;

    public TimeZoneName() {
    }

    public TimeZoneName(String name) {
        this.name = name;
    }

    public TimeZoneName(String name, int timezoneid) {
        this.name = name;
        this.timezoneid = timezoneid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimezoneid() {
        return timezoneid;
    }

    public void setTimezoneid(int timezoneid) {
        this.timezoneid = timezoneid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeZoneName)) {
            return false;
        }
        TimeZoneName other = (TimeZoneName) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.TimeZoneName[ name=" + name + " ]";
    }
    
}
