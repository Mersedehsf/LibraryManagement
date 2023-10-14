package org.example.Library.model.dto.Request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
//protected kon bebin chi mishe?
public class MemberRequestDto extends PersonRequestDto {
    private String code;

   // private Integer borrow_id;




}
