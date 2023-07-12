package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zlxx
 */
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public IPage<Book> findByConditions(int pageNum, int pageSize) {
        Page<Book> page = new Page<>(pageNum, pageSize);

        return bookMapper.selectPage(page, new QueryWrapper<Book>()
                .like("author_name", "B%")
                .like("book_name", "B%")
                .between("publish_time", "1990-07-11", "2022-07-12"));
    }

    public List<Book> queryByWrapper() {
        QueryWrapper<Book> queries = new QueryWrapper<Book>()
                .like("author_name", "B%")
                .like("book_name", "B%")
                .like("latest_borrowed_user", "%2%")
                .between("publish_time", "1990-07-11", "2022-07-12");
        List<Book> res = bookMapper.selectListByWrapper(queries);
        return res;
    }
}
