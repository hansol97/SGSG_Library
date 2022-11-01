package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.vo.Member;

public class MemberDao {
    // 로그인
    public Member logIn(Connection conn, String memberId, String memberPwd) {
        // SELECT -> RESULTSET
        // 객체에 저장할거니까 빈 객체 생성
        // 변수 셋팅
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Member m = new Member(); 
        // SQL 구문
        // SELECT * FROM MEMBER WHERE MEMBER_ID = userId AND MEMBER_PWD = userPwd
        String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
      
        //System.out.println(sql);
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, memberId);
            pstmt.setString(2, memberPwd);
            
            rset = pstmt.executeQuery();
            
            // 로그인한 회원 객체에 저장하기
            if (rset.next()) {
                m.setMemberNo(rset.getInt("MEMBER_NO"));
                m.setMemberId(rset.getString("MEMBER_ID"));
                m.setMemberPwd(rset.getString("MEMBER_PWD"));
                m.setMemberName(rset.getString("MEMBER_NAME"));
                m.setMemberRole(rset.getInt("MEMBER_ROLE"));
                m.setRentCount(rset.getInt("RENT_COUNT"));
                m.setRentBookNo(rset.getString("RENT_BOOK_NO"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }
        
        return m;
    }
    
    // 비밀번호 수정
    public int updatePwd(Connection conn, String memberId, String newPwd) {
        // update -> int
        int result = 0;
        PreparedStatement pstmt = null;
        
        // sql
        String sql = "UPDATE MEMBER SET MEMBER_PWD = ? WHERE MEMBER_ID = ?"; 
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, newPwd);
            pstmt.setString(2, memberId);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
        return result;
    }
    
    // 도서 대여시 카운트 올라가는
    public int rentBook(Connection conn, String memberId, int bookNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        
        String sql = "UPDATE MEMBER "
                + "SET RENT_COUNT = ? "
                + "WHERE MEMBER_ID = ? AND ";
        
        return result;
    }
}
