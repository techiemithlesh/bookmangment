package com.codewithmithlesh.bookmanagment.dto;

public class BookRequestDTO {

    @NotBlank(message = "Title can not be blank !")
    private String title;

    @NotBlank(message = "Author name can not be blank")
    private String Author;

    @Min(value = 1, message = "Pages must be at least 1")
    private int pages;

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


}
