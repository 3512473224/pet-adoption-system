package com.pet.mapper;

import com.pet.entity.Pet;

import java.util.List;

/**
 * 宠物 Mapper 接口
 */
public interface PetMapper {

    int insert(Pet pet);

    int deleteById(int id);

    int update(Pet pet);

    Pet selectById(int id);

    List<Pet> selectAll();

    /**
     * 多条件组合查询（名字模糊 / 品类 / 状态）
     */
    List<Pet> selectByCondition(Pet condition);

    /**
     * 一对一关联查询：查出宠物及其健康档案
     */
    Pet selectPetWithHealth(int id);
}
