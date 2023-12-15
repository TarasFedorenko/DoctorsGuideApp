package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.AppointmentFacade;
import com.geeksforless.tfedorenko.facade.DrugFacade;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import com.geeksforless.tfedorenko.web.dto.detail.DrugDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor/drugs")
public class DrugDoctorController {

    private final DrugFacade drugFacade;
    private final AppointmentFacade appointmentFacade;
    private final String [] ALPHABET = {"А","Б","В","Г","Д","Е","Є","Ж","З","І","К","Л","М","Н","О","П","Р","С","Т","Ф","Х","Ц","Ч","Ш","Щ","Ю","Я"};
    @GetMapping()
    public String getAllDrugs(Model model) {
        model.addAttribute("alphabet", ALPHABET);
        return "/page/doctor/drugs";
    }
    @GetMapping("/{id}")
    public String getDrugById(Model model, @PathVariable Long id){
        model.addAttribute("drug", drugFacade.findById(id));
        return "/page/doctor/drug_detail";
    }
    @GetMapping("/letter/{letter}")
    public String showDrugByLetter(@PathVariable String letter, Model model) {
        List<DrugDto> drugsStartingWithLetter = drugFacade.getDrugByFirstLetter(letter);
        model.addAttribute("drugs", drugsStartingWithLetter);
        return "/page/doctor/drug_alphabet";
    }
    @GetMapping("/search")
    public String getDrugDetails(@RequestParam String name) {
        DrugDetailDto drug = drugFacade.findByName(name);
        if (drug == null) {
            return "redirect:/doctor/drugs";
        }
        Long drugId = drug.getId();
        return "redirect:/doctor/drugs/" + drugId;
    }
    @PostMapping("/{id}/add")
    public String addDrugToAppointment(@PathVariable Long id){
        appointmentFacade.addDrugToAppointment(id);
        return "redirect:/doctor/drugs/{id}";
    }
}
