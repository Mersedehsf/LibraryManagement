package org.example.Library.mapper;


import org.example.Library.model.dto.Request.LibrarianRequestDto;
import org.example.Library.model.dto.Response.LibrarianResponseDto;
import org.example.Library.model.entity.LibrarianEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))

public interface LibrarianMapper extends BaseMapper<LibrarianEntity, LibrarianResponseDto, LibrarianRequestDto>{
}
