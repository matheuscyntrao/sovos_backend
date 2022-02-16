package models.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserResponse {
    private Integer id;
    private String name;
    private String gender;
    private String status;
    private String email;
}
