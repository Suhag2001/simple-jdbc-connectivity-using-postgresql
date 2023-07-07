package com.springboot.DatabaseConnectivity.service;

import com.springboot.DatabaseConnectivity.model.Student;
import com.springboot.DatabaseConnectivity.repo.StdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StdServiceImpl implements StdService {

    @Autowired
    private StdRepo repo;

    @Override
    public Student selectSingle(int id) {
        return repo.selectSingle(id);
    }

    @Override
    public List<Student> selectStudent() {
        return repo.selectStudent();
    }

    @Override
    public void insertStudent(Student s1) {
        repo.insertStudent(s1);
    }

    @Override
    public Student updateStudent(Student s1) {
        return repo.updateStudent(s1);
    }

    @Override
    public Boolean deleteStudent(int id) {
        return repo.deleteStudent(id);
    }
}
