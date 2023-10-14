package org.example.Library.service.library;



import lombok.AllArgsConstructor;
import org.example.Library.mapper.BookMapper;
import org.example.Library.mapper.LibraryMapper;

import org.example.Library.model.dto.Request.LibraryRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.model.dto.Response.LibraryResponseDto;
import org.example.Library.model.entity.BookEntity;
import org.example.Library.model.entity.LibraryEntity;
import org.example.Library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    private final LibraryMapper libraryMapper;

    private final BookMapper bookMapper;


    @Override
    public LibraryResponseDto create(LibraryRequestDto items) {
        //dto->entity=>save
        //entity->sto=>return
        LibraryEntity libraryEntity=libraryMapper.dtoToEntity(items);
       libraryEntity.setUpdateAt(null);
       libraryRepository.save(libraryEntity);
        LibraryResponseDto libraryDto= libraryMapper.entityToDto(libraryEntity);
        return libraryDto;
    }


    @Override
    public List<LibraryResponseDto> getAll() {
            List<LibraryEntity> entities=libraryRepository.findAll().stream().filter(item-> item.getDeleted().equals(false))
                    .collect(Collectors.toList());
            List<LibraryResponseDto> dtos=
                    entities.stream().map(item->libraryMapper.entityToDto(item)).collect(Collectors.toList());
            return dtos;

    }

    @Override
    public LibraryResponseDto getById(Integer id) {
        LibraryEntity libraryEntity=libraryRepository.findById(id).orElseThrow();
        if (libraryEntity.getDeleted().equals(true)){
            return null;
        }
        return libraryMapper.entityToDto(libraryEntity);
    }

    @Override
    public LibraryResponseDto update(LibraryRequestDto items) {
        LibraryEntity libraryEntity=libraryRepository.findById(items.getId()).orElseThrow();
        if (libraryEntity.getDeleted().equals(false)) {
            libraryEntity.setName(items.getName());
            libraryEntity.setUpdateAt(new Date());
            libraryRepository.save(libraryEntity);
            return libraryMapper.entityToDto(libraryEntity);
        }
        else{
            return null;
        }

    }


    public void deleteById(Integer id) {
        LibraryEntity libraryEntity=libraryRepository.findById(id).orElseThrow();
        libraryEntity.setDeleted(true);
        libraryRepository.save(libraryEntity);

    }

    @Override
    public LibraryResponseDto findByName(String name) {
        LibraryEntity libraryEntity=libraryRepository.findByName(name);
        if (libraryEntity.getDeleted().equals(false)){
            return libraryMapper.entityToDto(libraryEntity);
        }
        return null;
    }

    @Override
    public List<BookResponseDto> getLibraryAllBooks(Integer id){
        LibraryEntity libraryEntity=libraryRepository.findById(id).orElseThrow();
        List<BookEntity> bookEntities=libraryEntity.getBooks().stream().
                filter(item-> item.getDeleted().equals(false)).
                collect(Collectors.toList());
        List<BookResponseDto> bookDtos=bookEntities.stream().map(item->bookMapper.entityToDto(item)).collect(Collectors.toList());
        return bookDtos;

    }

    }

