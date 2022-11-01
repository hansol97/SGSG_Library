package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.MemberController;
import com.kh.model.vo.Book;

public class MainView {
    
    private Scanner sc = new Scanner(System.in);
    private BookController bc = new BookController();
    private MemberController mc = new MemberController();
   
    // 메인 메뉴
    public void mainMenu() {
        while(true) {
            System.out.println("------------- 소근소근 도서관 -------------");
            System.out.println("1. 전체 도서 목록 조회");
            System.out.println("2. 도서 제목 검색");
            System.out.println("3. 작가 검색");
            System.out.println();
            System.out.println("8. 회원가입");
            System.out.println("9. 로그인");
            System.out.println();
            System.out.println("0. 종료");
            
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(menu) {
            case 1 : bc.selectAll();
                break;
            case 2 : selectByTitle();
                break;
            case 3 : selectByAuthor();
                break;
            case 9 : logIn();
                break;
            case 0 : System.out.println("프로그램을 종료합니다.");
                return;
                default : System.out.println("잘못 누르셨습니다.");
            }
        }
    }
    
    // 제목 검색
    public void selectByTitle() {
        System.out.print("검색할 키워드 : ");
        String keyword = sc.nextLine();
        
        bc.selectByTitle(keyword);
    }
    
    public void selectByAuthor() {
        System.out.print("검색할 키워드 : ");
        String keyword = sc.nextLine();
        
        bc.selectByAuthor(keyword);
    }
    
    // 로그인
    public void logIn() {
        System.out.println("------------- 로그인 -------------");
        System.out.print("아이디 : ");
        String userId = sc.nextLine();
        System.out.print("비밀번호 : ");
        String userPwd = sc.nextLine();
        
        System.out.println();
        
        mc.logIn(userId, userPwd);
    }
    
    // 도서 목록 조회
    public void printList(ArrayList<Book> list) {
        System.out.println("조회 결과 " + list.size() + "건");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println();
        }
    }
    
    
    // 요청 화면들..
    public void success(String message) {
        System.out.println("\n" + message);
    }
    public void fail(String message) {
        System.out.println("\n" + message);
    }
}
