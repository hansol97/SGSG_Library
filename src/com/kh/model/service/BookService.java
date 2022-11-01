package com.kh.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.model.dao.BookDao;
public class BookService {
    // 책 대여
    public int rentBook(int bookNo) {
        Connection conn = getConnection();
        int result = new BookDao().rentBook(conn, bookNo);
        
        if (result > 0) commit(conn);
        else rollback(conn);
        
        return result;
    }
}
