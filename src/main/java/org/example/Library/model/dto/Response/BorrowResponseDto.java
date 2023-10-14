package org.example.Library.model.dto.Response;

import lombok.*;
import org.example.Library.model.dto.BaseDto;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class BorrowResponseDto extends BaseDto {
    private Integer id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private BookResponseDto book;

    private MemberResponseDto member;






}
