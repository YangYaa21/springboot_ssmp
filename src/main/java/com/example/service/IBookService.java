package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.Book;

//创建业务层接口，继承IService<Book>
public interface IBookService extends IService<Book> {
//    如果有其他需求要自己定义，不要覆盖他的，直接加即可
//    在通用类基础上做重载或功能追加
//    注意不要覆盖原始操作
//    追加操作与原始操作通过名称区分，功能类似
//    如果怕重名，加@Override测试，报错说明不重
    boolean saveBook(Book book);


    IPage<Book> getPage(int currentPage, int pageSize);


    IPage<Book> getPage(int currentPage, int pageSize, Book queryBook);
}
