package models.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateUserRequest {
    private String name;
    private String gender;
    private String status;
    private String email;

    @Override
    public String toString() {
        return "{ \"name\" : \""+name+"\", \"gender\" : \""+gender+"\", \"status\" : \""+status+"\", \"email\" : \""+email+"\" }";
    }
}
