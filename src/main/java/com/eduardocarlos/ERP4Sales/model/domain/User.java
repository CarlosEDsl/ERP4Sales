package com.eduardocarlos.ERP4Sales.model.domain;
import com.eduardocarlos.ERP4Sales.model.enums.ProfileEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity(name = User.TABLE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    public static final String TABLE_NAME = "user";

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "password")
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, max = 120)
    private String password;

    @Column(name = "userlogin", unique = true)
    @NotBlank
    @Size(min = 2, max = 30)
    private String user;

    @Column(name = "profile")
    @NotBlank
    private ProfileEnum profile;

    @Column(name= "state")
    @NotBlank
    private boolean state = true;

    @Column(name = "creation_time")
    private LocalDateTime creation_time = LocalDateTime.now();

    @Column(name = "last_login")
    private LocalDateTime last_login = LocalDateTime.parse("0001-01-01 00:00:00" , DateTimeFormatter.ofPattern("0001-01-01 00:00:00"));

    // Methods

    public void reset(){
        this.state = true;
    }

    public void stateChange(){
        this.state = !this.state;
    }

}
