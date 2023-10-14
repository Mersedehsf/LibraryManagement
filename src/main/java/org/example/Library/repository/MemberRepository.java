package org.example.Library.repository;

import org.example.Library.model.entity.LibrarianEntity;
import org.example.Library.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Integer> {

    MemberEntity getByCode(String code);

    MemberEntity  findByNationalCode(String nationalCode);//spellesh moheme to repository

}
