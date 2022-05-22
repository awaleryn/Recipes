package recipes.User;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@Table
public class User {

    private static final String emailRegex = "(?i)[\\w!#$%&'*+/=?`{|}~^-]+" +
            "(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-z0-9-]+\\.)+[a-z]{2,6}";

    @Id
    @Email(regexp = emailRegex)
    private String email;

    @NotBlank
    @Size(min = 8, max = 255)
    private String password;

}
