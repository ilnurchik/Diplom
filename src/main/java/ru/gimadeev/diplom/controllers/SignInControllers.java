package ru.gimadeev.diplom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class SignInControllers {

    @GetMapping("/")
    public String getSignInPage() {
        return "signIn_page";
    }
}
