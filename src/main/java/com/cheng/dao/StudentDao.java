package com.cheng.dao;

import com.cheng.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudentAll();

    Integer updateStudent(Student student);

    Integer deleteStudent(String id);

    Integer addStudent(Student s);

    List<Student> selectStudentByAge(Integer age);

    Student selectStudentByNameAndAge(String name, Integer age);

    Student selectStudentByNameAndAgeUseDao(Student student);

    Student selectStudentByNameAndAgeUseDaoAndparam(@Param("name") String name, @Param("age") Integer age);

}
