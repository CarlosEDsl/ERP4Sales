package com.eduardocarlos.ERP4Sales.model.domain;
import com.eduardocarlos.ERP4Sales.model.enums.ProfileEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Column(name = "password", nullable = false)
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, max = 120)
    private String password;

    @Column(name = "userlogin", unique = true, nullable = false)
    @NotBlank
    @Size(min = 2, max = 30)
    private String user;

    @Column(name = "profile", nullable = false)
    @NotBlank
    private ProfileEnum profile;

    @Column(name= "state", nullable = false)
    @NotBlank
    private boolean state = true;

    @CreationTimestamp
    @Column(name = "creation_time", nullable = false, updatable = false)
    private LocalDateTime creationTime;

    @Column(name = "last_login")
    private LocalDateTime lastLogin = LocalDateTime.of(1, 1, 1, 0, 0);

    // Methods

    public void reset(){
        this.state = true;
    }

    public void stateChange(){
        this.state = !this.state;
    }

}
