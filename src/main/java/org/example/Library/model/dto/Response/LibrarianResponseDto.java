package org.example.Library.model.dto.Response;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibrarianResponseDto extends PersonResponseDto {

    private String Code;


}
