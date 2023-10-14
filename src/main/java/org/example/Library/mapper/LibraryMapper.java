package org.example.Library.mapper;


import org.example.Library.model.dto.Request.LibraryRequestDto;
import org.example.Library.model.dto.Response.LibraryResponseDto;
import org.example.Library.model.entity.LibraryEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))
public interface LibraryMapper extends BaseMapper<LibraryEntity, LibraryResponseDto, LibraryRequestDto>{
}
