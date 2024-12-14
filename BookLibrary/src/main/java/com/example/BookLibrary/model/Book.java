package com.example.BookLibrary.model;
public class Book {
    private Long id;
    private String name;
    private String authorName;

    public Book(){
       //default cons
    }

    public Book(Long outId, String outName, String outAuthorName){
        this.id = outId;
        this.name = outName;
        this.authorName = outAuthorName;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long outId){
        this.id = outId;
    }

    public String getname(){
        return name;
    }

    public void setName(String outName){
        this.name = outName;
    }

    public String getAuthorName(){
        return authorName;
    }

    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
}

