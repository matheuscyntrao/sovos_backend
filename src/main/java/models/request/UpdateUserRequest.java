package models.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserRequest {
    private String name;
    private String status;
    private String email;

    @Override
    public String toString() {
        return "{ \"name\" : \""+name+"\", \"status\" : \""+status+"\", \"email\" : \""+email+"\" }";
    }
}
