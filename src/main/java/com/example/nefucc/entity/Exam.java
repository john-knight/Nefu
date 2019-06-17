package com.example.nefucc.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter

@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private  String place;
    private  LocalDateTime start;
    private LocalDateTime end;
//    记录是否分配
    private  int fp;
    public Exam(String name,String place,LocalDateTime start,LocalDateTime end,int fp){
       this.name=name;
       this.place=place;
       this.start=start;
       this.end=end;
       this.fp=fp;
    }
}
