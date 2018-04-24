package cdbm.ucab.ingsw.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@ToString
public class Customer implements Serializable {

    @Id
    private long id;

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Date lastUpdated = new Date();
    private Date dateCreated = new Date();
    private String uuid = UUID.randomUUID().toString();
}
