package com.example.domain;

import lombok.Data;

@Data//创建图书实体类 使用lombok
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;

}
