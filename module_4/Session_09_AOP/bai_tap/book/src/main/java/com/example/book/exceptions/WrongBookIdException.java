package com.example.book.exceptions;

public class WrongBookIdException extends Exception {
    public WrongBookIdException() {
    }

    @Override
    public String getMessage() {
        return "Id sách không hợp lệ xác vui lòng thử lại .";
    }
}