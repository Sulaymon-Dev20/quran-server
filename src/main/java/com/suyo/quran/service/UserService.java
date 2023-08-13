package com.suyo.quran.service;

import com.suyo.quran.entities.User;
import com.suyo.quran.models.auth.SetPassword;
import com.suyo.quran.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Object setPassword(UUID userId, SetPassword password) {
        Optional<User> user = userRepository.setUpPassword(userId, passwordEncoder.encode(password.getPassword()));
        return user.orElse(null);
    }

//    public Object changePassword(Long id, ChangePassword password) {
//        if (!password.getOldPassword().equals(password.getNewPassword())) {
//            System.out.println(passwordEncoder.encode(password.getOldPassword()));
//            return userRepository.changePassword(id, passwordEncoder.encode(password.getNewPassword()), passwordEncoder.encode(password.getOldPassword())).orElse(null);
//        } else {
//            return "password should be different";
//        }
//    }
}
