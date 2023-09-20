package com.suyo.quran.security;

import com.suyo.quran.entities.User;
import com.suyo.quran.models.auth.CheckEmailCode;
import com.suyo.quran.models.auth.Login;
import com.suyo.quran.models.auth.Register;
import com.suyo.quran.repository.UserRepository;
import com.suyo.quran.service.mail.MailService;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final MailService mailService;

    public Object register(Register request) {
        final String code = generateEmailCode();
        mailService.sendMail(request.getEmail(), MailService.sendCodeMail, Map.of("code", code, "timeZone", TimeZone.getDefault().getID()));
        final User user = userRepository.updateAuthCode(request.getEmail(), code, request.getFirstName(), request.getLastName());
        return user.getCode();
    }

    public JWT checkCode(CheckEmailCode request) {
        final Optional<User> user = userRepository.checkEmailCode(request.getEmail(), request.getCode());
        return user.map(jwtService::generateAllToken).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No such user"));
    }

    public JWT refreshToken(User user) {
        return jwtService.generateAllToken(user);
    }

    @SneakyThrows
    public JWT login(Login request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new ServletException("No such user"));
        return jwtService.generateAllToken(user);
    }

    private String generateEmailCode() {
        final int max = 999999;
        final int min = 100000;
        return String.valueOf(new Random().nextInt(max + 1 - min) + min);
    }
}
