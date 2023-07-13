package com.suyo.quran.service;

import com.suyo.quran.entities.User;
import com.suyo.quran.models.ChangePassword;
import com.suyo.quran.models.SetPassword;
import com.suyo.quran.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Object setPassword(Long userId, SetPassword password) {
        Optional<User> user = userRepository.setUpPassword(userId, passwordEncoder.encode(password.getPassword()));
        return user.orElse(null);
    }

    public Object changePassword(Long id, ChangePassword password) {
        if (!password.getOldPassword().equals(password.getNewPassword())) {
            return userRepository.changePassword(id, password.getNewPassword(), password.getOldPassword()).orElse(null);
        } else {
            return "password should be different";
        }
    }
}
