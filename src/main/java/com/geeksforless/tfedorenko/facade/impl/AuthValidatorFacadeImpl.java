package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.AuthValidatorFacade;
import com.geeksforless.tfedorenko.service.DoctorService;
import com.geeksforless.tfedorenko.web.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;


@Service
@RequiredArgsConstructor
public class AuthValidatorFacadeImpl implements AuthValidatorFacade {

    private final DoctorService doctorService;

    @Override
    public boolean supports(Class<?> clazz) {
        return AuthDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AuthDto data = (AuthDto) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (data.getEmail().length() < 6 || data.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.authForm.email");
        }
        if (doctorService.existsByEmail(data.getEmail())) {
            errors.rejectValue("email", "Duplicate.authForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (data.getPassword().length() < 3 || data.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.authForm.password");
        }

    }
}
