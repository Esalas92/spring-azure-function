package com.esalas.azure.dev.springazurefunction;

import com.esalas.azure.dev.springazurefunction.model.Greeting;
import com.esalas.azure.dev.springazurefunction.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class SpringAzureFunctionApplication {
	@Autowired
	private GreetingService greetingService;

	@Bean("getUser")
	public Function<User, User> getUser() {
		return user -> greetingService.getUser(user);
	}

	@Bean("getUsers")
	public Function<Optional<Void>, List<User>> getUsers() {
		return user -> greetingService.getUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAzureFunctionApplication.class, args);
	}
}
