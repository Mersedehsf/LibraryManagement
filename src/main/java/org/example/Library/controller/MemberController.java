package org.example.Library.controller;

import lombok.AllArgsConstructor;

import org.example.Library.model.dto.Request.MemberRequestDto;
import org.example.Library.model.dto.Response.MemberResponseDto;
import org.example.Library.service.member.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("members")
@AllArgsConstructor

public class MemberController implements BaseController<MemberResponseDto, MemberRequestDto> {
    private final MemberService memberService;

    @Override
    public MemberResponseDto create(MemberRequestDto t) {
        return memberService.create(t);
    }

    @Override
    public List<MemberResponseDto> getAll() {
        return memberService.getAll();
    }

    @Override
    public MemberResponseDto getById(Integer Id) throws Exception {return memberService.getById(Id);
    }
    @Override
    public MemberResponseDto update(MemberRequestDto memberDto) throws Exception {
        return memberService.update(memberDto);
    }

    @GetMapping("/findByCode/{Code}")
    public MemberResponseDto findbyCode(@PathVariable String Code){
        return memberService.findByCode(Code);

    }

    @GetMapping("/findByNationalCode/{nationalCode}")
    public MemberResponseDto findbyNationalCode(@PathVariable String nationalCode){
        return memberService.findByNationalCode(nationalCode);
    }



    @Override
    public void delete(Integer id) {
        memberService.deleteById(id);

    }
}
