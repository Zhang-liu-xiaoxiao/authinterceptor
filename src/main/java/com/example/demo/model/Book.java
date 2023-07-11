package com.example.demo.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.io.Serializable;

/**
 * (Books)实体类
 *
 * @author makejava
 * @since 2023-07-11 14:19:37
 */
@Data
public class Book implements Serializable {
    private static final long serialVersionUID = -62947121652471908L;

    private Integer id;

    private String bookName;

    private String authorName;

    private LocalDate publishTime;

    private LocalDate latestBorrowedTime;

    private String latestBorrowedUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDate publishTime) {
        this.publishTime = publishTime;
    }

    public LocalDate getLatestBorrowedTime() {
        return latestBorrowedTime;
    }

    public void setLatestBorrowedTime(LocalDate latestBorrowedTime) {
        this.latestBorrowedTime = latestBorrowedTime;
    }

    public String getLatestBorrowedUser() {
        return latestBorrowedUser;
    }

    public void setLatestBorrowedUser(String latestBorrowedUser) {
        this.latestBorrowedUser = latestBorrowedUser;
    }

}

