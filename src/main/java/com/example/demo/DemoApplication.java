package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User admin = new User();
		admin.setEmail("admin@gmail.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setRoles(List.of("ROLE_ADMIN"));
		userRepository.save(admin);


		User user = new User();
		user.setEmail("user@gmail.com");
		user.setPassword(passwordEncoder.encode("123456"));
		user.setRoles(List.of("ROLE_USER"));
		userRepository.save(user);
	}
}
