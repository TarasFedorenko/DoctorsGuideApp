package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.DiseaseFacade;
import com.geeksforless.tfedorenko.facade.DoctorFacade;
import com.geeksforless.tfedorenko.facade.DrugFacade;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.web.dto.DoctorDto;
import com.geeksforless.tfedorenko.web.dto.detail.DoctorDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final DoctorFacade doctorFacade;
    private final DrugFacade drugFacade;
    private final DiseaseFacade diseaseFacade;

    @GetMapping("/home")
    public String home() {
        return "/page/admin/home";
    }

    @GetMapping("/doctors/list")
    public String doctorsList(Model model) {
        List<DoctorDto> doctors = doctorFacade.getAllDoctors();
        model.addAttribute("users", doctors);
        return "page/admin/doctors_list";
    }

    @GetMapping("/doctors/details/{id}")
    public String doctorInfo(@PathVariable Long id, Model model) {
        DoctorDetailDto doctor = doctorFacade.getDoctor(id);
        model.addAttribute("doctor", doctor);
        model.addAttribute("appointments", doctor.getAppointments());
        return "page/admin/doctor_detail";
    }

    @PostMapping("/doctors/deactivate/{id}")
    public String deactivateDoctor(@PathVariable Long id) {
        doctorFacade.deactivateDoctor(id);
        return "redirect:/admin/doctors/list";
    }

    @PostMapping("/doctors/activate/{id}")
    public String activateDoctor(@PathVariable Long id) {
        doctorFacade.activateDoctor(id);
        return "redirect:/admin/doctors/list";
    }

    @GetMapping("/doctors/delete/{id}")
    public String removeDoctor(@PathVariable Long id) {
        doctorFacade.removeDoctor(id);
        return "redirect:/admin/doctors/list";
    }
    @GetMapping("/doctors/create")
    public String createDoctor(Model model){
        model.addAttribute("doctor",new Doctor());
        return "page/admin/doctor_create";
    }
    @PostMapping("/doctors/create")
    public String createDoctorForm(@ModelAttribute Doctor doctor){
        doctorFacade.createDoctor(doctor);
        return "redirect:/admin/doctors/list";
    }

    @GetMapping("/drugs/list")
    public String drugsList(Model model){
        model.addAttribute("drugs", drugFacade.findAll());
        return "page/admin/drugs_list";
    }
    @GetMapping("/drugs/create")
    public String createDrug(Model model){
        model.addAttribute("allDrugs", drugFacade.findAll());
        model.addAttribute("allDiseases", diseaseFacade.findAll());
        model.addAttribute("temporaryDrugs", drugFacade.getTemporaryDrugs());
        model.addAttribute("drug", new Drug());
        return "page/admin/drug_create";
    }
    @PostMapping("/drugs/create")
    public String createDrugForm(@ModelAttribute Drug drug){
        drugFacade.createDrug(drug);
        return "redirect:/admin/drugs/list";
    }

    @GetMapping("/drugs/addAnalog")
    public String addAnalogToNewDrug(@RequestParam long drugId){
        drugFacade.addAnalogToTempList(drugId);
        return "redirect:/admin/drugs/create";
    }


}
