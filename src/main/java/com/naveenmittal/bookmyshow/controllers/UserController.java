package com.naveenmittal.bookmyshow.controllers;

import com.naveenmittal.bookmyshow.dtos.ResponseStatus;
import com.naveenmittal.bookmyshow.dtos.SignUpRequestDto;
import com.naveenmittal.bookmyshow.dtos.SignUpResponseDto;
import com.naveenmittal.bookmyshow.models.User;
import com.naveenmittal.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();

        try{
            User user =  userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
            signUpResponseDto.setUserId(user.getId());
            signUpResponseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            signUpResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return signUpResponseDto;
    }
}
