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
@Table(name = "org_bank_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgBankAccount.findAll", query = "SELECT o FROM OrgBankAccount o")
    , @NamedQuery(name = "OrgBankAccount.findById", query = "SELECT o FROM OrgBankAccount o WHERE o.id = :id")})
public class OrgBankAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bank bankId;
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BankAccount bankAccountId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public OrgBankAccount() {
    }

    public OrgBankAccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public BankAccount getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BankAccount bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof OrgBankAccount)) {
            return false;
        }
        OrgBankAccount other = (OrgBankAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgBankAccount[ id=" + id + " ]";
    }
    
}
