package com.pet.mapper;

import com.pet.entity.PetCategory;

import java.util.List;

/**
 * 宠物品类 Mapper 接口
 */
public interface PetCategoryMapper {

    int insert(PetCategory category);

    int deleteById(int id);

    int update(PetCategory category);

    PetCategory selectById(int id);

    List<PetCategory> selectAll();

    /**
     * 一对多关联查询：查出品类及其下属的所有宠物
     */
    PetCategory selectCategoryWithPets(int id);
}
