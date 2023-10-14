package org.example.Library.mapper;

import java.util.Date;
import javax.annotation.processing.Generated;
import org.example.Library.model.dto.Request.LibrarianRequestDto;
import org.example.Library.model.dto.Response.LibrarianResponseDto;
import org.example.Library.model.entity.LibrarianEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T16:00:45+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class LibrarianMapperImpl implements LibrarianMapper {

    @Override
    public LibrarianEntity dtoToEntity(LibrarianRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        LibrarianEntity librarianEntity = new LibrarianEntity();

        librarianEntity.setId( dto.getId() );
        if ( dto.getCreationTime() != null ) {
            librarianEntity.setCreationTime( Date.from( dto.getCreationTime() ) );
        }
        if ( dto.getUpdateAt() != null ) {
            librarianEntity.setUpdateAt( Date.from( dto.getUpdateAt() ) );
        }
        librarianEntity.setDeleted( dto.getDeleted() );
        librarianEntity.setFname( dto.getFname() );
        librarianEntity.setLname( dto.getLname() );
        librarianEntity.setNationalCode( dto.getNationalCode() );
        librarianEntity.setCode( dto.getCode() );

        return librarianEntity;
    }

    @Override
    public LibrarianResponseDto entityToDto(LibrarianEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LibrarianResponseDto librarianResponseDto = new LibrarianResponseDto();

        if ( entity.getCreationTime() != null ) {
            librarianResponseDto.setCreationTime( entity.getCreationTime().toInstant() );
        }
        if ( entity.getUpdateAt() != null ) {
            librarianResponseDto.setUpdateAt( entity.getUpdateAt().toInstant() );
        }
        librarianResponseDto.setDeleted( entity.getDeleted() );
        librarianResponseDto.setId( entity.getId() );
        librarianResponseDto.setFname( entity.getFname() );
        librarianResponseDto.setLname( entity.getLname() );
        librarianResponseDto.setNationalCode( entity.getNationalCode() );
        librarianResponseDto.setCode( entity.getCode() );

        return librarianResponseDto;
    }
}
