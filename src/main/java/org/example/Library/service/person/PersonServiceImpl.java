package org.example.Library.service.person;

import lombok.AllArgsConstructor;
import org.example.Library.mapper.PersonMapper;

import org.example.Library.model.dto.Request.PersonRequestDto;
import org.example.Library.model.dto.Response.PersonResponseDto;
import org.example.Library.model.entity.PersonEntity;
import org.example.Library.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public List<PersonResponseDto> getAll() {
        List<PersonEntity> personEntities=personRepository.findAll().
                stream().filter(item-> item.getDeleted().equals(false)).collect(Collectors.toList());
        return personEntities.stream().map(personEntity -> personMapper.entityToDto(personEntity)).collect(Collectors.toList());

    }

    @Override
    public PersonResponseDto getById(Integer id) throws Exception {
        PersonEntity personEntity=personRepository.findById(id).orElseThrow(Exception::new);
        if (personEntity.getDeleted().equals(true)) {
            return null;
        }
        else{
            return personMapper.entityToDto(personEntity);
        }
    }

    @Override
    public PersonResponseDto create(PersonRequestDto items) {
        PersonEntity personEntity=personMapper.dtoToEntity(items);
        personEntity.setCreationTime(null);
        return personMapper.entityToDto(personRepository.save(personEntity));
    }


    @Override
    public PersonResponseDto update(PersonRequestDto items) throws Exception {
        PersonEntity personEntity=personRepository.findById(items.getId()).orElseThrow();
        if (personEntity.getDeleted().equals(false)){
        personEntity.setUpdateAt(new Date());

        if (items.getFname()!=null){
        personEntity.setFname(personEntity.getFname());}

        if (items.getLname()!=null){
        personEntity.setLname(items.getLname());}
        if (items.getNationalCode()!=null){
            throw new RuntimeException("nationalCode cannot be updated");
        }
        personEntity.setNationalCode(personEntity.getNationalCode());
        PersonResponseDto personDto= personMapper.entityToDto(personRepository.save(personEntity));
        return personDto;}
        else {
            return null;
        }

    }

    @Override
    public void deleteById(Integer Id) {
        PersonEntity personEntity=personRepository.findById(Id).orElseThrow();
        personEntity.setDeleted(true);
        personRepository.save(personEntity);


    }

    public PersonResponseDto findByNationalCode(String nationalCode){
        PersonEntity personEntity=personRepository
                .findByNationalCode(nationalCode);
        if (personEntity.getDeleted().equals(false)){
            return personMapper.entityToDto(personEntity);
        }
        else {
            return null;
        }


    }
}
