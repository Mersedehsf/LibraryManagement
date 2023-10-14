package org.example.Library.mapper;


import org.example.Library.model.dto.Request.PersonRequestDto;
import org.example.Library.model.dto.Response.PersonResponseDto;
import org.example.Library.model.entity.PersonEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))


public interface PersonMapper extends BaseMapper<PersonEntity, PersonResponseDto, PersonRequestDto>{
}
