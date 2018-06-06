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
@Table(name = "help_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HelpCategory.findAll", query = "SELECT h FROM HelpCategory h")
    , @NamedQuery(name = "HelpCategory.findByHelpCategoryId", query = "SELECT h FROM HelpCategory h WHERE h.helpCategoryId = :helpCategoryId")
    , @NamedQuery(name = "HelpCategory.findByName", query = "SELECT h FROM HelpCategory h WHERE h.name = :name")
    , @NamedQuery(name = "HelpCategory.findByParentCategoryId", query = "SELECT h FROM HelpCategory h WHERE h.parentCategoryId = :parentCategoryId")})
public class HelpCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "help_category_id")
    private Short helpCategoryId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "parent_category_id")
    private Short parentCategoryId;
    @Basic(optional = false)
    @Lob
    @Column(name = "url")
    private String url;

    public HelpCategory() {
    }

    public HelpCategory(Short helpCategoryId) {
        this.helpCategoryId = helpCategoryId;
    }

    public HelpCategory(Short helpCategoryId, String name, String url) {
        this.helpCategoryId = helpCategoryId;
        this.name = name;
        this.url = url;
    }

    public Short getHelpCategoryId() {
        return helpCategoryId;
    }

    public void setHelpCategoryId(Short helpCategoryId) {
        this.helpCategoryId = helpCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Short parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (helpCategoryId != null ? helpCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HelpCategory)) {
            return false;
        }
        HelpCategory other = (HelpCategory) object;
        if ((this.helpCategoryId == null && other.helpCategoryId != null) || (this.helpCategoryId != null && !this.helpCategoryId.equals(other.helpCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.HelpCategory[ helpCategoryId=" + helpCategoryId + " ]";
    }
    
}
