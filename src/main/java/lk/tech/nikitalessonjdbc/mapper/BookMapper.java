package lk.tech.nikitalessonjdbc.mapper;

import lk.tech.nikitalessonjdbc.entity.BookEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookMapper implements RowMapper<BookEntity> {

    @Override
    public BookEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return BookEntity.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .publicationYear(rs.getInt("publication_year"))
                .pages(rs.getInt("pages"))
                .price(rs.getDouble("price"))
                .authorId(rs.getLong("author_id"))
                .build();
    }
}
