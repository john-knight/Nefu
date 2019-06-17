//package com.example.nefucc.service;
//
//import com.example.nefucc.entity.Manager;
//import com.example.nefucc.entity.Teacher;
//import com.example.nefucc.repository.ManagerJpa;
//import com.example.nefucc.repository.TeacherJpa;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional
//public class managerservice {
//    @Autowired
//    ManagerJpa managerJpa;
//    @Autowired
//    TeacherJpa teacherJpa;
//    void  add(String name){
//        Teacher teacher=teacherJpa.findbyname(name);
//        managerJpa.save(new Manager(teacher.getName(),teacher.getPassword()));
//    }
//
//}
