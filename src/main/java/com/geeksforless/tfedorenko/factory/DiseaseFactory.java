package com.geeksforless.tfedorenko.factory;

import com.geeksforless.tfedorenko.persistence.entity.Disease;

public class DiseaseFactory {
    public static Disease createTwoArgsDisease(Long id, String name) {
        Disease disease = new Disease();
        disease.setId(id);
        disease.setName(name);
        return disease;
    }
}
