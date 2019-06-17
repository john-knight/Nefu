package com.example.nefucc.controllers;

import com.example.nefucc.entity.Teacher;
import com.example.nefucc.repository.TeacherJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/teacher")
public class teachercontroller {
    @Autowired
    private  TeacherJpa teacherJpa;
    @RequestMapping("/alter")
    public void alter(@RequestParam("yxm")String name,@RequestParam("xm")String newname,@RequestParam("mm")String password){
    teacherJpa.alterbyname(name, newname, password);
    }
}
