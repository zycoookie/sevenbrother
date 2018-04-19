package me.sevenbrother.server.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private int id;
    private String firstName;
    private String lastName;
}
