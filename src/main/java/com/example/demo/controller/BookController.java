package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/paged_books")
    public IPage<Book> getBooks(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                @RequestParam(required = false, defaultValue = "10") int pageSize) {
        IPage<Book> res1 = bookService.findByConditions(pageNum, pageSize);
        List<Book> res2 = bookService.queryByWrapper();

        return res1;
    }


}

