package com.kh.controller;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.BookDao;
import com.kh.model.service.BookService;
import com.kh.model.vo.Book;
import com.kh.view.MainView;

public class BookController {
    
    // 도서 전체 목록 조회
    public void selectAll() {
        ArrayList<Book> list = new BookDao().selectAll();
        
        if (list.isEmpty()) {
            new MainView().fail("도서 목록 조회 실패");
        } else {
            new MainView().printList(list);            
        }
    }
    
    // 도서 제목으로 검색
    public void selectByTitle(String keyword) {
        ArrayList<Book> list = new BookDao().selectByTitle(keyword);
        
        if(list.isEmpty()) {
            new MainView().fail("조회 결과가 없습니다.");
        } else {
            new MainView().printList(list);
        }
    }
    
    public void selectByAuthor(String keyword) {
        ArrayList<Book> list = new BookDao().selectByAuthor(keyword);
        
        if(list.isEmpty()) {
            new MainView().fail("조회 결과가 없습니다.");
        } else {
            new MainView().printList(list);
        }
    }
    

    public void rentBook(int bookNo) {
        int result = new BookService().rentBook(bookNo);
        
        if (result > 0) {
            new MainView().success("대여 성공");
        } else {
            new MainView().fail("대여 실패");
        }
    }
}
