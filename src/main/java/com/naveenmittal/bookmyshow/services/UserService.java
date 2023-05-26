package com.naveenmittal.bookmyshow.services;

import com.naveenmittal.bookmyshow.exceptions.InvalidPasswordException;
import com.naveenmittal.bookmyshow.exceptions.UserAlreadyExistsException;
import com.naveenmittal.bookmyshow.exceptions.UserNotFoundException;
import com.naveenmittal.bookmyshow.models.User;
import com.naveenmittal.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User signUp(String email, String password) throws UserAlreadyExistsException {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new UserAlreadyExistsException();
        }
        User newUser = new User();
        newUser.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        newUser.setPassword(bCryptPasswordEncoder.encode(password));

        User savedUser = userRepository.save(newUser);
        return savedUser;
    }

    public User SignIn(String email, String password) throws UserNotFoundException, InvalidPasswordException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException();
        }
        User user = userOptional.get();

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
        	throw new InvalidPasswordException();
        }

        return user;
    }
}
