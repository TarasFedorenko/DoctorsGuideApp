package com.geeksforless.tfedorenko.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String home() {
        return "page/admin/home";
    }


}
