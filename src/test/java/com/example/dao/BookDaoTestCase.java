package com.example.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;


    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("测试1");
        book.setType("ces");
        book.setDescription("dfffff");
        bookDao.insert(book);
    }

    @Test
    void testDeleteById(){
        bookDao.deleteById(16);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setName("111");
        bookDao.updateById(book);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }

    @Test
    void testpage(){
        Page page = new Page(2,5);
        bookDao.selectPage(page,null);
    }

    @Test
    void testGetBy(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name","spring");
        bookDao.selectList(queryWrapper);
    }

    @Test
    void testGetBy2(){
        String name = "spring";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper();
//        lqw.like(name != null, Book::getName,name);
        lqw.like(Strings.isNotEmpty(name), Book::getName,name);
        bookDao.selectList(lqw);
    }

}
