package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM User")
    List<User> findAll();

    @Select("SELECT * FROM User WHERE id = #{id}")
    User findById(Integer id);

    @Insert("INSERT INTO User(name,email,auth) VALUES(#{name}, #{email},#{auth})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Update("UPDATE User SET name = #{name}, email = #{email} ,auth = #{auth} WHERE id = #{id}")
    int update(User user);

    @Delete("DELETE FROM User WHERE id = #{id}")
    int delete(Integer id);
}
