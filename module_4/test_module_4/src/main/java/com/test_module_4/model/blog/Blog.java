package com.test_module_4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer blogId;
    @Column(name = "blog_title",length = 255)
    private String blogTitle;
    @Column(name="blog_questions",length = 255)
    private String blogQuestions;
    @Column(name = "blog_answer",length = 255)
    private String blogAnswer;
    @Column(name = "date_create",columnDefinition = "date")
    private String dateCreate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
