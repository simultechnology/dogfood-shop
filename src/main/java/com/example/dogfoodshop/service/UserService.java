package com.example.dogfoodshop.service;

import com.example.dogfoodshop.form.AdminRegistrationForm;
import com.example.dogfoodshop.model.User;
import com.example.dogfoodshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createAdminUser(AdminRegistrationForm form) {
        if (userRepository.existsByEmail(form.getEmail())) {
            throw new RuntimeException("このメールアドレスは既に登録されています");
        }

        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setRoles(Set.of("ROLE_ADMIN", "ROLE_USER"));
        user.setActive(true);

        return userRepository.save(user);
    }
}