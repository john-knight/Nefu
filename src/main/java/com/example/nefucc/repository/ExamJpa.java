package com.example.nefucc.repository;
import com.example.nefucc.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface ExamJpa extends JpaRepository<Exam,Integer> {
    @Query("select T from  Exam T where  T.name=:name")
    Exam findbyname(@Param("name") String name);

    @Modifying
    @Query("update Exam T set  T.fp=1 where T.name=:name")
    void alterbyname(@Param("name") String name);
//    @Query("select  t from  Exam  t where t.start"  )
//    List<Exam> findBytime(@Param("time")LocalDateTime localDateTime);
}
