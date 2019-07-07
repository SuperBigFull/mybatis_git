package com.java.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoimpl {
    private SqlSession sqlSession=null;

    @Before
    public void init() throws IOException{
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream ins = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = ssfb.build(ins);
        sqlSession = sqlSessionFactory.openSession();


    }

    @Test
    public void getUserById() throws IOException {

        List<Map<String,Object>> bookList=sqlSession.selectList("com.java.dao.impl.UserDaoimpl.getUserById");
        bookList.forEach(temp-> System.out.println(temp));

    }

    @Test
    public  void insertOne() {
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("bookName","mybatis-放弃");
        paramMap.put("price",50F);
        paramMap.put("num",10);
        int flag=sqlSession.insert("com.java.dao.impl.UserDaoimpl.insertOne",paramMap);
        System.out.println("flag="+flag);
    }

    @Test
    public void deleteOne(){
        int flag=sqlSession.delete("com.java.dao.impl.UserDaoimpl.deleteOne",7L);
        System.out.println("flag="+flag);
    }

    @Test
    public void update(){
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("bookName","mybatis-1");
        paramMap.put("price",60F);
        paramMap.put("num",20);
        paramMap.put("id",7);
        int flag=sqlSession.update("com.java.dao.impl.UserDaoimpl.update",paramMap);
        System.out.println("flag="+flag);


    }
    @After
    public void destroy() {
        sqlSession.commit();
    }
}
