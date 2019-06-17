package com.example.nefucc.repository;

import com.example.nefucc.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ManagerJpa extends JpaRepository<Manager,Integer> {
    @Query("select T from  Manager T where  T.name=:name")
    Manager findbyname(@Param("name")String name);
    @Modifying
    @Query("update Manager T set T.name=:newname,T.password=:password where T.name=:name" )
//         这个错误也许不会犯，但要了解：0=0=0=0=0=0=0=00=0=0=
//          若是更改，entity中必须设置了主键字段，不然不能对应上
//          数据库中的记录，变成新增（数据库自动生成主键）或报错（数据库不自动生成主键）了
    void alterbyname(@Param("name")String name,@Param("newname")String newname,@Param("password")String password);
}
