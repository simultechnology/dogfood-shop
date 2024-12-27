package com.example.dogfoodshop.controller;

import com.example.dogfoodshop.form.AdminRegistrationForm;
import com.example.dogfoodshop.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("adminRegistrationForm", new AdminRegistrationForm());
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute AdminRegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "auth/register";
        }
        userService.createAdminUser(form);
        return "redirect:/login?registered";
    }

    @GetMapping("/admin/register")
    public String adminRegisterForm(Model model) {
        model.addAttribute("adminRegistrationForm", new AdminRegistrationForm());
        return "auth/admin-register";
    }

    @PostMapping("/admin/register")
    public String adminRegister(@Valid @ModelAttribute AdminRegistrationForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "auth/admin-register";
        }
        userService.createAdminUser(form);
        return "redirect:/login?registered";
    }
}