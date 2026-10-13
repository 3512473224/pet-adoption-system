package com.pet.mapper;

import com.pet.entity.Adopter;

import java.util.List;

/**
 * 领养人 Mapper 接口
 */
public interface AdopterMapper {

    int insert(Adopter adopter);

    int deleteById(int id);

    int update(Adopter adopter);

    Adopter selectById(int id);

    List<Adopter> selectAll();

    /**
     * 多对多关联查询：查出领养人及其领养的所有宠物
     * （通过 adoption_record 中间表关联）
     */
    Adopter selectAdopterWithPets(int id);
}
