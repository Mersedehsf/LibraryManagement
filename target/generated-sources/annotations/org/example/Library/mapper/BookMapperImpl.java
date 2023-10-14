package org.example.Library.mapper;

import java.util.Date;
import javax.annotation.processing.Generated;
import org.example.Library.model.dto.Request.BookRequestDto;
import org.example.Library.model.dto.Request.LibraryRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.model.dto.Response.LibraryResponseDto;
import org.example.Library.model.entity.BookEntity;
import org.example.Library.model.entity.LibraryEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T16:00:45+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookEntity dtoToEntity(BookRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId( dto.getId() );
        if ( dto.getCreationTime() != null ) {
            bookEntity.setCreationTime( Date.from( dto.getCreationTime() ) );
        }
        if ( dto.getUpdateAt() != null ) {
            bookEntity.setUpdateAt( Date.from( dto.getUpdateAt() ) );
        }
        bookEntity.setDeleted( dto.isDeleted() );
        bookEntity.setName( dto.getName() );
        bookEntity.setNumbers( dto.getNumbers() );
        bookEntity.setAvailable( dto.isAvailable() );
        bookEntity.setLibrary( libraryRequestDtoToLibraryEntity( dto.getLibrary() ) );

        return bookEntity;
    }

    @Override
    public BookResponseDto entityToDto(BookEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookResponseDto bookResponseDto = new BookResponseDto();

        bookResponseDto.setId( entity.getId() );
        if ( entity.getCreationTime() != null ) {
            bookResponseDto.setCreationTime( entity.getCreationTime().toInstant() );
        }
        if ( entity.getUpdateAt() != null ) {
            bookResponseDto.setUpdateAt( entity.getUpdateAt().toInstant() );
        }
        if ( entity.getDeleted() != null ) {
            bookResponseDto.setDeleted( entity.getDeleted() );
        }
        bookResponseDto.setName( entity.getName() );
        bookResponseDto.setNumbers( entity.getNumbers() );
        bookResponseDto.setLibrary( libraryEntityToLibraryResponseDto( entity.getLibrary() ) );
        bookResponseDto.setAvailable( entity.isAvailable() );

        return bookResponseDto;
    }

    protected LibraryEntity libraryRequestDtoToLibraryEntity(LibraryRequestDto libraryRequestDto) {
        if ( libraryRequestDto == null ) {
            return null;
        }

        LibraryEntity libraryEntity = new LibraryEntity();

        libraryEntity.setId( libraryRequestDto.getId() );
        if ( libraryRequestDto.getCreationTime() != null ) {
            libraryEntity.setCreationTime( Date.from( libraryRequestDto.getCreationTime() ) );
        }
        if ( libraryRequestDto.getUpdateAt() != null ) {
            libraryEntity.setUpdateAt( Date.from( libraryRequestDto.getUpdateAt() ) );
        }
        libraryEntity.setDeleted( libraryRequestDto.isDeleted() );
        libraryEntity.setName( libraryRequestDto.getName() );

        return libraryEntity;
    }

    protected LibraryResponseDto libraryEntityToLibraryResponseDto(LibraryEntity libraryEntity) {
        if ( libraryEntity == null ) {
            return null;
        }

        LibraryResponseDto libraryResponseDto = new LibraryResponseDto();

        libraryResponseDto.setId( libraryEntity.getId() );
        if ( libraryEntity.getCreationTime() != null ) {
            libraryResponseDto.setCreationTime( libraryEntity.getCreationTime().toInstant() );
        }
        if ( libraryEntity.getUpdateAt() != null ) {
            libraryResponseDto.setUpdateAt( libraryEntity.getUpdateAt().toInstant() );
        }
        if ( libraryEntity.getDeleted() != null ) {
            libraryResponseDto.setDeleted( libraryEntity.getDeleted() );
        }
        libraryResponseDto.setName( libraryEntity.getName() );

        return libraryResponseDto;
    }
}
