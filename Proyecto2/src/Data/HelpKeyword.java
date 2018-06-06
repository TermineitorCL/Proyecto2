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
@Table(name = "help_keyword")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HelpKeyword.findAll", query = "SELECT h FROM HelpKeyword h")
    , @NamedQuery(name = "HelpKeyword.findByHelpKeywordId", query = "SELECT h FROM HelpKeyword h WHERE h.helpKeywordId = :helpKeywordId")
    , @NamedQuery(name = "HelpKeyword.findByName", query = "SELECT h FROM HelpKeyword h WHERE h.name = :name")})
public class HelpKeyword implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "help_keyword_id")
    private Integer helpKeywordId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public HelpKeyword() {
    }

    public HelpKeyword(Integer helpKeywordId) {
        this.helpKeywordId = helpKeywordId;
    }

    public HelpKeyword(Integer helpKeywordId, String name) {
        this.helpKeywordId = helpKeywordId;
        this.name = name;
    }

    public Integer getHelpKeywordId() {
        return helpKeywordId;
    }

    public void setHelpKeywordId(Integer helpKeywordId) {
        this.helpKeywordId = helpKeywordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (helpKeywordId != null ? helpKeywordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HelpKeyword)) {
            return false;
        }
        HelpKeyword other = (HelpKeyword) object;
        if ((this.helpKeywordId == null && other.helpKeywordId != null) || (this.helpKeywordId != null && !this.helpKeywordId.equals(other.helpKeywordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.HelpKeyword[ helpKeywordId=" + helpKeywordId + " ]";
    }
    
}
