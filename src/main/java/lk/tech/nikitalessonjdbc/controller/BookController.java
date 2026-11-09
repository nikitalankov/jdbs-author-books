package lk.tech.nikitalessonjdbc.controller;

import lk.tech.nikitalessonjdbc.entity.BookEntity;
import lk.tech.nikitalessonjdbc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public List<BookEntity> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookEntity> getById(@PathVariable Long id) {
        return bookService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/books")
    public ResponseEntity<BookEntity> putOne(@RequestBody BookEntity bookEntity) {
        return bookService.putOne(bookEntity)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/books")
    public ResponseEntity<BookEntity> postOne(@RequestBody BookEntity bookEntity) {
        BookEntity createdBook = bookService.postOne(bookEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable Long id) {
        bookService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/books")
    public ResponseEntity<Void> deleteAll() {
        bookService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
