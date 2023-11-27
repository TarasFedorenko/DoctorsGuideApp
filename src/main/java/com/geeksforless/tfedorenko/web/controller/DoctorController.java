package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.DiseaseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    private final DiseaseFacade diseaseFacade;

    @GetMapping("/home")
    public String home() {
        return "/page/doctor/home";
    }

    @GetMapping("/diseases")
    public String getAllDiseases(Model model) {
        model.addAttribute("diseases_list", diseaseFacade.findAll());
        return "/page/doctor/diseases";
    }
}
