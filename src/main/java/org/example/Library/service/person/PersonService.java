package org.example.Library.service.person;


import org.example.Library.model.dto.Request.PersonRequestDto;
import org.example.Library.model.dto.Response.PersonResponseDto;
import org.example.Library.service.BaseService;

import java.util.List;

public interface PersonService extends BaseService<PersonResponseDto, PersonRequestDto> {
    PersonResponseDto findByNationalCode(String nationalCode);


}
