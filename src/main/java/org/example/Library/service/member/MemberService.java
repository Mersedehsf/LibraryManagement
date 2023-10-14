package org.example.Library.service.member;


import org.example.Library.model.dto.Request.MemberRequestDto;
import org.example.Library.model.dto.Response.MemberResponseDto;
import org.example.Library.service.BaseService;

public interface MemberService extends BaseService<MemberResponseDto, MemberRequestDto> {
    MemberResponseDto findByNationalCode(String nationalCode);
    //  LibrarianDto findByCode(String code);


    MemberResponseDto findByCode(String code);


}
