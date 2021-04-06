package com.example.blog.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String Content;
    private Date postDate;

    @ManyToOne
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDay) {
        this.postDate = postDay;
    }

}
