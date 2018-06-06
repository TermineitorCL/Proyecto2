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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "time_zone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeZone.findAll", query = "SELECT t FROM TimeZone t")
    , @NamedQuery(name = "TimeZone.findByTimezoneid", query = "SELECT t FROM TimeZone t WHERE t.timezoneid = :timezoneid")
    , @NamedQuery(name = "TimeZone.findByUseleapseconds", query = "SELECT t FROM TimeZone t WHERE t.useleapseconds = :useleapseconds")})
public class TimeZone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Time_zone_id")
    private Integer timezoneid;
    @Basic(optional = false)
    @Column(name = "Use_leap_seconds")
    private String useleapseconds;

    public TimeZone() {
    }

    public TimeZone(Integer timezoneid) {
        this.timezoneid = timezoneid;
    }

    public TimeZone(Integer timezoneid, String useleapseconds) {
        this.timezoneid = timezoneid;
        this.useleapseconds = useleapseconds;
    }

    public Integer getTimezoneid() {
        return timezoneid;
    }

    public void setTimezoneid(Integer timezoneid) {
        this.timezoneid = timezoneid;
    }

    public String getUseleapseconds() {
        return useleapseconds;
    }

    public void setUseleapseconds(String useleapseconds) {
        this.useleapseconds = useleapseconds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timezoneid != null ? timezoneid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeZone)) {
            return false;
        }
        TimeZone other = (TimeZone) object;
        if ((this.timezoneid == null && other.timezoneid != null) || (this.timezoneid != null && !this.timezoneid.equals(other.timezoneid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.TimeZone[ timezoneid=" + timezoneid + " ]";
    }
    
}
