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
@Table(name = "suppler_payment_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplerPaymentType.findAll", query = "SELECT s FROM SupplerPaymentType s")
    , @NamedQuery(name = "SupplerPaymentType.findById", query = "SELECT s FROM SupplerPaymentType s WHERE s.id = :id")
    , @NamedQuery(name = "SupplerPaymentType.findByName", query = "SELECT s FROM SupplerPaymentType s WHERE s.name = :name")})
public class SupplerPaymentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplerPaymentTypeId")
    private Collection<SupplierPaymentController> supplierPaymentControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplerPaymentTypeId")
    private Collection<SupplierPaymentModeManager> supplierPaymentModeManagerCollection;

    public SupplerPaymentType() {
    }

    public SupplerPaymentType(Integer id) {
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
    public Collection<SupplierPaymentController> getSupplierPaymentControllerCollection() {
        return supplierPaymentControllerCollection;
    }

    public void setSupplierPaymentControllerCollection(Collection<SupplierPaymentController> supplierPaymentControllerCollection) {
        this.supplierPaymentControllerCollection = supplierPaymentControllerCollection;
    }

    @XmlTransient
    public Collection<SupplierPaymentModeManager> getSupplierPaymentModeManagerCollection() {
        return supplierPaymentModeManagerCollection;
    }

    public void setSupplierPaymentModeManagerCollection(Collection<SupplierPaymentModeManager> supplierPaymentModeManagerCollection) {
        this.supplierPaymentModeManagerCollection = supplierPaymentModeManagerCollection;
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
        if (!(object instanceof SupplerPaymentType)) {
            return false;
        }
        SupplerPaymentType other = (SupplerPaymentType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplerPaymentType[ id=" + id + " ]";
    }
    
}
