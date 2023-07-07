package com.example.demo.mapper;

import com.example.demo.model.Info;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoMapper {
    @Select("SELECT * FROM Info")
    List<Info> findAll();

    @Select("SELECT * FROM Info WHERE id = #{id}")
    Info findById(Integer id);

    @Insert("INSERT INTO Info(title, detail, userId) VALUES(#{title}, #{detail}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Info info);

    @Update("UPDATE Info SET title = #{title}, detail = #{detail} WHERE id = #{id}")
    int update(Info info);

    @Delete("DELETE FROM Info WHERE id = #{id}")
    int delete(Integer id);
}
