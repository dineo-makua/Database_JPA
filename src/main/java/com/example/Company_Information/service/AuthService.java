package com.example.Company_Information.service;

import com.example.Company_Information.entity.User;
import com.example.Company_Information.repository.UserRepository;
import com.example.Company_Information.security.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public String register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "Username already taken.";
        }

        try {
            String salt = PasswordUtil.generateSalt();
            String hash = PasswordUtil.hashPassword(password, salt);

            User user = new User();
            user.setUsername(username);
            user.setSalt(salt);
            user.setPasswordHash(hash);

            userRepository.save(user);
            return "User registered successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Registration failed: " + e.getMessage();
        }
    }

    public String login(String username, String password) {
        return userRepository.findByUsername(username).map(user -> {
            try {
                String computedHash = PasswordUtil.hashPassword(password, user.getSalt());
                if (computedHash.equals(user.getPasswordHash())) {
                    return "Login successful.";
                } else {
                    return "Invalid password.";
                }
            } catch (Exception e) {
                return "Login failed: " + e.getMessage();
            }
        }).orElse("User not found.");
    }
}
