package com.eduardocarlos.ERP4Sales.security;

import com.eduardocarlos.ERP4Sales.model.enums.ProfileEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class UserSpringSecurity implements UserDetails {

    private Long id;
    private String userLogin;
    private String password;
    private Collection<? extends GrantedAuthority> auth;

    public UserSpringSecurity(Long id, String userLogin, String password, Set<ProfileEnum> profileEnumSet){

        this.id = id;
        this.userLogin = userLogin;
        this.password = password;
        this.auth = profileEnumSet.stream().map(x -> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return auth;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userLogin;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
