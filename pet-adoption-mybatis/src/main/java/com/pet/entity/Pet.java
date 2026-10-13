package com.pet.entity;

import java.util.Date;

/**
 * 宠物实体类，对应 pet 表
 * 一对一关联：一只宠物对应一份健康档案
 */
public class Pet {
    private Integer id;
    private String name;
    private Integer categoryId;
    private String breed;
    private Integer age;
    private String gender;
    private String status;
    private Date intakeDate;
    /** 健康档案（一对一） */
    private PetHealth health;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getIntakeDate() { return intakeDate; }
    public void setIntakeDate(Date intakeDate) { this.intakeDate = intakeDate; }

    public PetHealth getHealth() { return health; }
    public void setHealth(PetHealth health) { this.health = health; }

    @Override
    public String toString() {
        return "Pet{id=" + id + ", name='" + name + "', categoryId=" + categoryId
                + ", breed='" + breed + "', age=" + age + ", gender='" + gender
                + "', status='" + status + "', intakeDate=" + intakeDate + "}";
    }
}
