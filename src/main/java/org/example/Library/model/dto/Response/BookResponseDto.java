package org.example.Library.model.dto.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.Library.model.dto.BaseDto;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//vaghti baseDto ro extend mikonam khataye media type mide chera

public class BookResponseDto extends BaseDto {

    @NotBlank
    private String name;
    private Integer numbers;

    private LibraryResponseDto library;
    private boolean available;



}
