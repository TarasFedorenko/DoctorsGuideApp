package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.config.security.SecurityService;
import com.geeksforless.tfedorenko.facade.AuthValidatorFacade;
import com.geeksforless.tfedorenko.persistence.type.RoleType;
import com.geeksforless.tfedorenko.service.RegistrationService;
import com.geeksforless.tfedorenko.util.SecurityUtil;
import com.geeksforless.tfedorenko.web.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController extends AbstractController {

    private final SecurityService securityService;
    private final RegistrationService registrationService;
    private final AuthValidatorFacade authValidatorFacade;

    @GetMapping("/")
    public String main(Model model) {
        return redirectToPageRole(model);
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        showMessage(model, false);
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated) {
            return redirectToPageRole(model);
        }
        if (error != null) {
            showError(model, "Your email and password is invalid.");
        }
        if (logout != null) {
            showInfo(model, "You have been logged out successfully.");
        }
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return redirectToPageRole(model);
        }
        model.addAttribute("authForm", new AuthDto());
        return "/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("authForm") AuthDto authDto, BindingResult bindingResult, Model model) {
        showMessage(model, false);
        authValidatorFacade.validate(authDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        registrationService.registration(authDto);
        securityService.autoLogin(authDto.getEmail(), authDto.getPassword());
        return redirectToPageRole(model);
    }

    private String redirectToPageRole(Model model) {
        showMessage(model, false);
        if (SecurityUtil.hasRole(RoleType.ROLE_ADMIN.name())) {
            return "redirect:/admin/home";
        }
        if (SecurityUtil.hasRole(RoleType.ROLE_DOCTOR.name())) {
            return "redirect:/doctor/home";
        }
        return "redirect:/login";
    }
}
