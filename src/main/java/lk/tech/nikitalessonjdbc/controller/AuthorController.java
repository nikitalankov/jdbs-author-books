package lk.tech.nikitalessonjdbc.controller;

import lk.tech.nikitalessonjdbc.entity.AuthorEntity;
import lk.tech.nikitalessonjdbc.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorEntity> authors(@PathVariable long id) {
        return authorService.getAuthor(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/authors")
    public List<AuthorEntity> authors() {
        return authorService.getAuthors();
    }
}
