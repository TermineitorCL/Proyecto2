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
@Table(name = "time_zone_transition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeZoneTransition.findAll", query = "SELECT t FROM TimeZoneTransition t")
    , @NamedQuery(name = "TimeZoneTransition.findByTimezoneid", query = "SELECT t FROM TimeZoneTransition t WHERE t.timeZoneTransitionPK.timezoneid = :timezoneid")
    , @NamedQuery(name = "TimeZoneTransition.findByTransitiontime", query = "SELECT t FROM TimeZoneTransition t WHERE t.timeZoneTransitionPK.transitiontime = :transitiontime")
    , @NamedQuery(name = "TimeZoneTransition.findByTransitiontypeid", query = "SELECT t FROM TimeZoneTransition t WHERE t.transitiontypeid = :transitiontypeid")})
public class TimeZoneTransition implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimeZoneTransitionPK timeZoneTransitionPK;
    @Basic(optional = false)
    @Column(name = "Transition_type_id")
    private int transitiontypeid;

    public TimeZoneTransition() {
    }

    public TimeZoneTransition(TimeZoneTransitionPK timeZoneTransitionPK) {
        this.timeZoneTransitionPK = timeZoneTransitionPK;
    }

    public TimeZoneTransition(TimeZoneTransitionPK timeZoneTransitionPK, int transitiontypeid) {
        this.timeZoneTransitionPK = timeZoneTransitionPK;
        this.transitiontypeid = transitiontypeid;
    }

    public TimeZoneTransition(int timezoneid, long transitiontime) {
        this.timeZoneTransitionPK = new TimeZoneTransitionPK(timezoneid, transitiontime);
    }

    public TimeZoneTransitionPK getTimeZoneTransitionPK() {
        return timeZoneTransitionPK;
    }

    public void setTimeZoneTransitionPK(TimeZoneTransitionPK timeZoneTransitionPK) {
        this.timeZoneTransitionPK = timeZoneTransitionPK;
    }

    public int getTransitiontypeid() {
        return transitiontypeid;
    }

    public void setTransitiontypeid(int transitiontypeid) {
        this.transitiontypeid = transitiontypeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeZoneTransitionPK != null ? timeZoneTransitionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeZoneTransition)) {
            return false;
        }
        TimeZoneTransition other = (TimeZoneTransition) object;
        if ((this.timeZoneTransitionPK == null && other.timeZoneTransitionPK != null) || (this.timeZoneTransitionPK != null && !this.timeZoneTransitionPK.equals(other.timeZoneTransitionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.TimeZoneTransition[ timeZoneTransitionPK=" + timeZoneTransitionPK + " ]";
    }
    
}
