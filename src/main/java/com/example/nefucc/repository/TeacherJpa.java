package com.example.nefucc.repository;
import com.example.nefucc.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface TeacherJpa extends JpaRepository<Teacher,Integer> {
    @Query("select T from  Teacher T where  T.name=:name")
    Teacher findbyname(@Param("name")String name);
//      以后开发一定一定要注意以下两点0=0=0==0=0=0
//      1）update或delete时必须使用@Modifying对方法进行注解，才能使得ORM知道现在要执行的是写操作
//      2）有时候不加@Param注解参数，可能会报如下异常：
//      org.springframework.dao.InvalidDataAccessApiUsageException: Name must not be null or empty!; nested exception
//      is Java.lang.IllegalArgumentException: Name must not be null or empty!
    @Modifying
    @Query("update Teacher T set T.name=:newname,T.password=:password where T.name=:name" )
//         这个错误也许不会犯，但要了解：0=0=0=0=0=0=0=00=0=0=
//          若是更改，entity中必须设置了主键字段，不然不能对应上
//          数据库中的记录，变成新增（数据库自动生成主键）或报错（数据库不自动生成主键）了
    void alterbyname(@Param("name")String name,@Param("newname")String newname,@Param("password")String password);
        }

