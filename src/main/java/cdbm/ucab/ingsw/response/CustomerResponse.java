package cdbm.ucab.ingsw.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
