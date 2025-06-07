package com.veggietrade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.veggietrade.dto.UserRequestDTO;
import com.veggietrade.model.User;
import com.veggietrade.repository.UserRepository;

@Service
public class UserService  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserRequestDTO dto) {
        if (userRepository.findByMobileNo(passwordEncoder.encode(dto.getMobileNo())).isPresent()) {
            throw new RuntimeException("Mobile number already exists");
        }

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPwd(passwordEncoder.encode(dto.getPwd()));
        user.setMobileNo(passwordEncoder.encode(dto.getMobileNo())); // simple encryption
        user.setEmailId(dto.getEmailId());
        return userRepository.save(user);
    }

     @Override
    public UserDetails loadUserByUsername(String mobileNo) throws UsernameNotFoundException {
        User user = userRepository.findByMobileNo(mobileNo)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with mobile: " + mobileNo));

        // Check account status if needed (optional)
        if (!"A".equalsIgnoreCase(user.getAccountStatus())) {
            throw new RuntimeException("Account is not active");
        }

        return org.springframework.security.core.userdetails.User.builder()
            .username(user.getMobileNo())
            .password(user.getPwd()) // should be already encoded in DB
            .roles(user.getRole())   // like "USER", "ADMIN"
            .build();
    }
}