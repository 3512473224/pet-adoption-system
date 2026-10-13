-- =============================================
-- 宠物领养管理系统 · 建库建表脚本
-- 数据库：pet_adoption，字符集 utf8mb4
-- 在 MySQL 客户端 / Navicat / IDEA Database 工具中直接执行
-- =============================================

CREATE DATABASE IF NOT EXISTS pet_adoption
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE pet_adoption;

-- 1. 宠物品类表
CREATE TABLE pet_category (
  id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '品类编号',
  name        VARCHAR(50) NOT NULL COMMENT '品类名称',
  description VARCHAR(255) COMMENT '品类描述'
) COMMENT '宠物品类表';

-- 2. 宠物表
CREATE TABLE pet (
  id          INT PRIMARY KEY AUTO_INCREMENT COMMENT '宠物编号',
  name        VARCHAR(50) NOT NULL COMMENT '宠物名字',
  category_id INT NOT NULL COMMENT '所属品类编号',
  breed       VARCHAR(50) COMMENT '品种',
  age         INT COMMENT '年龄(岁)',
  gender      CHAR(2) COMMENT '性别：公/母',
  status      VARCHAR(20) DEFAULT '待领养' COMMENT '状态：待领养/已领养',
  intake_date DATE COMMENT '入园日期',
  CONSTRAINT fk_pet_category FOREIGN KEY (category_id) REFERENCES pet_category (id)
) COMMENT '宠物表';

-- 3. 领养人表
CREATE TABLE adopter (
  id      INT PRIMARY KEY AUTO_INCREMENT COMMENT '领养人编号',
  name    VARCHAR(50) NOT NULL COMMENT '姓名',
  gender  CHAR(2) COMMENT '性别',
  phone   VARCHAR(20) COMMENT '联系电话',
  address VARCHAR(255) COMMENT '家庭住址',
  id_card VARCHAR(20) COMMENT '身份证号'
) COMMENT '领养人表';

-- 4. 领养记录表（领养人与宠物之间的中间表，构成多对多关系）
CREATE TABLE adoption_record (
  id         INT PRIMARY KEY AUTO_INCREMENT COMMENT '记录编号',
  pet_id     INT NOT NULL COMMENT '宠物编号',
  adopter_id INT NOT NULL COMMENT '领养人编号',
  adopt_date DATE COMMENT '领养日期',
  staff_name VARCHAR(50) COMMENT '经办人',
  remark     VARCHAR(255) COMMENT '备注',
  CONSTRAINT fk_record_pet FOREIGN KEY (pet_id) REFERENCES pet (id),
  CONSTRAINT fk_record_adopter FOREIGN KEY (adopter_id) REFERENCES adopter (id)
) COMMENT '领养记录表';

-- 5. 宠物健康档案表（与宠物表一对一：pet_id 既是主键又是外键）
CREATE TABLE pet_health (
  pet_id       INT PRIMARY KEY COMMENT '宠物编号',
  vaccine_done TINYINT(1) DEFAULT 0 COMMENT '是否完成疫苗：1是/0否',
  sterilized   TINYINT(1) DEFAULT 0 COMMENT '是否绝育：1是/0否',
  health_note  VARCHAR(255) COMMENT '健康备注',
  check_date   DATE COMMENT '体检日期',
  CONSTRAINT fk_health_pet FOREIGN KEY (pet_id) REFERENCES pet (id)
) COMMENT '宠物健康档案表';

-- ============ 测试数据 ============

INSERT INTO pet_category (name, description) VALUES
('犬类', '忠诚活泼，适合看家陪伴'),
('猫类', '独立安静，适合公寓饲养'),
('小型宠物', '仓鼠、兔子等，饲养成本低');

INSERT INTO pet (name, category_id, breed, age, gender, status, intake_date) VALUES
('旺财', 1, '中华田园犬', 2, '公', '待领养', '2026-03-10'),
('豆豆', 1, '金毛', 1, '母', '已领养', '2026-02-18'),
('咪咪', 2, '橘猫', 3, '母', '待领养', '2026-04-02'),
('雪球', 2, '布偶猫', 1, '公', '待领养', '2026-05-20'),
('小灰', 3, '垂耳兔', 1, '公', '已领养', '2026-06-11'),
('奶糖', 3, '金丝熊', 1, '母', '待领养', '2026-07-01');

INSERT INTO adopter (name, gender, phone, address, id_card) VALUES
('张伟', '男', '13800001111', '长沙市岳麓区枫林路88号', '430100199001011234'),
('李娜', '女', '13900002222', '长沙市天心区芙蓉南路66号', '430100199205125678'),
('王强', '男', '13700003333', '长沙市开福区湘江北路99号', '430100198811309012');

INSERT INTO adoption_record (pet_id, adopter_id, adopt_date, staff_name, remark) VALUES
(2, 1, '2026-08-15', '陈老师', '首次领养，需定期回访'),
(5, 2, '2026-09-02', '陈老师', '领养人有饲养经验'),
(2, 3, '2026-09-20', '刘老师', '二次领养登记示例');

INSERT INTO pet_health (pet_id, vaccine_done, sterilized, health_note, check_date) VALUES
(1, 1, 0, '体格健壮，驱虫已完成', '2026-09-10'),
(2, 1, 1, '疫苗齐全，已绝育', '2026-08-20'),
(3, 1, 0, '轻微泪痕，注意饮食', '2026-09-12'),
(4, 0, 0, '幼猫，待打第二针疫苗', '2026-09-15');
