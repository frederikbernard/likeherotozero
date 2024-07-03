package com.example.likeherotozero.controller;

import com.example.likeherotozero.model.UserInfo;
import com.example.likeherotozero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session) {

        Map<String, String> response = new HashMap<>();

        Optional<UserInfo> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            session.setAttribute("user", userOptional.get());
            response.put("message", "Login successful");
            response.put("redirect", "/co2data");
        } else {
            response.put("message", "Invalid username or password.");
        }

        return response;
    }

    @GetMapping("/logout")
    public String handleLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
