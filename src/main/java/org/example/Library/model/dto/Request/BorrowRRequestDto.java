package org.example.Library.model.dto.Request;

import lombok.*;
import org.example.Library.model.dto.BaseDto;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class BorrowRRequestDto extends BaseDto {

    private Integer id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private BookRequestDto book;

    private MemberRequestDto member;






}
