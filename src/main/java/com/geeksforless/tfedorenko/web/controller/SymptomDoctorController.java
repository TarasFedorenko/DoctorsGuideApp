package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.SymptomFacade;
import com.geeksforless.tfedorenko.web.dto.SymptomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor/symptoms")
public class SymptomDoctorController {
    private final SymptomFacade symptomFacade;

    @GetMapping()
    public String getSymptomsType(Model model) {
        model.addAttribute("symptomTypes", symptomFacade.findAllSymptomTypes());
        return "/page/doctor/symptoms";
    }

    @GetMapping("/type/{type}")
    public String showSymptomsByType(@PathVariable String type, Model model) {
        List<SymptomDto> symptomDtos = symptomFacade.findAllByType(type);
        model.addAttribute("symptoms", symptomDtos);
        return "/page/doctor/symptom_type";
    }

    @GetMapping("/{id}")
    public String getSymptomById(Model model, @PathVariable Long id) {
        model.addAttribute("symptom", symptomFacade.findById(id));
        return "/page/doctor/symptom_detail";
    }
}
