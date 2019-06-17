package com.example.nefucc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Setter
@Getter
//这个无参构造器
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String discribe;
    private String tname;
    private int wc;
    public Task(String name,String discribe,String tname){
        this.discribe=discribe;
        this.name=name;
        this.tname=tname;
    }
}
