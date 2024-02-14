package com.doubleb.bmoto.security.controller;

import com.doubleb.bmoto.security.payload.request.SignupRequest;
import com.doubleb.bmoto.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("signupRequest", new SignupRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute SignupRequest signupRequest) {
        try{
            userService.save(signupRequest);
            return "redirect:/shop";
        }catch (Exception e){
            return "register";
        }
    }

    @GetMapping("/access-denied")
    public String getAccessDenied(Model model) {
        return "access-denied";
    }


}
