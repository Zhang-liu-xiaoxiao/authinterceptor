package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    BookMapper bookMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void TestSelect() {
        Page<Book> page = new Page<>(5, 2);
        LocalDate publishStart = LocalDate.of(1900, 1, 1);
        LocalDate publishEnd = LocalDate.now();

        IPage<Book> res = bookMapper.selectPage(page, new QueryWrapper<Book>()
                .like("author_name", "AA%")
                .like("book_name", "B%")
                .between("publish_time", publishStart, publishEnd));

        System.out.println(res);

    }

}
