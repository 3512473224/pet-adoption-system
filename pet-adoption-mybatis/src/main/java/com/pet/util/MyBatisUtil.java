package com.pet.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * MyBatis 工具类：全局唯一的 SqlSessionFactory，封装获取 SqlSession 的方法
 */
public class MyBatisUtil {

    private static final SqlSessionFactory FACTORY;

    static {
        try {
            // 读取 mybatis-config.xml 核心配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            FACTORY = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("初始化 MyBatis 失败，请检查 mybatis-config.xml", e);
        }
    }

    /**
     * 获取 SqlSession（默认手动提交，需要调用 session.commit()）
     */
    public static SqlSession getSession() {
        return FACTORY.openSession();
    }

    /**
     * 获取自动提交的 SqlSession
     */
    public static SqlSession getAutoCommitSession() {
        return FACTORY.openSession(true);
    }
}
