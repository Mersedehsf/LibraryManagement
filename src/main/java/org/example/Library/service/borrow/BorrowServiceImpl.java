package org.example.Library.service.borrow;


import lombok.AllArgsConstructor;
import org.example.Library.mapper.BorrowMapper;

import org.example.Library.model.dto.Request.BorrowRRequestDto;
import org.example.Library.model.entity.BookEntity;
import org.example.Library.model.entity.BorrowEntity;
import org.example.Library.repository.BookRepository;
import org.example.Library.repository.BorrowRepository;
import org.example.Library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public void giveBook(BorrowRRequestDto borrowDto) throws Exception {
        bookRepository.findById(borrowDto.getBook().getId()).orElseThrow();
        memberRepository.findById(borrowDto.getMember().getId()).orElseThrow();
        BorrowEntity borrowEntity = borrowMapper.dtoToEntity(borrowDto);

        BookEntity wantedBook=bookRepository.findById(borrowDto.getBook().getId()).orElseThrow();

        if (wantedBook.getNumbers()>0) {
            wantedBook.setNumbers(wantedBook.getNumbers() - 1);
            bookRepository.save(wantedBook);
            //harvaght bargardoonan por mishe in field
            //age khali bood yani barnagardoonde
            List<BorrowEntity> resultList = borrowRepository
                    .findByBookAndReturnDate(borrowEntity.getBook(), null);//ye ketab peyda shode ke barnagardoondan
            if ((resultList).size() > 0) {
                throw new RuntimeException();
            } else {
                BorrowEntity borrowEntity1 = new BorrowEntity(LocalDate.now(), LocalDate.now().plusDays(10), null, borrowEntity.getBook(), borrowEntity.getMember());
                borrowRepository.save(borrowEntity1);
            }
        }
        else{
            throw new IllegalStateException();
        }
    }

    public void returnBook(BorrowRRequestDto borrowDto) throws Exception {
        BookEntity bookEntity= bookRepository.findById(borrowDto.getBook().getId()).orElseThrow(Exception::new);
        memberRepository.findById(borrowDto.getMember().getId()).orElseThrow(Exception::new);
        BookEntity wantedBook=bookRepository.findById(borrowDto.getBook().getId()).orElseThrow();
        wantedBook.setNumbers(wantedBook.getNumbers()+1);
        bookRepository.save(wantedBook);

        List<BorrowEntity> borrowEntities = borrowRepository.findByBookAndReturnDate(bookEntity, null);
        if (borrowEntities.isEmpty()) {//in ketab ba in id asan gharz gerefte nashode
            throw new RuntimeException();
        } else {//in ketab ba in id gharz gerefte shode chon returnDate nadaremhala vaghteshe ketabo bargardoone va raturn datesh por she
            borrowEntities.get(0).setReturnDate(LocalDate.now());
            borrowEntities.get(0).getBook().setAvailable(true);
            borrowRepository.save(borrowEntities.get(0));

        }


    }

}
