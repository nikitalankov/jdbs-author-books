package lk.tech.nikitalessonjdbc.mapper;

import lk.tech.nikitalessonjdbc.entity.AuthorEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class AuthorMapper implements RowMapper<AuthorEntity> {

    @Override
    public AuthorEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");

        Date birthDateSQL = rs.getDate("birth_date");
        LocalDate birthDate = birthDateSQL == null ? null : birthDateSQL.toLocalDate();

        String country = rs.getString("country");
        return new AuthorEntity(id, firstName, lastName, birthDate, country);
    }
}
