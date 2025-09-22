package com.elkabani.userregistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private NotificationService notificationService;
    
    public boolean registerUser(User user) {
        // Check if user already exists
        User existingUser = userRepository.findByEmail(user.getEmail());
        
        if (existingUser != null) {
            System.out.println("Registration failed: User with email " + user.getEmail() + " already exists!");
            return false;
        }
        
        // Save the new user
        userRepository.save(user);
        
        // Send confirmation notification
        String message = "Welcome " + user.getName() + "! Your registration was successful.";
        notificationService.send(message, user.getEmail());
        
        System.out.println("User " + user.getName() + " registered successfully!");
        return true;
    }
}
