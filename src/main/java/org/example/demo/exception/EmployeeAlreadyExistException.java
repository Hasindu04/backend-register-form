package org.example.demo.exception;

public class EmployeeAlreadyExistException extends RuntimeException{

    public EmployeeAlreadyExistException(String message) {
        super(message);
    }
}
