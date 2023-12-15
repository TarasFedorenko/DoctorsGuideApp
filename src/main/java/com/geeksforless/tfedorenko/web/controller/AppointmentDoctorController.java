package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.AppointmentFacade;
import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor/appointment")
public class AppointmentDoctorController {

    private final AppointmentFacade appointmentFacade;

    @GetMapping()
    public String showAppointmentPage(Model model) {
        model.addAttribute("newAppointment", new Appointment());
        model.addAttribute("temporaryDrugs", appointmentFacade.getTemporaryDrugs());
        return "/page/doctor/appointment";
    }

    @PostMapping("/save")
    public String saveAppointment(@ModelAttribute("newAppointment") Appointment newAppointment) {
        appointmentFacade.saveAppointment(newAppointment);
        return "redirect:/doctor/appointment";
    }

    @GetMapping("/removeDrug")
    public String removeDrugFromAppointment(@RequestParam Long drugId) {
        appointmentFacade.removeDrugFromAppointment(drugId);
        return "redirect:/doctor/appointment";
    }
}