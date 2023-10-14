package org.example.Library.mapper;

import java.util.Date;
import javax.annotation.processing.Generated;
import org.example.Library.model.dto.Request.BookRequestDto;
import org.example.Library.model.dto.Request.BorrowRRequestDto;
import org.example.Library.model.dto.Request.LibraryRequestDto;
import org.example.Library.model.dto.Request.MemberRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.model.dto.Response.BorrowResponseDto;
import org.example.Library.model.dto.Response.LibraryResponseDto;
import org.example.Library.model.dto.Response.MemberResponseDto;
import org.example.Library.model.entity.BookEntity;
import org.example.Library.model.entity.BorrowEntity;
import org.example.Library.model.entity.LibraryEntity;
import org.example.Library.model.entity.MemberEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T16:00:45+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BorrowMapperImpl implements BorrowMapper {

    @Override
    public BorrowEntity dtoToEntity(BorrowRRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        BorrowEntity borrowEntity = new BorrowEntity();

        borrowEntity.setId( dto.getId() );
        if ( dto.getCreationTime() != null ) {
            borrowEntity.setCreationTime( Date.from( dto.getCreationTime() ) );
        }
        if ( dto.getUpdateAt() != null ) {
            borrowEntity.setUpdateAt( Date.from( dto.getUpdateAt() ) );
        }
        borrowEntity.setDeleted( dto.isDeleted() );
        borrowEntity.setStartDate( dto.getStartDate() );
        borrowEntity.setEndDate( dto.getEndDate() );
        borrowEntity.setReturnDate( dto.getReturnDate() );
        borrowEntity.setBook( bookRequestDtoToBookEntity( dto.getBook() ) );
        borrowEntity.setMember( memberRequestDtoToMemberEntity( dto.getMember() ) );

        return borrowEntity;
    }

    @Override
    public BorrowResponseDto entityToDto(BorrowEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BorrowResponseDto borrowResponseDto = new BorrowResponseDto();

        if ( entity.getCreationTime() != null ) {
            borrowResponseDto.setCreationTime( entity.getCreationTime().toInstant() );
        }
        if ( entity.getUpdateAt() != null ) {
            borrowResponseDto.setUpdateAt( entity.getUpdateAt().toInstant() );
        }
        if ( entity.getDeleted() != null ) {
            borrowResponseDto.setDeleted( entity.getDeleted() );
        }
        borrowResponseDto.setId( entity.getId() );
        borrowResponseDto.setStartDate( entity.getStartDate() );
        borrowResponseDto.setEndDate( entity.getEndDate() );
        borrowResponseDto.setReturnDate( entity.getReturnDate() );
        borrowResponseDto.setBook( bookEntityToBookResponseDto( entity.getBook() ) );
        borrowResponseDto.setMember( memberEntityToMemberResponseDto( entity.getMember() ) );

        return borrowResponseDto;
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

    protected BookEntity bookRequestDtoToBookEntity(BookRequestDto bookRequestDto) {
        if ( bookRequestDto == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setId( bookRequestDto.getId() );
        if ( bookRequestDto.getCreationTime() != null ) {
            bookEntity.setCreationTime( Date.from( bookRequestDto.getCreationTime() ) );
        }
        if ( bookRequestDto.getUpdateAt() != null ) {
            bookEntity.setUpdateAt( Date.from( bookRequestDto.getUpdateAt() ) );
        }
        bookEntity.setDeleted( bookRequestDto.isDeleted() );
        bookEntity.setName( bookRequestDto.getName() );
        bookEntity.setNumbers( bookRequestDto.getNumbers() );
        bookEntity.setAvailable( bookRequestDto.isAvailable() );
        bookEntity.setLibrary( libraryRequestDtoToLibraryEntity( bookRequestDto.getLibrary() ) );

        return bookEntity;
    }

    protected MemberEntity memberRequestDtoToMemberEntity(MemberRequestDto memberRequestDto) {
        if ( memberRequestDto == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setId( memberRequestDto.getId() );
        if ( memberRequestDto.getCreationTime() != null ) {
            memberEntity.setCreationTime( Date.from( memberRequestDto.getCreationTime() ) );
        }
        if ( memberRequestDto.getUpdateAt() != null ) {
            memberEntity.setUpdateAt( Date.from( memberRequestDto.getUpdateAt() ) );
        }
        memberEntity.setDeleted( memberRequestDto.getDeleted() );
        memberEntity.setFname( memberRequestDto.getFname() );
        memberEntity.setLname( memberRequestDto.getLname() );
        memberEntity.setNationalCode( memberRequestDto.getNationalCode() );
        memberEntity.setCode( memberRequestDto.getCode() );

        return memberEntity;
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

    protected BookResponseDto bookEntityToBookResponseDto(BookEntity bookEntity) {
        if ( bookEntity == null ) {
            return null;
        }

        BookResponseDto bookResponseDto = new BookResponseDto();

        bookResponseDto.setId( bookEntity.getId() );
        if ( bookEntity.getCreationTime() != null ) {
            bookResponseDto.setCreationTime( bookEntity.getCreationTime().toInstant() );
        }
        if ( bookEntity.getUpdateAt() != null ) {
            bookResponseDto.setUpdateAt( bookEntity.getUpdateAt().toInstant() );
        }
        if ( bookEntity.getDeleted() != null ) {
            bookResponseDto.setDeleted( bookEntity.getDeleted() );
        }
        bookResponseDto.setName( bookEntity.getName() );
        bookResponseDto.setNumbers( bookEntity.getNumbers() );
        bookResponseDto.setLibrary( libraryEntityToLibraryResponseDto( bookEntity.getLibrary() ) );
        bookResponseDto.setAvailable( bookEntity.isAvailable() );

        return bookResponseDto;
    }

    protected MemberResponseDto memberEntityToMemberResponseDto(MemberEntity memberEntity) {
        if ( memberEntity == null ) {
            return null;
        }

        MemberResponseDto memberResponseDto = new MemberResponseDto();

        if ( memberEntity.getCreationTime() != null ) {
            memberResponseDto.setCreationTime( memberEntity.getCreationTime().toInstant() );
        }
        if ( memberEntity.getUpdateAt() != null ) {
            memberResponseDto.setUpdateAt( memberEntity.getUpdateAt().toInstant() );
        }
        memberResponseDto.setDeleted( memberEntity.getDeleted() );
        memberResponseDto.setId( memberEntity.getId() );
        memberResponseDto.setFname( memberEntity.getFname() );
        memberResponseDto.setLname( memberEntity.getLname() );
        memberResponseDto.setNationalCode( memberEntity.getNationalCode() );
        memberResponseDto.setCode( memberEntity.getCode() );

        return memberResponseDto;
    }
}
