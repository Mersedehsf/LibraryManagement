package org.example.Library.repository;



import org.example.Library.model.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//mafhoom reporitory khodesh tahe generice,generic tar nemishe--t.s
public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {
    LibraryEntity findByName(String name);

}
