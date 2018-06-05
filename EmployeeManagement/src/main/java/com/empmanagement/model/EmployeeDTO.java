/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the prior
 * written consent of HSBC Holdings plc.
 */
package com.empmanagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeDTO {

    @Id
    @GeneratedValue
    public int EmpId;
    public String EmpName;
    public int EmpAge;
    public double EmpSalary;
    public String EmpDepartment;
    public String EmpRole;

    public EmployeeDTO() {

    }

    public EmployeeDTO(final int empId, final String empName, final int empAge, final double empSalary, final String empDepartment,
        final String empRole) {
        super();
        this.EmpId = empId;
        this.EmpName = empName;
        this.EmpAge = empAge;
        this.EmpSalary = empSalary;
        this.EmpDepartment = empDepartment;
        this.EmpRole = empRole;
    }

    /**
     * @return the empId
     */
    public int getEmpId() {
        return this.EmpId;
    }

    /**
     * @param empId
     *            the empId to set
     */
    public void setEmpId(final int empId) {
        this.EmpId = empId;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return this.EmpName;
    }

    /**
     * @param empName
     *            the empName to set
     */
    public void setEmpName(final String empName) {
        this.EmpName = empName;
    }

    /**
     * @return the empAge
     */
    public int getEmpAge() {
        return this.EmpAge;
    }

    /**
     * @param empAge
     *            the empAge to set
     */
    public void setEmpAge(final int empAge) {
        this.EmpAge = empAge;
    }

    /**
     * @return the empSalary
     */
    public double getEmpSalary() {
        return this.EmpSalary;
    }

    /**
     * @param empSalary
     *            the empSalary to set
     */
    public void setEmpSalary(final double empSalary) {
        this.EmpSalary = empSalary;
    }

    /**
     * @return the empDepartment
     */
    public String getEmpDepartment() {
        return this.EmpDepartment;
    }

    /**
     * @param empDepartment
     *            the empDepartment to set
     */
    public void setEmpDepartment(final String empDepartment) {
        this.EmpDepartment = empDepartment;
    }

    /**
     * @return the empRole
     */
    public String getEmpRole() {
        return this.EmpRole;
    }

    /**
     * @param empRole
     *            the empRole to set
     */
    public void setEmpRole(final String empRole) {
        this.EmpRole = empRole;
    }


}
