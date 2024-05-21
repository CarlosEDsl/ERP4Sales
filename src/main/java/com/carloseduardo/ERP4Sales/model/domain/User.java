package com.carloseduardo.ERP4Sales.model.domain;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
    private String password;
    private String user;
    private Role role;
    private boolean state;
    private LocalDateTime creation_time;
    private LocalDateTime last_login;

}
