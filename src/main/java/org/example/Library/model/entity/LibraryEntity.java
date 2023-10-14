package org.example.Library.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libraries")

public class LibraryEntity extends BaseEntity{

    @Column(name="library_name")//esm to database
    private String name;

    @OneToMany(mappedBy = "library",cascade = CascadeType.ALL)
    private List<BookEntity> books;//new arraylist kardam dorost shod
    //age null bood barname be exception nakhore






}
