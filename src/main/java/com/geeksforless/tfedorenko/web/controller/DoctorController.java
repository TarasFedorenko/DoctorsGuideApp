package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.DiseaseFacade;
import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.detail.DiseaseDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    private final DiseaseFacade diseaseFacade;
    private final String [] ALPHABET = {"А","Б","В","Г","Д","Е","Є","Ж","З","І","К","Л","М","Н","О","П","Р","С","Т","Ф","Х","Ц","Ч","Ш","Щ","Ю","Я"};

    @GetMapping("/home")
    public String home() {
        return "/page/doctor/home";
    }

    @GetMapping("/diseases")
    public String getAllDiseases(Model model) {
        model.addAttribute("alphabet", ALPHABET);
        return "/page/doctor/diseases";
    }
    @GetMapping("/diseases/{id}")
    public String getDiseaseById(Model model, @PathVariable Long id){
        model.addAttribute("disease", diseaseFacade.findById(id));
        return "/page/doctor/disease_detail";
    }
    @GetMapping("/diseases/letter/{letter}")
    public String showDiseasesByLetter(@PathVariable String letter, Model model) {
        List<DiseaseDto> diseasesStartingWithLetter = diseaseFacade.getDiseasesByFirstLetter(letter);
        model.addAttribute("diseases", diseasesStartingWithLetter);
        return "/page/doctor/disease_alphabet";
    }
    @GetMapping("/diseases/search")
    public String getDiseaseDetails(@RequestParam String name, Model model) {
        DiseaseDetailDto disease = diseaseFacade.findByName(name);
        if (disease == null) {
            return "redirect:/error";
        }
        Long diseaseId = disease.getId();
        return "redirect:/doctor/diseases/" + diseaseId;
    }

}
