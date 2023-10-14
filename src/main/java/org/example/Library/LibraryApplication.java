package org.example.Library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//to anjam in proje ha hame package ha bayad too ham bashe
@SpringBootApplication
@EnableJpaAuditing
public class LibraryApplication  {
    public static void main(String[] args) {
//        Transaction txn = null;
        SpringApplication.run(LibraryApplication.class, args);
//
//        try (SessionFactory sf = SessionFactoryProvider.getSessionFactory();
//             Session session = sf.openSession();
//        ) {
//
//            txn = session.beginTransaction();
//            //--------------------------
//            PersonEntity person=new PersonEntity();
//            LibrarianEntity librarian=new LibrarianEntity();
//
//            session.save(person);
//            session.save(librarian);
//
//            //--------------------------
//            txn.commit();
//
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            txn.rollback();
//        }


    }




}