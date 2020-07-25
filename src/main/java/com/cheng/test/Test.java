package com.cheng.test;
import	java.lang.instrument.ClassFileTransformer;

import com.cheng.dao.StudentDao;
import com.cheng.domain.Student;
import com.cheng.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    @org.junit.Test
    public void deleteStudentTest() {
        SqlSession session = MybatisUtil.getSession();
        String sql = "com.cheng.dao.StudentDao" + "." + "deleteStudent";
        String id = "1001";
        Integer row = session.delete(sql, id);
        System.out.println("====================> 被影响的行数：" + row);
        session.commit();
        session.close();
    }

    @org.junit.Test
    public void addStudentTest() {
        SqlSession session = MybatisUtil.getSession();
        String sql = "com.cheng.dao.StudentDao" + "." + "addStudent";
        Student s = new Student("1001", "张三", 24);
        Integer row = session.insert(sql, s);
        System.out.println("========================> 被影响的行数 ：" + row);
        session.commit();
        session.close();
    }

    @org.junit.Test
    public void selectStudentByAge(){
        SqlSession session = MybatisUtil.getSession();
        String sql = "com.cheng.dao.StudentDao" + "." + "selectStudentByAge";
        List<Student> students = session.selectList(sql, 18);
        for(Student s : students){
            System.out.println("==============>" + s);
        }
        session.close();
    }

    @org.junit.Test
    public void selectStudentByNameAndAge(){
        SqlSession session = MybatisUtil.getSession();
        String sql = "com.cheng.dao.StudentDao" + "." + "selectStudentByNameAndAge";
        Student s = new Student();
        s.setName("张三");
        s.setAge(24);
        Student student = session.selectOne(sql, s);
        System.out.println("============>" +student.getId());
    }

    @org.junit.Test
    public void selectStudentByNameAndAgeUseDao(){
        StudentDao dao = MybatisUtil.getSession().getMapper(StudentDao.class);
        Student s = new Student();
        s.setName("张三");
        s.setAge(24);
        Student student = dao.selectStudentByNameAndAgeUseDao(s);
        System.out.println("==========================>" + student.getId());
    }

    @org.junit.Test
    public void selectStudentByNameAndAgeUseDaoAndParam(){
        StudentDao dao = MybatisUtil.getSession().getMapper(StudentDao.class);
        Student s = new Student();
        s.setName("张三");
        s.setAge(24);
        Student student = dao.selectStudentByNameAndAgeUseDaoAndparam(s.getName(), s.getAge());
        System.out.println("==========================>" + student.getId());
    }
}
