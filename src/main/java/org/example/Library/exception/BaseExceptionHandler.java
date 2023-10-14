package org.example.Library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
    public class BaseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> noSuchElementException(NullPointerException error) {
        return new ResponseEntity<>(new ErrorMessage(404, "this person with this national code doesn't exists."), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessage> methodArgExceptionHandler2(SQLIntegrityConstraintViolationException error) {
        return new ResponseEntity<>(new ErrorMessage(500, "error!person with the same national code exists"),HttpStatus.INTERNAL_SERVER_ERROR);
    }
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<ErrorMessage> methodArgExceptionHandler(Exception error) {
//        return new ResponseEntity<>(new ErrorMessage(500, "the book or the member with this id is not available."), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(UnsupportedOperationException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<ErrorMessage> methodArgExceptionHandler2(UnsupportedOperationException error) {
//        return new ResponseEntity<>(new ErrorMessage(500, "nationalCode cannot be updated"), HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorMessage> runtimeExceptionHandler(RuntimeException error) {
        return new ResponseEntity<>(new ErrorMessage(500, "this book isn't borrowed "),HttpStatus.NOT_ACCEPTABLE);
    }

//    @ExceptionHandler(IllegalStateException.class)
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//    public ErrorMessage bookDoesNotExists(Exception error) {
//        return new ErrorMessage(406, "all of these books are borrowed");
//    }
//    @ExceptionHandler(NoSuchElementException.class)//beddone valid
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//    public ErrorMessage methodArgExceptionHandler(NoSuchElementException error) {
//        return new ErrorMessage(500, "error!book with this id doesn't exists");
//    }
//
//


}
