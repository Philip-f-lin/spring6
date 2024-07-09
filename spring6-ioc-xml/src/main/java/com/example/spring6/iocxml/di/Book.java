package com.example.spring6.iocxml.di;

public class Book {
    private String bookName;
    private String author;

    private String others;

    public Book() {
        System.out.println("無參數構造執行...");
    }

    public Book(String bookName, String author) {
        System.out.println("有參數構造執行...");
        this.bookName = bookName;
        this.author = author;
    }
    // 生成 set 方法

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // set 方法注入
        Book book = new Book();
        book.setBookName("java");
        book.setAuthor("Philip");

        // 通過構造器注入
        Book book1 = new Book("C++", "Philip");
    }
}
