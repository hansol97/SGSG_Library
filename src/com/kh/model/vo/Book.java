package com.kh.model.vo;

import java.sql.Date;

public class Book {
    private int bookNo;
    private String BookTitle;
    private String Author;
    private String genre;
    private String publisher;
    private Date publicationDate;
    private String rentAble;
    
    
    public Book() {
        super();
    }
    public Book(int bookNo, String bookTitle, String author, String genre, String publisher, Date publicationDate,
            String rentAble) {
        super();
        this.bookNo = bookNo;
        this.BookTitle = bookTitle;
        this.Author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.rentAble = rentAble;
    }
    
    
    public int getBookNo() {
        return bookNo;
    }
    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }
    public String getBookTitle() {
        return BookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.BookTitle = bookTitle;
    }
    public String getAuthor() {
        return Author;
    }
    public void setAuthor(String author) {
        this.Author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Date getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String getRentAble() {
        return rentAble;
    }
    public void setRentAble(String rentAble) {
        this.rentAble = rentAble;
    }
    
    
    @Override
    public String toString() {
        return "[" + bookNo + "] 제목 : " + BookTitle + "   작가 : " + Author + "   장르 : " + genre
                + "\n     출판사 : " + publisher + "   출판일 : " + publicationDate + "   대여 가능 여부 : " + rentAble;
    }
}
