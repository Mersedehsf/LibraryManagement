package org.example.Library.model.dto.Request;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class LibrarianRequestDto extends PersonRequestDto {

    private String Code;


}
