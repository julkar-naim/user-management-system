package naim.julkar.usermanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}