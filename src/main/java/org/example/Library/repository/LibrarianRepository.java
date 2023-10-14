package org.example.Library.repository;

import org.example.Library.model.entity.LibrarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<LibrarianEntity,Integer> {

    LibrarianEntity findByNationalCode(String nationalCode);//slellesh moheme to repository
    LibrarianEntity findByCode(String code);//splelles moheme to repository
   //spellesh moheme to repository


}
