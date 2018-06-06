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
@Table(name = "time_zone_leap_second")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeZoneLeapSecond.findAll", query = "SELECT t FROM TimeZoneLeapSecond t")
    , @NamedQuery(name = "TimeZoneLeapSecond.findByTransitiontime", query = "SELECT t FROM TimeZoneLeapSecond t WHERE t.transitiontime = :transitiontime")
    , @NamedQuery(name = "TimeZoneLeapSecond.findByCorrection", query = "SELECT t FROM TimeZoneLeapSecond t WHERE t.correction = :correction")})
public class TimeZoneLeapSecond implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Transition_time")
    private Long transitiontime;
    @Basic(optional = false)
    @Column(name = "Correction")
    private int correction;

    public TimeZoneLeapSecond() {
    }

    public TimeZoneLeapSecond(Long transitiontime) {
        this.transitiontime = transitiontime;
    }

    public TimeZoneLeapSecond(Long transitiontime, int correction) {
        this.transitiontime = transitiontime;
        this.correction = correction;
    }

    public Long getTransitiontime() {
        return transitiontime;
    }

    public void setTransitiontime(Long transitiontime) {
        this.transitiontime = transitiontime;
    }

    public int getCorrection() {
        return correction;
    }

    public void setCorrection(int correction) {
        this.correction = correction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transitiontime != null ? transitiontime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeZoneLeapSecond)) {
            return false;
        }
        TimeZoneLeapSecond other = (TimeZoneLeapSecond) object;
        if ((this.transitiontime == null && other.transitiontime != null) || (this.transitiontime != null && !this.transitiontime.equals(other.transitiontime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.TimeZoneLeapSecond[ transitiontime=" + transitiontime + " ]";
    }
    
}
