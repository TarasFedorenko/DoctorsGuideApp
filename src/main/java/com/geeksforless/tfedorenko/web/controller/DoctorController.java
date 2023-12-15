package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.*;
import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorFacade doctorFacade;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String showDoctorHomePage(Model model, Principal principal) {
        Doctor doctor = doctorFacade.findByEmail(principal.getName());
        model.addAttribute("doctor", doctor);
        model.addAttribute("appointments", doctor.getAppointments());
        return "page/doctor/home";
    }

    @PostMapping("/home")
    public String updateUserInfo(@ModelAttribute("doctor") Doctor doctor,
                                 @RequestParam(name = "new_password", required = false) String newPassword,
                                 Principal principal) {
        Doctor currentDoctor = doctorFacade.findByEmail(principal.getName());
        Long currentId = currentDoctor.getId();
        if (newPassword != null && !newPassword.isEmpty()) {
            String encryptedPassword = passwordEncoder.encode(newPassword);
            doctor.setId(currentId);
            doctor.setPassword(encryptedPassword);
        } else {
            doctor.setPassword(currentDoctor.getPassword());
            doctor.setId(currentId);
        }
        doctorFacade.updateDoctor(doctor);
        return "redirect:/doctor/home";
    }
}
