package org.example.Library.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.Library.exception.ErrorMessage;

import org.example.Library.model.dto.Request.BorrowRRequestDto;
import org.example.Library.service.borrow.BorrowServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@RestController
@RequestMapping("/borrow")
public class BorrowController{
    private final BorrowServiceImpl borrowService;
    @PostMapping("/giveBook")
    public void giveBook( @RequestBody BorrowRRequestDto borrowDto) throws Exception {
        borrowService.giveBook(borrowDto);

    }
    @PostMapping("/returnBook")
    public void returnBook(@RequestBody BorrowRRequestDto borrowDto) throws Exception {
        borrowService.returnBook(borrowDto);

    }







}
