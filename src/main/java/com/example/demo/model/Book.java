package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo.typehandler.BookLatestBorrowedUserTypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * (Books)实体类
 *
 * @author makejava
 * @since 2023-07-11 14:19:37
 */
@Data
@TableName(autoResultMap = true)
public class Book implements Serializable {
    private static final long serialVersionUID = -62947121652471908L;

    private Integer id;

    private String bookName;

    private String authorName;

    private LocalDate publishTime;

    private LocalDate latestBorrowedTime;
    @TableField(typeHandler = BookLatestBorrowedUserTypeHandler.class)
    private List<Character> latestBorrowedUser;


}

