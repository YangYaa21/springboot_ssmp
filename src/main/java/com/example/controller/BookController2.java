package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @PostMapping
    public boolean saveBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBook(@PathVariable Integer id){
        return bookService.removeById(id);
    }

    @PutMapping
    public boolean updateBook(@RequestBody Book book){
        return bookService.updateById(book);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getByPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage,pageSize);
    }
}
