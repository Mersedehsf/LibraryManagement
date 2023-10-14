package org.example.Library.service.book;


import org.example.Library.model.dto.Request.BookRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.service.BaseService;

import java.util.List;

public interface BookService extends BaseService<BookResponseDto, BookRequestDto> {

    List<BookResponseDto> findByName(String name);
}

