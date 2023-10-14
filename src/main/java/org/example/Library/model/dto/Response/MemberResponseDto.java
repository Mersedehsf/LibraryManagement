package org.example.Library.model.dto.Response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
//protected kon bebin chi mishe?
public class MemberResponseDto extends PersonResponseDto {
    private String code;

   // private Integer borrow_id;




}
