package org.example.Library.model.dto.Request;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.Library.model.dto.BaseDto;


@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PersonRequestDto extends BaseDto {

    private Integer id;
    private String fname;
    private String lname;
    private String nationalCode;
    protected Boolean deleted = false;
}
