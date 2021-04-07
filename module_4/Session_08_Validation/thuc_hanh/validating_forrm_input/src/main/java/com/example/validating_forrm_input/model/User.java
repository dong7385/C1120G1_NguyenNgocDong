package com.example.validating_forrm_input.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class User {
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    @Min(18)
    private Integer age;

    public User() {
    }
    public User(@NotBlank @Size(min = 2, max = 30) String name, @Min(18) Integer age) {
        this.name = name;
        this.age = age;
    }
}
