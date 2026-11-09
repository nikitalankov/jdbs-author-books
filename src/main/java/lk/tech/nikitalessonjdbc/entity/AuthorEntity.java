package lk.tech.nikitalessonjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String country;
}
