package lk.tech.nikitalessonjdbc.repository;

import lk.tech.nikitalessonjdbc.entity.AuthorEntity;
import lk.tech.nikitalessonjdbc.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthorRepository {

    private final JdbcClient jdbcClient;
    private final AuthorMapper authorMapper;

    public Optional<AuthorEntity> getAuthor(long id) {
        String sql = """
                select a.* from authors a
                where a.id = :id
                """;
        return jdbcClient.sql(sql)
                .param("id", id)
                .query(authorMapper)
                .optional();
    }

    public List<AuthorEntity> getAuthors() {
        String sql = """
                select * from authors a
                limit :limit
                offset :offset
                order by a.id :sort
                """;
        return jdbcClient
                .sql(sql)
                .param("limit", 10)
                .param("offset", 0)
                .query(authorMapper)
                .list();
    }
}
