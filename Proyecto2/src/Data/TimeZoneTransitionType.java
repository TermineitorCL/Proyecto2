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
@Table(name = "time_zone_transition_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TimeZoneTransitionType.findAll", query = "SELECT t FROM TimeZoneTransitionType t")
    , @NamedQuery(name = "TimeZoneTransitionType.findByTimezoneid", query = "SELECT t FROM TimeZoneTransitionType t WHERE t.timeZoneTransitionTypePK.timezoneid = :timezoneid")
    , @NamedQuery(name = "TimeZoneTransitionType.findByTransitiontypeid", query = "SELECT t FROM TimeZoneTransitionType t WHERE t.timeZoneTransitionTypePK.transitiontypeid = :transitiontypeid")
    , @NamedQuery(name = "TimeZoneTransitionType.findByOffset", query = "SELECT t FROM TimeZoneTransitionType t WHERE t.offset = :offset")
    , @NamedQuery(name = "TimeZoneTransitionType.findByIsDST", query = "SELECT t FROM TimeZoneTransitionType t WHERE t.isDST = :isDST")
    , @NamedQuery(name = "TimeZoneTransitionType.findByAbbreviation", query = "SELECT t FROM TimeZoneTransitionType t WHERE t.abbreviation = :abbreviation")})
public class TimeZoneTransitionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimeZoneTransitionTypePK timeZoneTransitionTypePK;
    @Basic(optional = false)
    @Column(name = "Offset")
    private int offset;
    @Basic(optional = false)
    @Column(name = "Is_DST")
    private short isDST;
    @Basic(optional = false)
    @Column(name = "Abbreviation")
    private String abbreviation;

    public TimeZoneTransitionType() {
    }

    public TimeZoneTransitionType(TimeZoneTransitionTypePK timeZoneTransitionTypePK) {
        this.timeZoneTransitionTypePK = timeZoneTransitionTypePK;
    }

    public TimeZoneTransitionType(TimeZoneTransitionTypePK timeZoneTransitionTypePK, int offset, short isDST, String abbreviation) {
        this.timeZoneTransitionTypePK = timeZoneTransitionTypePK;
        this.offset = offset;
        this.isDST = isDST;
        this.abbreviation = abbreviation;
    }

    public TimeZoneTransitionType(int timezoneid, int transitiontypeid) {
        this.timeZoneTransitionTypePK = new TimeZoneTransitionTypePK(timezoneid, transitiontypeid);
    }

    public TimeZoneTransitionTypePK getTimeZoneTransitionTypePK() {
        return timeZoneTransitionTypePK;
    }

    public void setTimeZoneTransitionTypePK(TimeZoneTransitionTypePK timeZoneTransitionTypePK) {
        this.timeZoneTransitionTypePK = timeZoneTransitionTypePK;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public short getIsDST() {
        return isDST;
    }

    public void setIsDST(short isDST) {
        this.isDST = isDST;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeZoneTransitionTypePK != null ? timeZoneTransitionTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeZoneTransitionType)) {
            return false;
        }
        TimeZoneTransitionType other = (TimeZoneTransitionType) object;
        if ((this.timeZoneTransitionTypePK == null && other.timeZoneTransitionTypePK != null) || (this.timeZoneTransitionTypePK != null && !this.timeZoneTransitionTypePK.equals(other.timeZoneTransitionTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.TimeZoneTransitionType[ timeZoneTransitionTypePK=" + timeZoneTransitionTypePK + " ]";
    }
    
}
