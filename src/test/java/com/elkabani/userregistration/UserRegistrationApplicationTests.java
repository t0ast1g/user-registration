package com.elkabani.userregistration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRegistrationApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        assertNotNull(userService);
    }

    @Test
    void testSuccessfulUserRegistration() {
        User user = new User(1L, "Test User", "test@example.com", "password123");
        
        boolean result = userService.registerUser(user);
        
        assertTrue(result, "User registration should succeed for new user");
    }

    @Test
    void testDuplicateUserRegistration() {
        User user1 = new User(1L, "Duplicate User", "duplicate@example.com", "password123");
        User user2 = new User(2L, "Duplicate User 2", "duplicate@example.com", "password456");
        
        // First registration should succeed
        boolean firstResult = userService.registerUser(user1);
        assertTrue(firstResult, "First user registration should succeed");
        
        // Second registration with same email should fail
        boolean secondResult = userService.registerUser(user2);
        assertFalse(secondResult, "Duplicate user registration should fail");
    }

    @Test
    void testMultipleDifferentUsers() {
        User user1 = new User(1L, "User One", "user1@example.com", "password123");
        User user2 = new User(2L, "User Two", "user2@example.com", "password456");
        User user3 = new User(3L, "User Three", "user3@example.com", "password789");
        
        // All registrations should succeed
        assertTrue(userService.registerUser(user1), "First user should register successfully");
        assertTrue(userService.registerUser(user2), "Second user should register successfully");
        assertTrue(userService.registerUser(user3), "Third user should register successfully");
    }
}
