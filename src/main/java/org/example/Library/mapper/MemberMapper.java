package org.example.Library.mapper;


import org.example.Library.model.dto.Request.MemberRequestDto;
import org.example.Library.model.dto.Response.MemberResponseDto;
import org.example.Library.model.entity.MemberEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))

public interface MemberMapper extends BaseMapper<MemberEntity, MemberResponseDto, MemberRequestDto>{
}
