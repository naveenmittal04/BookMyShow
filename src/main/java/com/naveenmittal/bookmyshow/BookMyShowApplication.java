package com.naveenmittal.bookmyshow;

import com.naveenmittal.bookmyshow.controllers.UserController;
import com.naveenmittal.bookmyshow.dtos.SignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

	@Autowired
	UserController userController;
	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
		signUpRequestDto.setEmail("naveenmittal04@gmail.com");
		signUpRequestDto.setPassword("password");
		userController.signUp(signUpRequestDto);
	}
}
