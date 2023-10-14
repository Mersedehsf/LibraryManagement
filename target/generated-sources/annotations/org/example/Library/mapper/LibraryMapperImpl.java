package org.example.Library.mapper;

import java.util.Date;
import javax.annotation.processing.Generated;
import org.example.Library.model.dto.Request.LibraryRequestDto;
import org.example.Library.model.dto.Response.LibraryResponseDto;
import org.example.Library.model.entity.LibraryEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-14T13:12:58+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class LibraryMapperImpl implements LibraryMapper {

    @Override
    public LibraryEntity dtoToEntity(LibraryRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        LibraryEntity libraryEntity = new LibraryEntity();

        libraryEntity.setId( dto.getId() );
        if ( dto.getCreationTime() != null ) {
            libraryEntity.setCreationTime( Date.from( dto.getCreationTime() ) );
        }
        if ( dto.getUpdateAt() != null ) {
            libraryEntity.setUpdateAt( Date.from( dto.getUpdateAt() ) );
        }
        libraryEntity.setDeleted( dto.isDeleted() );
        libraryEntity.setName( dto.getName() );

        return libraryEntity;
    }

    @Override
    public LibraryResponseDto entityToDto(LibraryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LibraryResponseDto libraryResponseDto = new LibraryResponseDto();

        libraryResponseDto.setId( entity.getId() );
        if ( entity.getCreationTime() != null ) {
            libraryResponseDto.setCreationTime( entity.getCreationTime().toInstant() );
        }
        if ( entity.getUpdateAt() != null ) {
            libraryResponseDto.setUpdateAt( entity.getUpdateAt().toInstant() );
        }
        if ( entity.getDeleted() != null ) {
            libraryResponseDto.setDeleted( entity.getDeleted() );
        }
        libraryResponseDto.setName( entity.getName() );

        return libraryResponseDto;
    }
}
