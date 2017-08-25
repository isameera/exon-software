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
@Table(name = "gje_voucher_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GjeVoucherItem.findAll", query = "SELECT g FROM GjeVoucherItem g")
    , @NamedQuery(name = "GjeVoucherItem.findById", query = "SELECT g FROM GjeVoucherItem g WHERE g.id = :id")})
public class GjeVoucherItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "general_journal_entry_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralJournalEntry generalJournalEntryId;
    @JoinColumn(name = "voucher_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItem voucherItemId;

    public GjeVoucherItem() {
    }

    public GjeVoucherItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GeneralJournalEntry getGeneralJournalEntryId() {
        return generalJournalEntryId;
    }

    public void setGeneralJournalEntryId(GeneralJournalEntry generalJournalEntryId) {
        this.generalJournalEntryId = generalJournalEntryId;
    }

    public VoucherItem getVoucherItemId() {
        return voucherItemId;
    }

    public void setVoucherItemId(VoucherItem voucherItemId) {
        this.voucherItemId = voucherItemId;
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
        if (!(object instanceof GjeVoucherItem)) {
            return false;
        }
        GjeVoucherItem other = (GjeVoucherItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GjeVoucherItem[ id=" + id + " ]";
    }
    
}
