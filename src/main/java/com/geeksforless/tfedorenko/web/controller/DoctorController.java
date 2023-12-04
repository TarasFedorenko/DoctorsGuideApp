package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.facade.*;
import com.geeksforless.tfedorenko.persistence.entity.Appointment;
import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.user.Doctor;
import com.geeksforless.tfedorenko.service.DoctorService;
import com.geeksforless.tfedorenko.util.SecurityUtil;
import com.geeksforless.tfedorenko.web.dto.DiseaseDto;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import com.geeksforless.tfedorenko.web.dto.ProcedureDto;
import com.geeksforless.tfedorenko.web.dto.SymptomDto;
import com.geeksforless.tfedorenko.web.dto.detail.DiseaseDetailDto;
import com.geeksforless.tfedorenko.web.dto.detail.DrugDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    private final DiseaseFacade diseaseFacade;
    private final SymptomFacade symptomFacade;
    private final ProcedureFacade  procedureFacade;
    private final DrugFacade drugFacade;
    private final AppointmentFacade appointmentFacade;
    private final DoctorService doctorService;
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
    public String getDiseaseDetails(@RequestParam String name) {
        DiseaseDetailDto disease = diseaseFacade.findByName(name);
        if (disease == null) {
            return "redirect:/error";
        }
        Long diseaseId = disease.getId();
        return "redirect:/doctor/diseases/" + diseaseId;
    }
    @GetMapping("/symptoms")
    public String getSymptomsType(Model model){
        model.addAttribute("symptomTypes",symptomFacade.findAllSymptomTypes());
        return "/page/doctor/symptoms";
    }
    @GetMapping("/symptoms/type/{type}")
    public String showSymptomsByType(@PathVariable String type, Model model) {
        List<SymptomDto> symptomDtos = symptomFacade.findAllByType(type);
        model.addAttribute("symptoms", symptomDtos);
        return "/page/doctor/symptom_type";
    }
    @GetMapping("/symptoms/{id}")
    public String getSymptomById(Model model, @PathVariable Long id){
        model.addAttribute("symptom", symptomFacade.findById(id));
        return "/page/doctor/symptom_detail";
    }
    @GetMapping("/procedures")
    public String getProcedureType(Model model){
        model.addAttribute("procedureTypes",procedureFacade.findAllProcedureTypes());
        return "/page/doctor/procedures";
    }
    @GetMapping("/procedures/type/{type}")
    public String showProceduresByType(@PathVariable String type, Model model) {
        List<ProcedureDto> procedureDtos = procedureFacade.findAllByType(type);
        model.addAttribute("procedures", procedureDtos);
        return "/page/doctor/procedure_type";
    }
    @GetMapping("/procedures/{id}")
    public String getProcedureById(Model model, @PathVariable Long id){
        model.addAttribute("procedure", procedureFacade.findById(id));
        return "/page/doctor/procedure_detail";
    }
    @GetMapping("/drugs")
    public String getAllDrugs(Model model) {
        model.addAttribute("alphabet", ALPHABET);
        return "/page/doctor/drugs";
    }
    @GetMapping("/drugs/{id}")
    public String getDrugById(Model model, @PathVariable Long id){
        model.addAttribute("drug", drugFacade.findById(id));
        return "/page/doctor/drug_detail";
    }
    @GetMapping("/drugs/letter/{letter}")
    public String showDrugByLetter(@PathVariable String letter, Model model) {
        List<DrugDto> drugsStartingWithLetter = drugFacade.getDrugByFirstLetter(letter);
        model.addAttribute("drugs", drugsStartingWithLetter);
        return "/page/doctor/drug_alphabet";
    }
    @GetMapping("/drugs/search")
    public String getDrugDetails(@RequestParam String name) {
        DrugDetailDto drug = drugFacade.findByName(name);
        if (drug == null) {
            return "redirect:/error";
        }
        Long drugId = drug.getId();
        return "redirect:/doctor/drugs/" + drugId;
    }
    @PostMapping("/drugs/{id}/add")
    public String addDrugToAppointment(@PathVariable Long id){
        appointmentFacade.addDrugToAppointment(id);
        return "redirect:/doctor/drugs/{id}";
    }
    @GetMapping("/appointment")
    public String showAppointmentPage(Model model) {
        model.addAttribute("newAppointment", new Appointment());
        model.addAttribute("temporaryDrugs", appointmentFacade.getTemporaryDrugs());
        return "/page/doctor/appointment";
    }

    @PostMapping("/appointment/save")
    public String saveAppointment(@ModelAttribute("newAppointment") Appointment newAppointment) {
        appointmentFacade.saveAppointment(newAppointment);
        return "redirect:/doctor/appointment";
    }
    @GetMapping("/appointment/removeDrug")
    public String removeDrugFromAppointment(@RequestParam Long drugId) {
        appointmentFacade.removeDrugFromAppointment(drugId);
        return "redirect:/doctor/appointment";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("doctor", getDoctor());
        return "page/doctor/home";
    }

    @PostMapping("/update/{id}")
    public String updateUserInfo(@ModelAttribute("doctor") DoctorDto updatedDoctor, @PathVariable Long id) {
        updatedDoctor.setId(id);
        doctorFacade.update(updatedDoctor);
        return "redirect:/doctor/home";
    }

    private DoctorDto getDoctor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return doctorFacade.findByEmail(email);
    }
}
