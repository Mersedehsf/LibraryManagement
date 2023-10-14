package org.example.Library.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.Library.exception.ErrorMessage;

import org.example.Library.model.dto.Request.PersonRequestDto;
import org.example.Library.model.dto.Response.PersonResponseDto;
import org.example.Library.service.person.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController implements BaseController<PersonResponseDto, PersonRequestDto>{

    private final PersonService personService;


    @Override
    public PersonResponseDto create(PersonRequestDto t) {
        return personService.create(t);
    }

    @Override
    public List<PersonResponseDto> getAll() {
        return personService.getAll();
    }

    @Override
    public PersonResponseDto getById(Integer Id) throws Exception {
        return personService.getById(Id);
    }

    @Override
    public PersonResponseDto update( PersonRequestDto personDto) throws Exception {
        return personService.update(personDto);
    }


    @GetMapping("/findByNationalCode/{nationalCode}")
    public PersonResponseDto findByNationalCode(@PathVariable String nationalCode){
        return personService.findByNationalCode(nationalCode);
    }

    @Override
    public void delete(Integer id) {
         personService.deleteById(id);
    }



}
