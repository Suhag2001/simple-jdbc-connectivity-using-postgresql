package com.springboot.DatabaseConnectivity.controller;


import com.springboot.DatabaseConnectivity.model.Student;
import com.springboot.DatabaseConnectivity.service.StdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class StdController {

    @Autowired
    private StdService service;

    @RequestMapping("/selectSingle")
    @ResponseBody
    public Student selectSingle(@RequestParam int id) {
        return service.selectSingle(id);
    }


    @RequestMapping("/selectStudent")
    @ResponseBody
    List<Student> selectStudent() {
        return service.selectStudent();
    }

    @RequestMapping("/insertStudent")
    @ResponseBody
    public void insertStudent(@RequestBody Student s1) {
        service.insertStudent(s1);
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    Student updateStudent(@RequestBody Student s1) {
        return service.updateStudent(s1);
    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    Boolean deleteStudent(@RequestParam int id) {
        return service.deleteStudent(id);
    }

}
