package org.example.Library.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="borrow")

public class BorrowEntity extends BaseEntity{


    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;


    @ManyToOne
    @JoinColumn(name="book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name="member_id")
    private MemberEntity member;


    public BorrowEntity(LocalDate startDate,LocalDate endDate, LocalDate returnDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;

    }



}
