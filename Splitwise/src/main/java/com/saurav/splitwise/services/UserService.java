package com.saurav.splitwise.services;

import com.saurav.splitwise.model.User;
import com.saurav.splitwise.repositories.UserRepository;
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

    public User registerUser(String userName, String phoneNumber, String password) {
        User user = new User();
        user.setUsername(userName);
        user.setPhoneNumber(phoneNumber);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public void login(String userName, String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<User> optionalUser = this.userRepository.findByUsername(userName);
        if (optionalUser.isEmpty()) {
            System.out.println("User doesn;t exist");
            return;
        }
        User user = optionalUser.get();
        if (encoder.matches(rawPassword, user.getPassword())) {
            // login the user
        } else {
            // show error to the user
        }

    }
}
