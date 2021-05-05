package com.example.my_counter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
public class MyCounter {
    public MyCounter(int count) {
        this.count = count;
    }

    public MyCounter() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;
    public int increment() {
        return count++;
    }
}
