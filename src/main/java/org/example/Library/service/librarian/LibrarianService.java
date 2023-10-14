package org.example.Library.service.librarian;


import org.example.Library.model.dto.Request.LibrarianRequestDto;
import org.example.Library.model.dto.Response.LibrarianResponseDto;
import org.example.Library.service.BaseService;

public interface LibrarianService extends BaseService<LibrarianResponseDto, LibrarianRequestDto> {
        LibrarianResponseDto findByNationalCode(String nationalCode);
        //  LibrarianDto findByCode(String code);


        LibrarianResponseDto findByCode(String code);





}
