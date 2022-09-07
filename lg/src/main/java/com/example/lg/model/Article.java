package com.example.lg.model;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String image;
    @Column
    private String articlecol;
    @Column
    private int ui;

    public Article() {
    }

    public Article(String title, String description, String image, String articlecol, int ui) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.articlecol = articlecol;
        this.ui = ui;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArticlecol() {
        return articlecol;
    }

    public void setArticlecol(String articlecol) {
        this.articlecol = articlecol;
    }


    public int getUi() {
        return ui;
    }

    public void setUi(int ui) {
        this.ui = ui;
    }
}
