package com.veggietrade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.veggietrade.dto.UserRequestDTO;
import com.veggietrade.model.User;
import com.veggietrade.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserRequestDTO dto) {
        if (userRepository.findByMobileNo(dto.getMobileNo()).isPresent()) {
            throw new RuntimeException("Mobile number already exists");
        }

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPwd(passwordEncoder.encode(dto.getPwd()));
        user.setMobileNo(passwordEncoder.encode(dto.getMobileNo())); // simple encryption
        user.setEmailId(dto.getEmailId());
        return userRepository.save(user);
    }
}