# 宠物领养管理系统（基于 MyBatis）

《JavaEE 框架开发技术》课程作业：基于 MyBatis 框架实现数据库操作项目。

## 选题

**宠物领养管理系统**——管理救助站的宠物品类、宠物信息、领养人信息、
领养记录及宠物健康档案，支持多表关联查询。

## 数据库设计（5 张表）

| 表名 | 说明 | 主键 | 外键 |
|---|---|---|---|
| pet_category | 宠物品类 | id | — |
| pet | 宠物 | id | category_id → pet_category.id |
| adopter | 领养人 | id | — |
| adoption_record | 领养记录 | id | pet_id → pet.id，adopter_id → adopter.id |
| pet_health | 宠物健康档案 | pet_id | pet_id → pet.id |

关联关系：
- **一对多**：pet_category → pet（一个品类下有多只宠物）
- **多对多**：adopter ↔ pet（通过 adoption_record 中间表）
- **一对一**：pet → pet_health（pet_id 既是主键又是外键）

## 环境要求

- JDK 8 及以上
- MySQL 5.7 / 8.0
- IntelliJ IDEA（任意近年版本）

## 运行步骤

1. **建库建表**：在 MySQL 客户端（或 Navicat / IDEA Database 工具）中执行
   `sql/pet_adoption.sql`，会自动建库、建表并插入测试数据。
2. **改数据库密码**：打开 `src/main/resources/db.properties`，
   把 `jdbc.username` / `jdbc.password` 改成你本机的 MySQL 账号密码。
3. **导入 IDEA**：IDEA → Open → 选择项目根目录下的 `pom.xml` →
   以 Maven 项目打开，等待右下角依赖下载完成。
4. **运行**：打开 `src/main/java/com/pet/Main.java`，右键 → Run 'Main.main()'。
5. **看效果**：控制台依次输出 5 张表的增删改查、条件查询、
   一对多 / 多对多 / 一对一关联查询结果，最后自动清理演示数据并提交事务。

## 代码结构

```
src/main/java/com/pet/
├── entity/          5 个实体类（JavaBean 规范，属性与表字段一一对应）
├── mapper/          5 个 Mapper 接口（增删改查 + 关联查询方法）
├── util/
│   └── MyBatisUtil.java   全局 SqlSessionFactory 工具类
└── Main.java        功能演示入口
src/main/resources/
├── mybatis-config.xml     核心配置：数据源、类型别名、Mapper 注册
├── db.properties          数据库连接信息
└── mapper/          5 个 XML 映射文件（SQL、parameterType、resultMap）
sql/
└── pet_adoption.sql 建库建表 + 测试数据
```

## 提交到学习通前的截图清单

1. IDEA 项目结构截图（entity / mapper / resources 目录）
2. `mybatis-config.xml` 代码截图
3. 任意一个 Mapper XML（如 PetMapper.xml）代码截图
4. 运行 Main 后的控制台输出截图（重点截：6/7/8 三段关联查询结果）
5. Navicat / IDEA 中 5 张表结构的截图

## Gitee 提交（选做加分）

1. 在 [Gitee](https://gitee.com) 新建公开仓库；
2. IDEA → VCS → Share Project on Gitee（或命令行 `git init/add/commit/push`）；
3. 把仓库地址填到腾讯文档在线表。
