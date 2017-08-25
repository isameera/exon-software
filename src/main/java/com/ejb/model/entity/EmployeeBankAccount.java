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
@Table(name = "employee_bank_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeBankAccount.findAll", query = "SELECT e FROM EmployeeBankAccount e")
    , @NamedQuery(name = "EmployeeBankAccount.findById", query = "SELECT e FROM EmployeeBankAccount e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeBankAccount.findByIsBasic", query = "SELECT e FROM EmployeeBankAccount e WHERE e.isBasic = :isBasic")})
public class EmployeeBankAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_basic")
    private Boolean isBasic;
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BankAccount bankAccountId;
    @JoinColumn(name = "employee_bank_account_ownership_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeBankAccountOwnership employeeBankAccountOwnershipId;
    @JoinColumn(name = "employee_payment_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeePaymentDetails employeePaymentDetailsId;

    public EmployeeBankAccount() {
    }

    public EmployeeBankAccount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsBasic() {
        return isBasic;
    }

    public void setIsBasic(Boolean isBasic) {
        this.isBasic = isBasic;
    }

    public BankAccount getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BankAccount bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public EmployeeBankAccountOwnership getEmployeeBankAccountOwnershipId() {
        return employeeBankAccountOwnershipId;
    }

    public void setEmployeeBankAccountOwnershipId(EmployeeBankAccountOwnership employeeBankAccountOwnershipId) {
        this.employeeBankAccountOwnershipId = employeeBankAccountOwnershipId;
    }

    public EmployeePaymentDetails getEmployeePaymentDetailsId() {
        return employeePaymentDetailsId;
    }

    public void setEmployeePaymentDetailsId(EmployeePaymentDetails employeePaymentDetailsId) {
        this.employeePaymentDetailsId = employeePaymentDetailsId;
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
        if (!(object instanceof EmployeeBankAccount)) {
            return false;
        }
        EmployeeBankAccount other = (EmployeeBankAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeBankAccount[ id=" + id + " ]";
    }
    
}
