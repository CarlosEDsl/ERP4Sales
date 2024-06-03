package com.eduardocarlos.ERP4Sales.sevices;

import com.eduardocarlos.ERP4Sales.model.domain.User;
import com.eduardocarlos.ERP4Sales.model.enums.ProfileEnum;
import com.eduardocarlos.ERP4Sales.repositories.UserRepository;
import com.eduardocarlos.ERP4Sales.sevices.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private UserRepository userRepository;


    public User findById(Long id){

        Optional<User> user = userRepository.findById(id);

        return user
                .orElseThrow(()-> new ObjectNotFoundException(
                    STR."User not found \{id}Type: \{User.class.getName()}"
                ));
    }

    @Transactional
    public User create(User user){
        user.setId(null);
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        user.setProfile(Stream.of(ProfileEnum.DEFAULT.getCode()).collect(Collectors.toSet()));

        return this.userRepository.save(user);
    }

    @Transactional
    public User update(User user) {
        User userUpdated = this.findById(user.getId());
        userUpdated.setName(user.getName());
        userUpdated.setProfile(user.getProfile());
        userUpdated.setState(user.getState());

        userUpdated.setPassword(user.getPassword());
        userUpdated.setPassword(bCryptPasswordEncoder.encode(userUpdated.getPassword()));

        return this.userRepository.save(userUpdated);
    }

    public void delete(User user) {
        findById(user.getId()); //Verification if user exist

        try{
            this.userRepository.delete(user);
        } catch (Exception e){
            System.out.println("Erro ao deletar já que o usuário possuí relacionamentos no banco");
        }

    }

}
