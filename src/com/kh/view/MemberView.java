package com.kh.view;

import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

public class MemberView {

    private Scanner sc = new Scanner(System.in);
    private BookController bc = new BookController();
    private MemberController mc = new MemberController();
    private MainView mv = new MainView();
    
    // 멤버 메뉴
    public void memberMenu(Member m) {
        while(true) {
            System.out.println("------------- 소근소근 도서관 -------------");
            System.out.println(m.getMemberName() + "님 안녕하세요!");
            System.out.println();
            System.out.println("1. 전체 도서 목록 조회");
            System.out.println("2. 도서 제목 검색");
            System.out.println("3. 작가 검색\n");
            
            System.out.println("4. 현재 대여중인 도서");
            System.out.println("5. 도서 대여");
            System.out.println("6. 도서 반납\n");
            
            System.out.println("7. 마이페이지\n");
            
            System.out.println("0. 로그아웃");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(menu) {
            case 1: bc.selectAll();
                break;
            case 2: mv.selectByTitle();
                break;
            case 3: mv.selectByAuthor();
                break;
            case 4: selectRentBook(m);
                break;
            case 5: rentBook(m);
                break;
            case 6 : 
                break;
            case 7: mypageMenu(m);
                break;
            case 0: System.out.println("로그아웃 합니다.");
                    System.out.println();
                return;
            default : System.out.println("잘못 누르셨습니다.");
            }
            
            
        }        
    }
    
    public void rentBook(Member m) {
        System.out.print("대여하실 책 번호를 입력해주세요.");
        System.out.print("> ");
        int bookNo = sc.nextInt();
        sc.nextLine();
        
        bc.rentBook(bookNo);
        mc.rentBook(m.getMemberId(), bookNo);
        //mc.selectRentBook(m.getMemberId());
    }

    // 마이페이지 메뉴
    public void mypageMenu(Member m) {
        System.out.println(m.getMemberName() + "님 안녕하세요");
        System.out.println("현재까지의 도서 대여 횟수 : " + m.getRentCount());
        while(true) {
            System.out.println("1. 비밀번호 변경");
            System.out.println("2. 탈퇴하기");
            System.out.println("0. 뒤로가기");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            
            switch(menu) {
            case 1 : updatePwd(m.getMemberId());
            break;
            case 2 :// deleteMember(m);
            case 0 : return;
            default : System.out.println("잘못 누르셨습니다.");
            }
        }
    }
    
    public void updatePwd(String memberId) {
        System.out.println("새로운 비밀번호 : ");
        String newPwd = sc.nextLine();
        
        mc.updatePwd(memberId, newPwd);
    }
    
    public void selectRentBook(Member m) {
        mc.selectRentBook(m);
    }
}
