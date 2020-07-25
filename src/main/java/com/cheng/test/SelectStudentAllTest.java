package com.cheng.test;

import com.cheng.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SelectStudentAllTest {

    @Test
    public void SelectStudentAllTest() throws IOException {
        String config = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        String sql = "com.cheng.dao.StudentDao" + "." + "selectStudentAll";
        List<Student> students = session.selectList(sql);
        for(Student s : students){
            System.out.println(s);
        }
        session.close();

    }
}
