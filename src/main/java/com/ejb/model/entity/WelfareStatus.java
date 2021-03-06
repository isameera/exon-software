/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "welfare_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelfareStatus.findAll", query = "SELECT w FROM WelfareStatus w")
    , @NamedQuery(name = "WelfareStatus.findById", query = "SELECT w FROM WelfareStatus w WHERE w.id = :id")
    , @NamedQuery(name = "WelfareStatus.findByName", query = "SELECT w FROM WelfareStatus w WHERE w.name = :name")})
public class WelfareStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "welfareStatusId")
    private Collection<WelfareManager> welfareManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "welfareStatusId")
    private Collection<WelfareActiveInactiveHistory> welfareActiveInactiveHistoryCollection;

    public WelfareStatus() {
    }

    public WelfareStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<WelfareManager> getWelfareManagerCollection() {
        return welfareManagerCollection;
    }

    public void setWelfareManagerCollection(Collection<WelfareManager> welfareManagerCollection) {
        this.welfareManagerCollection = welfareManagerCollection;
    }

    @XmlTransient
    public Collection<WelfareActiveInactiveHistory> getWelfareActiveInactiveHistoryCollection() {
        return welfareActiveInactiveHistoryCollection;
    }

    public void setWelfareActiveInactiveHistoryCollection(Collection<WelfareActiveInactiveHistory> welfareActiveInactiveHistoryCollection) {
        this.welfareActiveInactiveHistoryCollection = welfareActiveInactiveHistoryCollection;
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
        if (!(object instanceof WelfareStatus)) {
            return false;
        }
        WelfareStatus other = (WelfareStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.WelfareStatus[ id=" + id + " ]";
    }
    
}
