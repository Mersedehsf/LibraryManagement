package org.example.Library.repository;

import org.example.Library.model.entity.BookEntity;
import org.example.Library.model.entity.BorrowEntity;
import org.example.Library.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository

public interface BorrowRepository extends JpaRepository<BorrowEntity,Integer> {

    List<BorrowEntity> findByBookAndReturnDate(BookEntity bookEntity, LocalDate returnDate);
}
