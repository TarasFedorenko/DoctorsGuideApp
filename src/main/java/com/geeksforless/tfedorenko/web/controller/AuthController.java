package com.geeksforless.tfedorenko.web.controller;

import com.geeksforless.tfedorenko.config.security.SecurityService;
import com.geeksforless.tfedorenko.persistence.type.RoleType;
import com.geeksforless.tfedorenko.service.RegistrationService;
import com.geeksforless.tfedorenko.util.SecurityUtil;
import com.geeksforless.tfedorenko.web.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final SecurityService securityService;
    private final RegistrationService registrationService;

    @GetMapping("/")
    public String main() {
        return redirectToPageRole();
    }

    @GetMapping("/login")
    public String login() {
        boolean authenticated = securityService.isAuthenticated();
        if (authenticated) {
            return redirectToPageRole();
        }
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return redirectToPageRole();
        }
        model.addAttribute("authForm",new AuthDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute AuthDto authDto){
        if (securityService.isAuthenticated()) {
            return redirectToPageRole();
        }
        registrationService.registration(authDto);
        securityService.autoLogin(authDto.getEmail(),authDto.getPassword());
        return redirectToPageRole();
    }

    private String redirectToPageRole() {
        if (SecurityUtil.hasRole(RoleType.ROLE_ADMIN.name())) {
            return "redirect:/admin/home";
        }
        if (SecurityUtil.hasRole(RoleType.ROLE_DOCTOR.name())) {
            return "redirect:/doctor/home";
        }
        return "redirect:/login";
    }
}
