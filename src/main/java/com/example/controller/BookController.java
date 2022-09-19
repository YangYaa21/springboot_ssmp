package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.domain.Book;
import com.example.service.IBookService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping
    public Result saveBook(@RequestBody Book book) throws IOException {
        if (book.getName().equals("123")) {
            throw new IOException();
        } else {
            boolean flag = bookService.save(book);
            return new Result(flag, flag ? "添加成功^_^" : " 添加失败-_-！");
        }
    }

    @DeleteMapping("/{id}")
    public Result deleteBook(@PathVariable Integer id) {
        boolean flag = bookService.removeById(id);
        return new Result(flag);
    }

    @PutMapping
    public Result updateBook(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new Result(flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
//    public Result getById(@PathVariable Integer id) throw IOException{
//        if(true)  throw new IOException();
        return new Result(true, bookService.getById(id));
    }

    @GetMapping
    public Result getAll() {
        return new Result(true, bookService.list());

    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public Result getByPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        if (currentPage > page.getPages())
//            page = bookService.getPage((int) page.getPages(), pageSize);
//        return new Result(true, page);
//    }
//
    @GetMapping("/{currentPage}/{pageSize}")
    public Result getByPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
//        if (currentPage > page.getPages())
//            page = bookService.getPage((int) page.getPages(), pageSize, book);
        return new Result(null != page, page);
    }
}
