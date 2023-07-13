package com.suyo.quran.security.security;

import com.suyo.quran.entities.User;
import com.suyo.quran.models.CheckEmailCode;
import com.suyo.quran.models.MailData;
import com.suyo.quran.repository.MailCodeRepository;
import com.suyo.quran.repository.UserRepository;
import com.suyo.quran.security.models.AuthResponse;
import com.suyo.quran.security.models.LoginRequest;
import com.suyo.quran.security.models.RegisterRequest;
import com.suyo.quran.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final DataService dataService;
    private final MailCodeRepository mailCodeRepository;
    private final AuthenticationManager authenticationManager;

//    public AuthResponse register(RegisterRequest request) {
//        User build = User
//            .builder()
//            .firstName(request.getFirstname())
//            .lastName(request.getLastname())
//            .email(request.getEmail())
//            .password(passwordEncoder.encode(request.getPassword()))
//            .build();
//        userRepository.save(build);
//        return AuthResponse.builder().token(jwtService.generateToken(build)).build();
//    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return AuthResponse.builder().token(jwtService.generateToken(user)).build();
    }

    public Object sendCode(RegisterRequest request) {
        final MailData mailData = new MailData(request.getEmail());
        dataService.sendMail(mailData);
        mailCodeRepository.save(mailData);
        return mailData;
    }

    public Object checkCode(CheckEmailCode request) {
        return null;
    }
}
