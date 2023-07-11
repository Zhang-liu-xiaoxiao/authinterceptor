package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.model.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * (Books)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-11 14:19:37
 */
@Mapper

public interface BookMapper extends BaseMapper<Book> {

}

