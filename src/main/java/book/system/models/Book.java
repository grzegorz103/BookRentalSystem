package book.system.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "author", length = 50)
    @NotBlank
    private String author;

    @Column(name = "title", length = 100)
    @NotBlank
    private String title;

    @NotNull
    private LocalDate publishDate;

    @Column(name = "page_number")
    @Positive
    @NotNull
    private Integer pageNumber;

    @Column(name = "borrowed")
    private boolean borrowed;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Rental> rental;
}
