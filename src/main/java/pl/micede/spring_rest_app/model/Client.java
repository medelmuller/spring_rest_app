package pl.micede.spring_rest_app.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.pl.PESEL;

@Data
public class Client {

    @NotNull
    private String firstName;

    @Size()
    private String lastName;

    @Email
    private String email;

    @Min(9)
    @Max(12)
    private String phoneNumber;

    @Range(min = 1900, max = 2024)
    private Integer birthYear;

    @PESEL
    private String pesel;

    @Email
    private boolean isPremium;
}
