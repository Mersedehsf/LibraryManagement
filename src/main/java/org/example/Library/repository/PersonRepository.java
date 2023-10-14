package org.example.Library.repository;

import org.example.Library.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
    PersonEntity findByNationalCode(String nationalCode);//innnnnn esm method darvaghe ye querie



}
