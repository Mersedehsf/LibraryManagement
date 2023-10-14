package org.example.Library.mapper;

import java.util.Date;
import javax.annotation.processing.Generated;
import org.example.Library.model.dto.Request.MemberRequestDto;
import org.example.Library.model.dto.Response.MemberResponseDto;
import org.example.Library.model.entity.MemberEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-27T16:00:45+0330",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberEntity dtoToEntity(MemberRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setId( dto.getId() );
        if ( dto.getCreationTime() != null ) {
            memberEntity.setCreationTime( Date.from( dto.getCreationTime() ) );
        }
        if ( dto.getUpdateAt() != null ) {
            memberEntity.setUpdateAt( Date.from( dto.getUpdateAt() ) );
        }
        memberEntity.setDeleted( dto.getDeleted() );
        memberEntity.setFname( dto.getFname() );
        memberEntity.setLname( dto.getLname() );
        memberEntity.setNationalCode( dto.getNationalCode() );
        memberEntity.setCode( dto.getCode() );

        return memberEntity;
    }

    @Override
    public MemberResponseDto entityToDto(MemberEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MemberResponseDto memberResponseDto = new MemberResponseDto();

        if ( entity.getCreationTime() != null ) {
            memberResponseDto.setCreationTime( entity.getCreationTime().toInstant() );
        }
        if ( entity.getUpdateAt() != null ) {
            memberResponseDto.setUpdateAt( entity.getUpdateAt().toInstant() );
        }
        memberResponseDto.setDeleted( entity.getDeleted() );
        memberResponseDto.setId( entity.getId() );
        memberResponseDto.setFname( entity.getFname() );
        memberResponseDto.setLname( entity.getLname() );
        memberResponseDto.setNationalCode( entity.getNationalCode() );
        memberResponseDto.setCode( entity.getCode() );

        return memberResponseDto;
    }
}
