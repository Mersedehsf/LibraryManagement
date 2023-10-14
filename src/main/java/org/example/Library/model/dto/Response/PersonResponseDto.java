package org.example.Library.model.dto.Response;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;
import org.example.Library.model.dto.BaseDto;


@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonResponseDto extends BaseDto {

    private Integer id;
    private String fname;
    private String lname;
    private String nationalCode;
    protected Boolean deleted = false;
}
