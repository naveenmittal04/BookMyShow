package com.naveenmittal.bookmyshow.services;

import com.naveenmittal.bookmyshow.exceptions.UserAlreadyExistsException;
import com.naveenmittal.bookmyshow.models.User;
import com.naveenmittal.bookmyshow.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public User signUp(String email, String password) throws UserAlreadyExistsException {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new UserAlreadyExistsException();
        }
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);

        User savedUser = userRepository.save(newUser);
        return savedUser;
    }
}
