package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.DoctorFacade;
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
@RequestMapping("/admin/doctors")
public class AdminDoctorController {

    private final DoctorFacade doctorFacade;

    @GetMapping("/list")
    public String doctorsList(Model model) {
        List<DoctorDto> doctors = doctorFacade.getAllDoctors();
        model.addAttribute("users", doctors);
        return "page/admin/doctors_list";
    }

    @GetMapping("/details/{id}")
    public String doctorInfo(@PathVariable Long id, Model model) {
        DoctorDetailDto doctor = doctorFacade.getDoctor(id);
        model.addAttribute("doctor", doctor);
        model.addAttribute("appointments", doctor.getAppointments());
        return "page/admin/doctor_detail";
    }

    @PostMapping("/deactivate/{id}")
    public String deactivateDoctor(@PathVariable Long id) {
        doctorFacade.deactivateDoctor(id);
        return "redirect:/admin/doctors/list";
    }

    @PostMapping("/activate/{id}")
    public String activateDoctor(@PathVariable Long id) {
        doctorFacade.activateDoctor(id);
        return "redirect:/admin/doctors/list";
    }

    @GetMapping("/delete/{id}")
    public String removeDoctor(@PathVariable Long id) {
        doctorFacade.removeDoctor(id);
        return "redirect:/admin/doctors/list";
    }

    @GetMapping("/create")
    public String createDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "page/admin/doctor_create";
    }

    @PostMapping("/create")
    public String createDoctorForm(@ModelAttribute Doctor doctor) {
        doctorFacade.createDoctor(doctor);
        return "redirect:/admin/doctors/list";
    }
}
