package com.geeksforless.tfedorenko.service;

import com.geeksforless.tfedorenko.persistence.entity.Dose;

import java.util.List;


public interface DoseService {
    List<Dose> findAll();
}
