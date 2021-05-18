package com.student.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "ground")
public class Ground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ground_id")
    private Integer id;
    @Column(name="ground_name")
    private String name;

    @OneToMany(mappedBy = "ground")
    @JsonBackReference
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List <Student> studentList;
}
