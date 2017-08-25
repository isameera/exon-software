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
@Table(name = "finger_print_employee_attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FingerPrintEmployeeAttendance.findAll", query = "SELECT f FROM FingerPrintEmployeeAttendance f")
    , @NamedQuery(name = "FingerPrintEmployeeAttendance.findById", query = "SELECT f FROM FingerPrintEmployeeAttendance f WHERE f.id = :id")})
public class FingerPrintEmployeeAttendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "finger_print_attendance_data_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FingerPrintAttendanceData fingerPrintAttendanceDataId;

    public FingerPrintEmployeeAttendance() {
    }

    public FingerPrintEmployeeAttendance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public FingerPrintAttendanceData getFingerPrintAttendanceDataId() {
        return fingerPrintAttendanceDataId;
    }

    public void setFingerPrintAttendanceDataId(FingerPrintAttendanceData fingerPrintAttendanceDataId) {
        this.fingerPrintAttendanceDataId = fingerPrintAttendanceDataId;
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
        if (!(object instanceof FingerPrintEmployeeAttendance)) {
            return false;
        }
        FingerPrintEmployeeAttendance other = (FingerPrintEmployeeAttendance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FingerPrintEmployeeAttendance[ id=" + id + " ]";
    }
    
}
