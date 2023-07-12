package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Books)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-11 14:19:37
 */
@Mapper

public interface BookMapper extends BaseMapper<Book> {
    List<Book> selectListByWrapper(@Param(Constants.WRAPPER) Wrapper<Book> queryWrapper);
}

