package org.example.Library.controller;

import lombok.AllArgsConstructor;

import org.example.Library.model.dto.Request.LibrarianRequestDto;
import org.example.Library.model.dto.Response.LibrarianResponseDto;
import org.example.Library.service.librarian.LibrarianService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("librarian")

public class LibrarianController implements BaseController<LibrarianResponseDto, LibrarianRequestDto> {
    private final LibrarianService librarianService;


    @Override
    public LibrarianResponseDto create(LibrarianRequestDto t) {
        return librarianService.create(t);
    }

    @Override
    public List<LibrarianResponseDto> getAll() {
        return librarianService.getAll();
    }

    @Override
    public LibrarianResponseDto getById(Integer Id) throws Exception {
        return librarianService.getById(Id);
    }

    @Override
    public LibrarianResponseDto update(LibrarianRequestDto librarianDto) throws Exception {
        return librarianService.update(librarianDto);
    }

    @GetMapping("/findByNationalCode/{nationalCode}")
    public LibrarianResponseDto findbyNationalCode(@PathVariable String nationalCode){
        return librarianService.findByNationalCode(nationalCode);
    }

    @Override
    public void delete(Integer id) {
        librarianService.deleteById(id);
    }

    @GetMapping("/findByCode/{Code}")
    public LibrarianResponseDto findbyCode(@PathVariable String Code){
        return librarianService.findByCode(Code);

}
}
