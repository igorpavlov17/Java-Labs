package hibernate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDTO {
    private Long id;
    private String name;
    private String birthDate;
    private String nickName;
}
