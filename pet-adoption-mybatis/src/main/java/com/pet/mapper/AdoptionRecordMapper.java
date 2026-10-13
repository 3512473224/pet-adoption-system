package com.pet.mapper;

import com.pet.entity.AdoptionRecord;

import java.util.List;

/**
 * 领养记录 Mapper 接口
 */
public interface AdoptionRecordMapper {

    int insert(AdoptionRecord record);

    int deleteById(int id);

    int update(AdoptionRecord record);

    AdoptionRecord selectById(int id);

    List<AdoptionRecord> selectAll();

    /**
     * 按领养人查他的所有领养记录
     */
    List<AdoptionRecord> selectByAdopterId(int adopterId);

    /**
     * 按宠物查它的所有领养记录
     */
    List<AdoptionRecord> selectByPetId(int petId);
}
