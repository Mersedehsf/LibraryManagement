package org.example.Library.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="librarian")

public class LibrarianEntity extends PersonEntity{
    //vaghti extend kardam va nationalCode ro comment kardam dige to postman
    //nationalcodam ro null set nakard

    @Column(unique = true)
    private String code;//in bayad koochick bashe too repository khodesh camelCase mikonoe bozorgesh mikone
   // private String nationalCode;


}
