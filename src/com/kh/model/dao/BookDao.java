package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Member;

public class BookDao {
    
    // 전체 도서 목록 조회
    public ArrayList<Book> selectAll() {
        // 셀렉트문 쓸거임. 결과 리절트셋
        // 리절트셋 리스트에 담을거임
        ArrayList<Book> list = new ArrayList<Book>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        // sql
        String sql = "SELECT * FROM BOOK";
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SGSG", "SGSG");
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                list.add(new Book(rset.getInt("BOOK_NO"),
                                  rset.getString("BOOK_TITLE"),
                                  rset.getString("AUTHOR"),
                                  rset.getString("GENRE"),
                                  rset.getString("PUBLISHER"),
                                  rset.getDate("PUBLICATION_DATE"),
                                  rset.getString("RENT_ABLE")));
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
    
    //
    public ArrayList<Book> selectByTitle(String keyword) {
        // 결과 리절트셋 몇개 들어갈지 모름 ArrayList쓸거임
        ArrayList<Book> list = new ArrayList<Book>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        // sql
        String sql = "SELECT * FROM BOOK WHERE BOOK_TITLE LIKE ?";
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                               "SGSG",
                                               "SGSG");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                list.add(new Book(rset.getInt("BOOK_NO"),
                                  rset.getString("BOOK_TITLE"),
                                  rset.getString("AUTHOR"),
                                  rset.getString("GENRE"),
                                  rset.getString("PUBLISHER"),
                                  rset.getDate("PUBLICATION_DATE"),
                                  rset.getString("RENT_ABLE")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
    
    public ArrayList<Book> selectByAuthor(String keyword) {
        // 결과 리절트셋 몇개 들어갈지 모름 ArrayList쓸거임
        ArrayList<Book> list = new ArrayList<Book>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        // sql
        String sql = "SELECT * FROM BOOK WHERE AUTHOR LIKE ?";
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                                               "SGSG",
                                               "SGSG");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            rset = pstmt.executeQuery();
            
            while(rset.next()) {
                list.add(new Book(rset.getInt("BOOK_NO"),
                                  rset.getString("BOOK_TITLE"),
                                  rset.getString("AUTHOR"),
                                  rset.getString("GENRE"),
                                  rset.getString("PUBLISHER"),
                                  rset.getDate("PUBLICATION_DATE"),
                                  rset.getString("RENT_ABLE")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
    
    public int rentBook(Connection conn, int bookNo) {
        // update -> 
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE BOOK "
                      + "SET RENT_ABLE = ? "
                    + "WHERE BOOK_NO = ?"
                      + "AND RENT_ABLE = 'Y'";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "N");
            pstmt.setInt(2, bookNo);
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
}