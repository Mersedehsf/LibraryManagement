package org.example.Library.mapper;

import java.util.Date;
import javax.annotation.processing.Generated;
import org.example.Library.model.dto.Request.PersonRequestDto;
import org.example.Library.model.dto.Response.PersonResponseDto;
import org.example.Library.model.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T16:00:45+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonEntity dtoToEntity(PersonRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( dto.getId() );
        if ( dto.getCreationTime() != null ) {
            personEntity.setCreationTime( Date.from( dto.getCreationTime() ) );
        }
        if ( dto.getUpdateAt() != null ) {
            personEntity.setUpdateAt( Date.from( dto.getUpdateAt() ) );
        }
        personEntity.setDeleted( dto.getDeleted() );
        personEntity.setFname( dto.getFname() );
        personEntity.setLname( dto.getLname() );
        personEntity.setNationalCode( dto.getNationalCode() );

        return personEntity;
    }

    @Override
    public PersonResponseDto entityToDto(PersonEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PersonResponseDto personResponseDto = new PersonResponseDto();

        if ( entity.getCreationTime() != null ) {
            personResponseDto.setCreationTime( entity.getCreationTime().toInstant() );
        }
        if ( entity.getUpdateAt() != null ) {
            personResponseDto.setUpdateAt( entity.getUpdateAt().toInstant() );
        }
        personResponseDto.setDeleted( entity.getDeleted() );
        personResponseDto.setId( entity.getId() );
        personResponseDto.setFname( entity.getFname() );
        personResponseDto.setLname( entity.getLname() );
        personResponseDto.setNationalCode( entity.getNationalCode() );

        return personResponseDto;
    }
}
