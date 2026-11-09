package lk.tech.nikitalessonjdbc.service;

import lk.tech.nikitalessonjdbc.entity.AuthorEntity;
import lk.tech.nikitalessonjdbc.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public Optional<AuthorEntity> getAuthor(long id) {
        return repository.getAuthor(id);
    }

    public List<AuthorEntity> getAuthors() {
        return repository.getAuthors();
    }
}
