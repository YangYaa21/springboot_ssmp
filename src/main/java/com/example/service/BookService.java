package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;

import java.util.List;

public interface BookService {
    boolean save (Book book);
    boolean deleteById (Integer id);
    boolean updateById (Book book);
    Book getById (Integer id);
    List<Book> getAll();
    IPage<Book> getByPage(Integer crruentPage, Integer pageSize);
}
