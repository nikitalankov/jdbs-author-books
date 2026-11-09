package lk.tech.nikitalessonjdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookEntity {
    private Long id;
    private String title;
    private Integer publicationYear;
    private Integer pages;
    private Double price;
    private Long authorId;
}
