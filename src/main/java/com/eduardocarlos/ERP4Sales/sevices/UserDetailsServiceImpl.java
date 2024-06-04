package com.eduardocarlos.ERP4Sales.sevices;

import com.eduardocarlos.ERP4Sales.model.domain.User;
import com.eduardocarlos.ERP4Sales.repositories.UserRepository;
import com.eduardocarlos.ERP4Sales.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        User user = userRepository.findByUser(userLogin)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Foun with login: " + userLogin));
        return new UserSpringSecurity(user.getId(), user.getUser(), user.getPassword(), user.getProfiles());
    }
}
