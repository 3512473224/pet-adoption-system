package com.pet.mapper;

import com.pet.entity.PetHealth;

import java.util.List;

/**
 * 宠物健康档案 Mapper 接口
 */
public interface PetHealthMapper {

    int insert(PetHealth health);

    int deleteByPetId(int petId);

    int update(PetHealth health);

    PetHealth selectByPetId(int petId);

    List<PetHealth> selectAll();
}
