package org.example.Library.service.member;

import lombok.AllArgsConstructor;
import org.example.Library.mapper.MemberMapper;

import org.example.Library.model.dto.Request.MemberRequestDto;
import org.example.Library.model.dto.Response.MemberResponseDto;
import org.example.Library.model.entity.MemberEntity;
import org.example.Library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    @Override
    public List<MemberResponseDto> getAll() {
        List<MemberEntity> memberEntities=memberRepository.findAll();
        return memberEntities.stream().filter(item-> item.getDeleted().equals(false)).map(memberEntity ->memberMapper.entityToDto(memberEntity)).collect(Collectors.toList());
    }

    @Override
    public MemberResponseDto getById(Integer id) {
        MemberEntity memberEntity=memberRepository.getById(id);
        if(memberEntity.getDeleted().equals(false)){
            return memberMapper.entityToDto(memberEntity);
        }
        else{
            return null;

        }
    }
    @Override
    public MemberResponseDto create(MemberRequestDto items) {
        MemberEntity memberEntity=memberMapper.dtoToEntity(items);
        memberEntity.setUpdateAt(null);
        memberRepository.save(memberEntity);
        return memberMapper.entityToDto(memberEntity);
    }



    @Override
    public MemberResponseDto update(MemberRequestDto items) {
        MemberEntity memberEntity=memberRepository.findById(items.getId()).orElseThrow();
        if (memberEntity.getDeleted().equals(false)) {
            memberEntity.setCode(items.getCode());
            memberEntity.setNationalCode(items.getNationalCode());
            memberRepository.save(memberEntity);
            return memberMapper.entityToDto(memberEntity);
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        MemberEntity memberEntity=memberRepository.findById(id).orElseThrow();
        memberEntity.setDeleted(true);
        memberRepository.save(memberEntity);

    }

    @Override
    public MemberResponseDto findByNationalCode(String nationalCode) {
        MemberEntity memberEntities=memberRepository.findByNationalCode(nationalCode);
        if (memberEntities.getDeleted().equals(false)){
            return memberMapper.entityToDto(memberEntities);
        }
        else{
            return null;
        }
    }

    @Override
    public MemberResponseDto findByCode(String code) {
        MemberEntity memberEntities=memberRepository.getByCode(code);
        if (memberEntities.getDeleted().equals(false)){
            return memberMapper.entityToDto(memberEntities);
        }
        else{
            return null;
        }
    }
}
