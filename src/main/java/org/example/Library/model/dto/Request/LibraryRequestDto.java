package org.example.Library.model.dto.Request;

import lombok.*;
import org.example.Library.model.dto.BaseDto;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LibraryRequestDto extends BaseDto {

    private String name;

}
