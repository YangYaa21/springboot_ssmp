package com.example.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.Book;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
//public interface BookDao{
//
//    @Select("select * from tbl_book where id = #{id}")
//    Book GetById(Integer id);
//
//}
@Mapper//数据层
public interface BookDao extends BaseMapper<Book> {
    //继承BaseMapper<实体类>
    //接口直接提供给service
}
