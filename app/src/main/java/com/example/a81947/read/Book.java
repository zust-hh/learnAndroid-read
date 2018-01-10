package com.example.a81947.read;

/**
 * Created by 81947 on 2018/1/10.
 */

public class Book {
    private String name;
    private String newChapter;
    private int imageId;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    //    public Book(String name,String newChapter,int imageId) {
//        this.name = name;
//        this.imageId = imageId;
//        this.newChapter = newChapter;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewChapter() {
        return newChapter;
    }

    public void setNewChapter(String newChapter) {
        this.newChapter = newChapter;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

}
