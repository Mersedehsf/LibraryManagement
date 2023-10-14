package org.example.Library.service.book;

import lombok.AllArgsConstructor;
import org.example.Library.mapper.BookMapper;

import org.example.Library.model.dto.Request.BookRequestDto;
import org.example.Library.model.dto.Response.BookResponseDto;
import org.example.Library.model.entity.BookEntity;
import org.example.Library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;



    @Override
    public BookResponseDto create(BookRequestDto items) {
        BookEntity bookEntity = bookMapper.dtoToEntity(items);
        bookEntity.setUpdateAt(null);
        bookRepository.save(bookEntity);
        BookResponseDto bookDto = bookMapper.entityToDto(bookEntity);
        return bookDto;
    }

    @Override
    public List<BookResponseDto> getAll() {
        List<BookEntity> bookEntities = bookRepository.findAll().
                stream().filter(item -> item.getDeleted().equals(false))
                .collect(Collectors.toList());
        List<BookResponseDto> bookDtos = bookEntities.stream().map(item ->
                        bookMapper.entityToDto(item))
                .collect(Collectors.toList());
        return bookDtos;

    }

    @Override
    public BookResponseDto getById(Integer id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow();
        if (bookEntity.getDeleted().equals(true)) {
            return null;
        }
        return bookMapper.entityToDto(bookEntity);
    }

    @Override
    public BookResponseDto update(BookRequestDto item) {
        BookEntity existed = bookRepository.getById(item.getId());
        if (existed.getDeleted().equals(false)) {
            if (item.getName()==null){
                existed.setName(existed.getName());
            }
            if (!item.getNumbers().equals(null)){
                existed.setNumbers(item.getNumbers());
            }
            bookRepository.save(existed);
            return bookMapper.entityToDto(existed);
        } else {
            return null;
        }

    }

    @Override
    public void deleteById(Integer id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow();
        if (bookEntity.getDeleted().equals(false)) {
            bookEntity.setDeleted(true);
            bookRepository.save(bookEntity);
        }

    }

    @Override
    public List<BookResponseDto> findByName(String name) {
        List<BookEntity> bookEntity = bookRepository.findByName(name);
        return bookEntity.stream().filter(bookEntity1 -> bookEntity1.getDeleted().equals(false))
                .map(item->bookMapper.entityToDto(item)).collect(Collectors.toList());
    }

}
