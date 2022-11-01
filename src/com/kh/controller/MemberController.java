package com.kh.controller;

import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.AdminView;
import com.kh.view.MainView;
import com.kh.view.MemberView;

public class MemberController {

    // 로그인
    public void logIn(String memberId, String memberPwd) {
        Member m = new MemberService().logIn(memberId, memberPwd);
        
        if(m.getMemberRole() == 1) {
            new AdminView().adminMenu(m);
        } else if(m.getMemberRole() == 2) {
            new MemberView().memberMenu(m);
        } else {
            new MainView().fail("로그인 실패");
        }
    }
    
    // 비밀번호 수정
    public void updatePwd(String memberId, String newPwd) {
        int result = new MemberService().updatePwd(memberId, newPwd);
        
        if (result > 0) {
            new MainView().success("비밀번호 변경 성공");
        } else {
            new MainView().fail("비밀번호 변경 실패");
        }
    }
    
    // 대여중인 책
    public void selectRentBook(Member m) {
        new MemberService().selectRentBook(m);
    }
}
