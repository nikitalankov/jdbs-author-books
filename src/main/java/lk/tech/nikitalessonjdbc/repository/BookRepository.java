package lk.tech.nikitalessonjdbc.repository;


import lk.tech.nikitalessonjdbc.entity.BookEntity;

import lk.tech.nikitalessonjdbc.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookRepository {


    private final JdbcClient jdbcClient;
    private final BookMapper bookMapper;

    public List<BookEntity> getAll() {
        String sql = """
                select * from books b
                limit :limit 
                offset :offset
                order by b.id :sort
                """;
        return jdbcClient
                .sql(sql)
                .param("limit", 10)
                .param("offset", 0)
                .query(bookMapper)
                .list();
    }

    public Optional<BookEntity> getById(Long id) {
        String sql = """
                select b.* from books b
                where b.id = :id
                """;
        return jdbcClient.sql(sql)
                .param("id", id)
                .query(bookMapper)
                .optional();
    }


    public Optional<BookEntity> putOne(BookEntity bookEntity) {
        String sql = """
                UPDATE books
                SET title = :title,
                    publication_year = :publicationYear,
                    pages = :pages,
                    price = :price,
                    author_id = :authorId
                WHERE id = :id
                RETURNING id, title, publication_year, pages, price, author_id
                """;

        return jdbcClient.sql(sql)
                .paramSource(new BeanPropertySqlParameterSource(bookEntity))
                .query(bookMapper)
                .optional();
    }

    public BookEntity postOne(BookEntity bookEntity) {
        String sql = """
                INSERT INTO books (title, publication_year, pages, price, author_id)
                VALUES (:title, :publicationYear, :pages, :price, :authorId)
                RETURNING id, title, publication_year, pages, price, author_id
                """;

        return jdbcClient.sql(sql)
                .paramSource(new BeanPropertySqlParameterSource(bookEntity))
                .query(bookMapper)
                .single();
    }

    public void deleteOne(Long id) {
        String sql = """
                DELETE FROM books
                WHERE id = :id
                """;
        jdbcClient.sql(sql)
                .param("id", id)
                .update();
    }

    public void deleteAll() {
        String sql = "DELETE FROM books";
        jdbcClient.sql(sql).update();
    }
}
