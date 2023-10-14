package org.example.Library.service.librarian;


import lombok.AllArgsConstructor;
import org.example.Library.mapper.LibrarianMapper;

import org.example.Library.model.dto.Request.LibrarianRequestDto;
import org.example.Library.model.dto.Response.LibrarianResponseDto;
import org.example.Library.model.entity.LibrarianEntity;
import org.example.Library.repository.LibrarianRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class librarianServiceImpl implements LibrarianService {

    private final LibrarianRepository librarianRepository;

    private final LibrarianMapper librarianMapper;


    @Override
    public List<LibrarianResponseDto> getAll() {
        List<LibrarianEntity> librarianEntities=
                librarianRepository.findAll().stream().filter(item-> item.getDeleted().equals(false))
                        .collect(Collectors.toList());
        return librarianEntities.stream().map(librarianEntity ->
                librarianMapper.entityToDto(librarianEntity)).collect(Collectors.toList());
    }

    @Override
    public LibrarianResponseDto getById(Integer id) {
        LibrarianEntity librarianEntity=librarianRepository.findById(id).orElseThrow();
        if (librarianEntity.getDeleted().equals(false)){
        return librarianMapper.entityToDto(librarianEntity);}
        else{
            return null;
        }
    }

    @Override
    public LibrarianResponseDto create(LibrarianRequestDto items) {
        LibrarianEntity librarianEntity=librarianMapper.dtoToEntity(items);
        librarianEntity.setUpdateAt(null);
        librarianRepository.save(librarianEntity);
        return librarianMapper.entityToDto(librarianEntity);
    }


    @Override
    public LibrarianResponseDto update(LibrarianRequestDto items) {//vaghean ravesh behtari bare update voojood nadare?
        LibrarianEntity librarianEntity=librarianRepository.findById(items.getId()).orElseThrow();
        if (librarianEntity.getDeleted().equals(false)) {
            librarianEntity.setUpdateAt(new Date());
          //  librarianEntity.setNationalCode(items.getNationalCode());
            librarianEntity.setCode(items.getCode());
            librarianRepository.save(librarianEntity);
            return librarianMapper.entityToDto(librarianEntity);
        }
        else{
            return null;
        }

    }

    @Override
    public void deleteById(Integer id) {
        LibrarianEntity librarianEntity=librarianRepository.findById(id).orElseThrow();
        librarianEntity.setDeleted(true);
        librarianRepository.save(librarianEntity);

    }

    @Override
    public LibrarianResponseDto findByNationalCode(String nationalCode) {
        LibrarianEntity librarianEntities=librarianRepository.findByNationalCode(nationalCode);
        if (librarianEntities.getDeleted().equals(false)){
            return librarianMapper.entityToDto(librarianEntities);
        }
        return null;
    }

    @Override
    public LibrarianResponseDto findByCode(String code) {
        LibrarianEntity librarianEntity = librarianRepository.findByCode(code);
        if (librarianEntity.getDeleted().equals(false)) {
            return librarianMapper.entityToDto(librarianEntity);
        } else {
            return null;
        }
    }


}
