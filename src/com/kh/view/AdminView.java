package com.kh.view;

import com.kh.model.vo.Member;

public class AdminView {

 // 관리자 메뉴
    public void adminMenu(Member m) {
        System.out.println("------------- 관리자 메뉴 -------------");
        System.out.println("1. 도서 관리");
        System.out.println("2. 회원 관리");
        
        System.out.println("1. 전체 도서 목록 조회");
        System.out.println("2. 도서 추가");
        System.out.println("3. 도서 수정");
        System.out.println("4. 도서 삭제");
        System.out.println("5. 대출 중인 회원 확인");
        System.out.println("6. 회원 전체 목록 조회");     
        System.out.print("메뉴 선택 : ");
    }
}
