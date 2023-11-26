package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.persistence.entity.Dose;
import com.geeksforless.tfedorenko.persistence.repository.DoseRepository;
import com.geeksforless.tfedorenko.service.DoseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DoseServiceImpl implements DoseService {

    private final DoseRepository doseRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Dose> findAll() {
        return doseRepository.findAll();
    }
}
