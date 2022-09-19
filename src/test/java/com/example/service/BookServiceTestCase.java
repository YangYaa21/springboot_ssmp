package com.example.service;

import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void save(){
        Book book = new Book();
        book.setName("测试asddd");
        book.setType("111");
        book.setDescription("11111");
        bookService.save(book);
    }

    @Test
    void testDeleteById(){
        bookService.deleteById(17);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(18);
        book.setName("asd");
        bookService.updateById(book);
    }

    @Test
    void testGetById(){
        bookService.getById(2);
    }

    @Test
    void testgetAll(){
        bookService.getAll();
    }

    @Test
    void testgetByPage(){
        bookService.getByPage(2,5);
    }

}
