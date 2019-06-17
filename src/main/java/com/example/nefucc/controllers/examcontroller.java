package com.example.nefucc.controllers;

import com.example.nefucc.entity.Exam;
import com.example.nefucc.entity.TE;
import com.example.nefucc.repository.ExamJpa;
import com.example.nefucc.repository.TEJpa;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
@Slf4j
@Controller
@RequestMapping("/exam")
public class examcontroller {
    @Autowired
    ExamJpa examJpa;
    @RequestMapping("/add")
    void add(@RequestParam("name")String name,@RequestParam("place")String place,@RequestParam("start-y")String starty,
             @RequestParam("start-m")String startm,@RequestParam("start-d")String startd,@RequestParam("start-h")String starth,
             @RequestParam("start-m")String starts, @RequestParam("end-y")String endy,@RequestParam("end-m")String endm,
             @RequestParam("end-d")String endd,@RequestParam("end-h")String endh,@RequestParam("end-s")String ends){
       LocalDateTime start =LocalDateTime.of(Integer.valueOf(starty), Integer.valueOf(startm), Integer.valueOf(startd), Integer.valueOf(starth), Integer.valueOf(starts));
       LocalDateTime end =LocalDateTime.of(Integer.valueOf(endy), Integer.valueOf(endm), Integer.valueOf(endd), Integer.valueOf(endh), Integer.valueOf(ends));
       examJpa.save(new Exam(name,place,start,end,0));
    }
    @Autowired
    TEJpa teJpa;
    @RequestMapping("/fp")
    void fp(@RequestParam("tname")String tnama,@RequestParam("ename")String ename){
        log.debug("tname");
        teJpa.save(new TE(tnama,ename));
        examJpa.alterbyname(ename);
    }
}
