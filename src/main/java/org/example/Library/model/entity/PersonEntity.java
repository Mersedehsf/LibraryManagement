package org.example.Library.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="person",uniqueConstraints={@UniqueConstraint( columnNames = {"nationalCode"})})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity extends BaseEntity {

    protected Boolean deleted = false;
    private String fname;
    private String lname;

    @Column(unique = true,updatable = false,nullable = false)
    private String nationalCode;


}
