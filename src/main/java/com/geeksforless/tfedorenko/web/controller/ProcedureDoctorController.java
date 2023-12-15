package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.ProcedureFacade;
import com.geeksforless.tfedorenko.web.dto.ProcedureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor/procedures")
public class ProcedureDoctorController {

    private final ProcedureFacade procedureFacade;

    @GetMapping()
    public String getProcedureType(Model model) {
        model.addAttribute("procedureTypes", procedureFacade.findAllProcedureTypes());
        return "/page/doctor/procedures";
    }

    @GetMapping("/type/{type}")
    public String showProceduresByType(@PathVariable String type, Model model) {
        List<ProcedureDto> procedureDtos = procedureFacade.findAllByType(type);
        model.addAttribute("procedures", procedureDtos);
        return "/page/doctor/procedure_type";
    }

    @GetMapping("/{id}")
    public String getProcedureById(Model model, @PathVariable Long id) {
        model.addAttribute("procedure", procedureFacade.findById(id));
        return "/page/doctor/procedure_detail";
    }
}
