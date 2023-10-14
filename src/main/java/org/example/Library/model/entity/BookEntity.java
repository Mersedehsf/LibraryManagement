package org.example.Library.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")

public class BookEntity extends BaseEntity {
    @Column(name = "book_name")
    private String name;

    private Integer numbers;

    private boolean available = true;

    @ManyToOne
    @JoinColumn(name = "library_id")//ye column ezafe baraye foregin keyshe
    private LibraryEntity library;


    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BorrowEntity> borrowEntities = new ArrayList<>();


}
