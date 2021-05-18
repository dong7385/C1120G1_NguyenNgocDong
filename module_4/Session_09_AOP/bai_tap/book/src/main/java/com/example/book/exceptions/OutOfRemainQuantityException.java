package com.example.book.exceptions;

public class OutOfRemainQuantityException extends Exception {
    public OutOfRemainQuantityException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Sách đã được mượn hết ,vui lòng quay lại sau";
    }
}
