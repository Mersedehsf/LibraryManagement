package org.example.Library.repository;

import org.example.Library.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {
    List<BookEntity> findByName(String name);

}
