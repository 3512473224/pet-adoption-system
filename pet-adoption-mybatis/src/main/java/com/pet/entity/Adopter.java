package com.pet.entity;

import java.util.List;

/**
 * 领养人实体类，对应 adopter 表
 * 多对多关联：一个领养人可领养多只宠物（一只宠物也可被多人领养登记），
 * 通过 adoption_record 中间表关联
 */
public class Adopter {
    private Integer id;
    private String name;
    private String gender;
    private String phone;
    private String address;
    private String idCard;
    /** 该领养人领养的宠物列表（多对多） */
    private List<Pet> pets;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }

    public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }

    @Override
    public String toString() {
        return "Adopter{id=" + id + ", name='" + name + "', gender='" + gender
                + "', phone='" + phone + "', address='" + address + "'}";
    }
}
