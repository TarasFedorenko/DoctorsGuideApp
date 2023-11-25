package com.geeksforless.tfedorenko.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {
    @GetMapping("/home")
    public String home(){
        return "/page/doctor/home";
    }
}
