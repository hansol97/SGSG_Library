package com.kh.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

public class MemberService {
    
    public Member logIn(String memberId, String memberPwd) {
        Connection conn = getConnection();
        
        Member m = new MemberDao().logIn(conn, memberId, memberPwd);
        close(conn);
        
        return m;
    }
    
    public int updatePwd(String userId, String newPwd) {
        Connection conn = getConnection();
        int result = new MemberDao().updatePwd(conn, userId, newPwd);
        
        if(result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        return result;
    }
    
    public void rentBook(String memberId, int bookNo) {
        Connection conn = getConnection();
        int result = new MemberDao().rentBook(conn, memberId, bookNo);
    }
    
    public void selectRentBook(Member m) {
        Connection conn = getConnection();
        //int result = new MemberDao().rentBook(m);
    }
}
