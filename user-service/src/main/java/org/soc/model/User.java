package org.soc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

@Document("users")
public class User {
    @Id
    private String id;
    private String password;
    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    private String email;

    private String address;
}
