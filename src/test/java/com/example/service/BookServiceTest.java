package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void save(){
        Book book = new Book();
        book.setName("-----------");
        book.setType("-----");
        book.setDescription("---------");
        bookService.save(book);
    }

    @Test
    void testDeleteById(){
        bookService.removeById(18);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(19);
        book.setName("------------------");
        bookService.updateById(book);
    }

    @Test
    void testGetById(){
        bookService.getById(2);
    }

    @Test
    void testgetAll(){
        bookService.list();
    }

    @Test
    void testgetByPage(){
        IPage<Book> page = new Page(2,5);
        bookService.page(page);
        page.getCurrent();
        page.getSize();
        page.getTotal();
        page.getRecords();
    }

}
