package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.DiseaseFacade;
import com.geeksforless.tfedorenko.facade.DrugFacade;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/drugs")
public class AdminDrugController {

    private final DrugFacade drugFacade;
    private final DiseaseFacade diseaseFacade;

    @GetMapping("/list")
    public String drugsList(Model model) {
        model.addAttribute("drugs", drugFacade.findAll());
        return "page/admin/drugs_list";
    }

    @GetMapping("/create")
    public String createDrug(Model model) {
        model.addAttribute("allDrugs", drugFacade.findAll());
        model.addAttribute("allDiseases", diseaseFacade.findAll());
        model.addAttribute("temporaryDrugs", drugFacade.getTemporaryDrugs());
        model.addAttribute("temporaryDiseases", drugFacade.getTemporaryDiseases());
        model.addAttribute("drug", new Drug());
        return "page/admin/drug_create";
    }

    @PostMapping("/create")
    public String createDrugForm(@ModelAttribute Drug drug) {
        drugFacade.createDrug(drug);
        return "redirect:/admin/drugs/list";
    }

    @GetMapping("/addAnalog")
    public String addAnalogToNewDrug(@RequestParam Long drugId) {
        drugFacade.addAnalogToTempList(drugId);
        return "redirect:/admin/drugs/create";
    }

    @GetMapping("/removeDrug")
    public String removeAnalogFromNewDrug(@RequestParam Long drugId) {
        drugFacade.removeAnalogFromNewDrug(drugId);
        return "redirect:/admin/drugs/create";
    }

    @GetMapping("/addDisease")
    public String addDiseaseToNewDrug(@RequestParam Long diseaseId) {
        drugFacade.addDiseaseToTempList(diseaseId);
        return "redirect:/admin/drugs/create";
    }

    @GetMapping("/removeDisease")
    public String removeDiseaseFromNewDrug(@RequestParam Long diseaseId) {
        drugFacade.removeDiseaseFromNewDrug(diseaseId);
        return "redirect:/admin/drugs/create";
    }

    @GetMapping("/update/{id}")
    public String showDrugDetail(Model model, @PathVariable Long id) {
        model.addAttribute("drug", drugFacade.findById(id));
        return "page/admin/drug_update";
    }

    @PostMapping("/update")
    public String updateDrug(@ModelAttribute Drug drug) {
        drugFacade.updateDrug(drug);
        return "redirect:/admin/drugs/update/" + drug.getId();
    }

    @GetMapping("/delete/{id}")
    public String removeDrug(@PathVariable Long id) {
        drugFacade.removeDrug(id);
        return "redirect:/admin/drugs/list";
    }
}
