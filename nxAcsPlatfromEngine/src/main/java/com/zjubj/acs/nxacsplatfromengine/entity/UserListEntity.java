package com.zjubj.acs.nxacsplatfromengine.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author frank_zhiy
 * @date 2023/4/4
 * @Description
 */
@Entity
@Table(name = "user_list", schema = "nx_acs", catalog = "")
public class UserListEntity {
    private long serialNumber;
    private String caseNumber;
    private String timeOfAdmission;
    private String manageDoctors;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "serialNumber")
    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "caseNumber")
    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @Basic
    @Column(name = "timeOfAdmission")
    public String getTimeOfAdmission() {
        return timeOfAdmission;
    }

    public void setTimeOfAdmission(String timeOfAdmission) {
        this.timeOfAdmission = timeOfAdmission;
    }

    @Basic
    @Column(name = "manageDoctors")
    public String getManageDoctors() {
        return manageDoctors;
    }

    public void setManageDoctors(String manageDoctors) {
        this.manageDoctors = manageDoctors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserListEntity that = (UserListEntity) o;
        return serialNumber == that.serialNumber && Objects.equals(caseNumber, that.caseNumber) && Objects.equals(timeOfAdmission, that.timeOfAdmission) && Objects.equals(manageDoctors, that.manageDoctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, caseNumber, timeOfAdmission, manageDoctors);
    }
}
