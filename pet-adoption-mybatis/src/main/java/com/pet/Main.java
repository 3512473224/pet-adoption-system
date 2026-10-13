package com.pet;

import com.pet.entity.Adopter;
import com.pet.entity.AdoptionRecord;
import com.pet.entity.Pet;
import com.pet.entity.PetCategory;
import com.pet.entity.PetHealth;
import com.pet.mapper.AdopterMapper;
import com.pet.mapper.AdoptionRecordMapper;
import com.pet.mapper.PetCategoryMapper;
import com.pet.mapper.PetHealthMapper;
import com.pet.mapper.PetMapper;
import com.pet.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * 程序功能演示入口：覆盖 5 张表的增删改查，以及
 * 一对一 / 一对多 / 多对多 三种关联查询
 */
public class Main {

    public static void main(String[] args) {
        try (SqlSession session = MyBatisUtil.getSession()) {
            PetCategoryMapper categoryMapper = session.getMapper(PetCategoryMapper.class);
            PetMapper petMapper = session.getMapper(PetMapper.class);
            AdopterMapper adopterMapper = session.getMapper(AdopterMapper.class);
            AdoptionRecordMapper recordMapper = session.getMapper(AdoptionRecordMapper.class);
            PetHealthMapper healthMapper = session.getMapper(PetHealthMapper.class);

            // ============ 1. 品类表 CRUD ============
            System.out.println("===== 1. 品类 CRUD =====");
            List<PetCategory> categories = categoryMapper.selectAll();
            categories.forEach(System.out::println);

            PetCategory newCategory = new PetCategory();
            newCategory.setName("鸟类");
            newCategory.setDescription("鹦鹉、文鸟等，叫声好听");
            categoryMapper.insert(newCategory);
            System.out.println("新增品类，回填 id = " + newCategory.getId());

            newCategory.setDescription("鹦鹉、文鸟等，互动性强");
            categoryMapper.update(newCategory);
            System.out.println("修改后：" + categoryMapper.selectById(newCategory.getId()));

            // ============ 2. 宠物表 CRUD + 条件查询 ============
            System.out.println("===== 2. 宠物 CRUD =====");
            petMapper.selectAll().forEach(System.out::println);

            Pet newPet = new Pet();
            newPet.setName("小鹦");
            newPet.setCategoryId(newCategory.getId());
            newPet.setBreed("虎皮鹦鹉");
            newPet.setAge(1);
            newPet.setGender("公");
            newPet.setStatus("待领养");
            newPet.setIntakeDate(new Date());
            petMapper.insert(newPet);
            System.out.println("新增宠物，回填 id = " + newPet.getId());

            // 条件查询：所有待领养的宠物
            Pet condition = new Pet();
            condition.setStatus("待领养");
            System.out.println("----- 待领养宠物 -----");
            petMapper.selectByCondition(condition).forEach(System.out::println);

            // ============ 3. 领养人表 CRUD ============
            System.out.println("===== 3. 领养人 CRUD =====");
            adopterMapper.selectAll().forEach(System.out::println);

            Adopter newAdopter = new Adopter();
            newAdopter.setName("赵六");
            newAdopter.setGender("男");
            newAdopter.setPhone("13600004444");
            newAdopter.setAddress("长沙市雨花区韶山路100号");
            newAdopter.setIdCard("430100199310114455");
            adopterMapper.insert(newAdopter);
            System.out.println("新增领养人，回填 id = " + newAdopter.getId());

            // ============ 4. 领养记录表 CRUD ============
            System.out.println("===== 4. 领养记录 CRUD =====");
            AdoptionRecord record = new AdoptionRecord();
            record.setPetId(newPet.getId());
            record.setAdopterId(newAdopter.getId());
            record.setAdoptDate(new Date());
            record.setStaffName("陈老师");
            record.setRemark("演示数据");
            recordMapper.insert(record);
            System.out.println("新增领养记录，回填 id = " + record.getId());
            System.out.println("该领养人的记录：");
            recordMapper.selectByAdopterId(newAdopter.getId()).forEach(System.out::println);

            // ============ 5. 健康档案表 CRUD ============
            System.out.println("===== 5. 健康档案 CRUD =====");
            PetHealth health = new PetHealth();
            health.setPetId(newPet.getId());
            health.setVaccineDone(0);
            health.setSterilized(0);
            health.setHealthNote("幼鸟，观察中");
            health.setCheckDate(new Date());
            healthMapper.insert(health);
            System.out.println("新增健康档案：" + healthMapper.selectByPetId(newPet.getId()));

            // ============ 6. 一对多：品类 -> 宠物 ============
            System.out.println("===== 6. 一对多：猫类及其所有宠物 =====");
            PetCategory cat = categoryMapper.selectCategoryWithPets(2);
            System.out.println(cat);
            cat.getPets().forEach(p -> System.out.println("  └ " + p));

            // ============ 7. 多对多：领养人 <-> 宠物 ============
            System.out.println("===== 7. 多对多：张伟领养的所有宠物 =====");
            Adopter zhangwei = adopterMapper.selectAdopterWithPets(1);
            System.out.println(zhangwei);
            zhangwei.getPets().forEach(p -> System.out.println("  └ " + p));

            // ============ 8. 一对一：宠物 -> 健康档案 ============
            System.out.println("===== 8. 一对一：豆豆及其健康档案 =====");
            Pet doudou = petMapper.selectPetWithHealth(2);
            System.out.println(doudou);
            System.out.println("  └ " + doudou.getHealth());

            // ============ 9. 清理演示数据（按外键顺序删除） ============
            System.out.println("===== 9. 删除演示数据 =====");
            recordMapper.deleteById(record.getId());
            healthMapper.deleteByPetId(newPet.getId());
            petMapper.deleteById(newPet.getId());
            adopterMapper.deleteById(newAdopter.getId());
            categoryMapper.deleteById(newCategory.getId());
            System.out.println("演示数据已清理");

            session.commit();
            System.out.println("===== 演示结束，事务已提交 =====");
        }
    }
}
