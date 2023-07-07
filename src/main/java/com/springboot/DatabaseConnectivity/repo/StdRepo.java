package com.springboot.DatabaseConnectivity.repo;

import com.springboot.DatabaseConnectivity.model.Student;

import java.util.List;

public interface StdRepo {

    Student selectSingle(int id);

    public List<Student> selectStudent();

    void insertStudent(Student s1);

    Student updateStudent(Student s1);

    Boolean deleteStudent(int id);
}
