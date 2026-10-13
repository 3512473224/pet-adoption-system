package com.pet.entity;

import java.util.List;

/**
 * 宠物品类实体类，对应 pet_category 表
 * 一对多关联：一个品类下有多只宠物
 */
public class PetCategory {
    private Integer id;
    private String name;
    private String description;
    /** 该品类下的宠物列表（一对多） */
    private List<Pet> pets;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }

    @Override
    public String toString() {
        return "PetCategory{id=" + id + ", name='" + name + "', description='" + description + "'}";
    }
}
