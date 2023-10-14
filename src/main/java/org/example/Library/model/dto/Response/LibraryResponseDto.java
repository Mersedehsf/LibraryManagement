package org.example.Library.model.dto.Response;

import lombok.*;
import org.example.Library.model.dto.BaseDto;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LibraryResponseDto extends BaseDto {

    private String name;

}
