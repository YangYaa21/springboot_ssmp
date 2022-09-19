package com.example.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.BookDao;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//实现业务层接口，继承ServiceImpl<M, 实体类>，实现IBookService
public class BookServiceImp extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page(currentPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book queryBook) {
        IPage<Book> page = new Page(currentPage, pageSize);

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(queryBook.getType()), Book::getType, queryBook.getType());
        lqw.like(Strings.isNotEmpty(queryBook.getName()), Book::getName, queryBook.getName());
        lqw.like(Strings.isNotEmpty(queryBook.getDescription()), Book::getDescription, queryBook.getDescription());
        return bookDao.selectPage(page, lqw);
    }
}
