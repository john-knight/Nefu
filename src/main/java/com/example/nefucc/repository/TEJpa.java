package com.example.nefucc.repository;
import com.example.nefucc.entity.Exam;
import com.example.nefucc.entity.TE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TEJpa extends JpaRepository<TE,Integer>{
    @Query("select T from  TE T where  T.tname=:name")
    TE findbyname(@Param("name")String tname);
    @Query("select T from  TE T where  T.tname=:name")
    List<TE> findbytname(@Param("name")String tname);
}
