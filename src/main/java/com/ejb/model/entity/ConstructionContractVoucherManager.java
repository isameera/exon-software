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
@Table(name = "construction_contract_voucher_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstructionContractVoucherManager.findAll", query = "SELECT c FROM ConstructionContractVoucherManager c")
    , @NamedQuery(name = "ConstructionContractVoucherManager.findById", query = "SELECT c FROM ConstructionContractVoucherManager c WHERE c.id = :id")
    , @NamedQuery(name = "ConstructionContractVoucherManager.findByIsCompleted", query = "SELECT c FROM ConstructionContractVoucherManager c WHERE c.isCompleted = :isCompleted")})
public class ConstructionContractVoucherManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_completed")
    private Boolean isCompleted;
    @JoinColumn(name = "construction_contract_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConstructionContract constructionContractId;
    @JoinColumn(name = "construction_site_clients_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConstructionSiteClients constructionSiteClientsId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;

    public ConstructionContractVoucherManager() {
    }

    public ConstructionContractVoucherManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public ConstructionContract getConstructionContractId() {
        return constructionContractId;
    }

    public void setConstructionContractId(ConstructionContract constructionContractId) {
        this.constructionContractId = constructionContractId;
    }

    public ConstructionSiteClients getConstructionSiteClientsId() {
        return constructionSiteClientsId;
    }

    public void setConstructionSiteClientsId(ConstructionSiteClients constructionSiteClientsId) {
        this.constructionSiteClientsId = constructionSiteClientsId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof ConstructionContractVoucherManager)) {
            return false;
        }
        ConstructionContractVoucherManager other = (ConstructionContractVoucherManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ConstructionContractVoucherManager[ id=" + id + " ]";
    }
    
}
