package org.example.Library.controller;

import lombok.AllArgsConstructor;
import org.example.Library.exception.ErrorMessage;

import org.example.Library.model.dto.Request.BookRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.service.book.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController implements BaseController<BookResponseDto, BookRequestDto> {
    private final BookService bookService;

    @Override
    public BookResponseDto create(@RequestBody BookRequestDto t) {
        return bookService.create(t);
    }

    @Override
    public List<BookResponseDto> getAll() {
        return bookService.getAll();
    }

    @Override
    public BookResponseDto getById(Integer Id) throws Exception {
        return bookService.getById(Id);
    }

    @Override
    public BookResponseDto update(BookRequestDto bookDto) throws Exception {
        return bookService.update(bookDto);
    }


    @GetMapping("getByName")
    public List<BookResponseDto> getByName(@RequestParam("name") String name) {
        return bookService.findByName(name);

    }

    @Override
    public void delete(Integer id) {
        bookService.deleteById(id);

    }

}
