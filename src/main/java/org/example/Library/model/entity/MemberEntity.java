package org.example.Library.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")

public class MemberEntity extends PersonEntity{


    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<BorrowEntity> borrowEntities=new ArrayList<>();


}
