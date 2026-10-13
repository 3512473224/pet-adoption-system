package com.pet.entity;

import java.util.Date;

/**
 * 领养记录实体类，对应 adoption_record 表
 */
public class AdoptionRecord {
    private Integer id;
    private Integer petId;
    private Integer adopterId;
    private Date adoptDate;
    private String staffName;
    private String remark;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getPetId() { return petId; }
    public void setPetId(Integer petId) { this.petId = petId; }

    public Integer getAdopterId() { return adopterId; }
    public void setAdopterId(Integer adopterId) { this.adopterId = adopterId; }

    public Date getAdoptDate() { return adoptDate; }
    public void setAdoptDate(Date adoptDate) { this.adoptDate = adoptDate; }

    public String getStaffName() { return staffName; }
    public void setStaffName(String staffName) { this.staffName = staffName; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    @Override
    public String toString() {
        return "AdoptionRecord{id=" + id + ", petId=" + petId + ", adopterId=" + adopterId
                + ", adoptDate=" + adoptDate + ", staffName='" + staffName
                + "', remark='" + remark + "'}";
    }
}
