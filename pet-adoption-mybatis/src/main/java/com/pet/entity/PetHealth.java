package com.pet.entity;

import java.util.Date;

/**
 * 宠物健康档案实体类，对应 pet_health 表
 * 与宠物表一对一：pet_id 既是主键又是外键
 */
public class PetHealth {
    private Integer petId;
    private Integer vaccineDone;
    private Integer sterilized;
    private String healthNote;
    private Date checkDate;

    public Integer getPetId() { return petId; }
    public void setPetId(Integer petId) { this.petId = petId; }

    public Integer getVaccineDone() { return vaccineDone; }
    public void setVaccineDone(Integer vaccineDone) { this.vaccineDone = vaccineDone; }

    public Integer getSterilized() { return sterilized; }
    public void setSterilized(Integer sterilized) { this.sterilized = sterilized; }

    public String getHealthNote() { return healthNote; }
    public void setHealthNote(String healthNote) { this.healthNote = healthNote; }

    public Date getCheckDate() { return checkDate; }
    public void setCheckDate(Date checkDate) { this.checkDate = checkDate; }

    @Override
    public String toString() {
        return "PetHealth{petId=" + petId + ", vaccineDone=" + vaccineDone
                + ", sterilized=" + sterilized + ", healthNote='" + healthNote
                + "', checkDate=" + checkDate + "}";
    }
}
