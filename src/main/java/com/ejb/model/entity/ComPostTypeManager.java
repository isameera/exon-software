/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "com_post_type_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComPostTypeManager.findAll", query = "SELECT c FROM ComPostTypeManager c")
    , @NamedQuery(name = "ComPostTypeManager.findById", query = "SELECT c FROM ComPostTypeManager c WHERE c.id = :id")})
public class ComPostTypeManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "com_post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComPost comPostId;
    @JoinColumn(name = "com_post_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComPostType comPostTypeId;

    public ComPostTypeManager() {
    }

    public ComPostTypeManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ComPost getComPostId() {
        return comPostId;
    }

    public void setComPostId(ComPost comPostId) {
        this.comPostId = comPostId;
    }

    public ComPostType getComPostTypeId() {
        return comPostTypeId;
    }

    public void setComPostTypeId(ComPostType comPostTypeId) {
        this.comPostTypeId = comPostTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComPostTypeManager)) {
            return false;
        }
        ComPostTypeManager other = (ComPostTypeManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComPostTypeManager[ id=" + id + " ]";
    }
    
}
