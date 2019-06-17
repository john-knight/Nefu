package com.example.nefucc.controllers;

import com.example.nefucc.entity.Manager;
import com.example.nefucc.entity.Teacher;
import com.example.nefucc.repository.ManagerJpa;
import com.example.nefucc.repository.TeacherJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Slf4j
@Controller
@RequestMapping("/manager")
public class managercontroller {
    @Autowired
    ManagerJpa managerJpa;
    @RequestMapping("/alter")
    void alter(@RequestParam("yxm")String name, @RequestParam("xm")String newname, @RequestParam("mm")String password){
        managerJpa.alterbyname(name, newname, password);
    }
    @Autowired
    TeacherJpa teacherJpa;
//    处理添加教师为管理员的操作
    @PostMapping("/add")
    void add(@RequestParam("xm")String name){
        Teacher teacher=teacherJpa.findbyname(name);
        managerJpa.save(new Manager(teacher.getName(),teacher.getPassword()));
        log.debug("即将添加"+name);
    }
}
