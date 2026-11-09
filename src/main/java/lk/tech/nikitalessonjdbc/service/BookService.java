package lk.tech.nikitalessonjdbc.service;

import lk.tech.nikitalessonjdbc.entity.BookEntity;
import lk.tech.nikitalessonjdbc.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private  final BookRepository bookRepository;

    public List<BookEntity> getAll() {
return bookRepository.getAll();
    }

    public Optional<BookEntity> getById(Long id) {
return bookRepository.getById(id);
    }

    public Optional<BookEntity> putOne(BookEntity bookEntity) {
return bookRepository.putOne(bookEntity);
    }

    public BookEntity postOne(BookEntity bookEntity) {
return bookRepository.postOne(bookEntity);
    }

    public void deleteOne(Long id) {
        bookRepository.deleteOne(id);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
