package com.student.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_topic")
    private String topic;
    @Column(name = "student_teacher")
    private String teacher;
    @Column(name = "student_email")
    private String email;
    @Column(name = "student_phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "ground_id")
    private Ground ground;
}
