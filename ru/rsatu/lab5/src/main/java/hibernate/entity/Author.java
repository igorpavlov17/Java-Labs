package hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "authors_id_gen")
    @SequenceGenerator(name = "authors_id_gen",
            sequenceName = "authors_id_gen_seq",
            initialValue = 1,
            allocationSize = 10)
    private Long id; //автогенерируемый
    private String name;
    private Date birthDate;
    private String nickName;
}
