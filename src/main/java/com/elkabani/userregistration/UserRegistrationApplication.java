package com.elkabani.userregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserRegistrationApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(UserRegistrationApplication.class, args);
        var userService = context.getBean(UserService.class);
        
        System.out.println("=== Testing User Registration System ===");
        System.out.println();
        
        // Register first user
        System.out.println("1. Registering first user:");
        userService.registerUser(new User(1L, "John Doe",  "jdoe@example.com", "password123"));
        System.out.println();
        
        // Register second user
        System.out.println("2. Registering second user:");
        userService.registerUser(new User(2L, "Jane Smith",  "jsmith@example.com", "password456"));
        System.out.println();
        
        // Attempt to register duplicate user
        System.out.println("3. Attempting to register duplicate user:");
        userService.registerUser(new User(3L, "John Doe",  "jdoe@example.com", "password123"));
        System.out.println();
        
        System.out.println("=== Registration System Test Complete ===");
    }

}
