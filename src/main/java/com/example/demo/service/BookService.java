package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author zlxx
 */
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public IPage<Book> findByConditions(int pageNum, int pageSize) {
        Page<Book> page = new Page<>(pageNum, pageSize);
        Date publishStart = new Date();
        Date publishEnd = new Date();

        return bookMapper.selectPage(page, new QueryWrapper<Book>()
                .like("author_name", "B%")
                .like("book_name", "B%")
                .between("publish_time", publishStart, publishEnd));
    }
}
