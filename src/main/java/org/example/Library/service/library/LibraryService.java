package org.example.Library.service.library;



import org.example.Library.model.dto.Request.LibraryRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.model.dto.Response.LibraryResponseDto;
import org.example.Library.service.BaseService;

import java.util.List;

public interface LibraryService extends BaseService<LibraryResponseDto, LibraryRequestDto> {
    LibraryResponseDto findByName(String name);
    public List<BookResponseDto> getLibraryAllBooks(Integer id);

}
