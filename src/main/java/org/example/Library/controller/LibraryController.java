package org.example.Library.controller;




import lombok.AllArgsConstructor;

import org.example.Library.model.dto.Request.LibraryRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.model.dto.Response.LibraryResponseDto;
import org.example.Library.service.library.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/libraries")
public class LibraryController implements BaseController<LibraryResponseDto, LibraryRequestDto> {

    private final LibraryService libraryService;

    @Override
    public LibraryResponseDto create(LibraryRequestDto t) {
        return libraryService.create(t);
    }

    @Override
    public List<LibraryResponseDto> getAll() {
        return libraryService.getAll();
    }

    @Override
    public LibraryResponseDto getById(Integer Id) throws Exception {
        return libraryService.getById(Id);
    }

    @Override
    public LibraryResponseDto update(LibraryRequestDto libraryDto) throws Exception {
        return libraryService.update(libraryDto);
    }

    @GetMapping("/getByName")
    public LibraryResponseDto getByName(@RequestParam("name") String name){
         return libraryService.findByName(name);
    }


    @Override
    public void delete(Integer id) {
        libraryService.deleteById(id);

    }
    @GetMapping("getAllBooks/{id}")
    public List<BookResponseDto> getAllBooks(@PathVariable Integer id){
        return libraryService.getLibraryAllBooks(id);
    }

}
