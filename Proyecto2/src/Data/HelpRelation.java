/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.Serializable;
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
@Table(name = "help_relation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HelpRelation.findAll", query = "SELECT h FROM HelpRelation h")
    , @NamedQuery(name = "HelpRelation.findByHelpTopicId", query = "SELECT h FROM HelpRelation h WHERE h.helpRelationPK.helpTopicId = :helpTopicId")
    , @NamedQuery(name = "HelpRelation.findByHelpKeywordId", query = "SELECT h FROM HelpRelation h WHERE h.helpRelationPK.helpKeywordId = :helpKeywordId")})
public class HelpRelation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HelpRelationPK helpRelationPK;

    public HelpRelation() {
    }

    public HelpRelation(HelpRelationPK helpRelationPK) {
        this.helpRelationPK = helpRelationPK;
    }

    public HelpRelation(int helpTopicId, int helpKeywordId) {
        this.helpRelationPK = new HelpRelationPK(helpTopicId, helpKeywordId);
    }

    public HelpRelationPK getHelpRelationPK() {
        return helpRelationPK;
    }

    public void setHelpRelationPK(HelpRelationPK helpRelationPK) {
        this.helpRelationPK = helpRelationPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (helpRelationPK != null ? helpRelationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HelpRelation)) {
            return false;
        }
        HelpRelation other = (HelpRelation) object;
        if ((this.helpRelationPK == null && other.helpRelationPK != null) || (this.helpRelationPK != null && !this.helpRelationPK.equals(other.helpRelationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.HelpRelation[ helpRelationPK=" + helpRelationPK + " ]";
    }
    
}
