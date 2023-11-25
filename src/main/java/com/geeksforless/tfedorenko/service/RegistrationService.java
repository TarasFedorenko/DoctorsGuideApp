package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.web.dto.AuthDto;
import org.springframework.stereotype.Service;


public interface RegistrationService {
    void registration(AuthDto authDto);
}
