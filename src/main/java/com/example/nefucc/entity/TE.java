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
@NoArgsConstructor
public class TE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String tname;
    private String ename;
    public TE(String tname,String ename){
       this.tname=tname;
       this.ename=ename;
    }
}
