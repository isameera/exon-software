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
@Table(name = "support_vehicle_models")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupportVehicleModels.findAll", query = "SELECT s FROM SupportVehicleModels s")
    , @NamedQuery(name = "SupportVehicleModels.findById", query = "SELECT s FROM SupportVehicleModels s WHERE s.id = :id")})
public class SupportVehicleModels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @JoinColumn(name = "vehicle_model_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleModel vehicleModelId;

    public SupportVehicleModels() {
    }

    public SupportVehicleModels(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
    }

    public VehicleModel getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(VehicleModel vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
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
        if (!(object instanceof SupportVehicleModels)) {
            return false;
        }
        SupportVehicleModels other = (SupportVehicleModels) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupportVehicleModels[ id=" + id + " ]";
    }
    
}
