package org.example.Library.model.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Library.model.dto.BaseDto;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//vaghti baseDto ro extend mikonam khataye media type mide chera

public class BookRequestDto extends BaseDto {

    @NotBlank
    private String name;
    private Integer numbers;

    private LibraryRequestDto library;
    private boolean available;



}
