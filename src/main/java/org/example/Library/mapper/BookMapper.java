package org.example.Library.mapper;



import org.example.Library.model.dto.Request.BookRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.model.entity.BookEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))

public interface BookMapper extends BaseMapper<BookEntity, BookResponseDto, BookRequestDto>{
}
