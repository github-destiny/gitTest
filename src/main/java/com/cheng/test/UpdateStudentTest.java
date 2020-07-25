package com.cheng.test;

import com.cheng.domain.Student;
import com.cheng.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UpdateStudentTest {

    @Test
    public void UpdateStudentTest(){
        SqlSession session =  MybatisUtil.getSession();
        String sql = "com.cheng.dao.StudentDao" + "." + "updateStudent";
        Student s = new Student("1001", "张三", 20);
        int row = session.update(sql,s);
        System.out.println("======================被影响的行数：" + row);
        session.commit();
        session.close();
    }
}
