package com.geeksforless.tfedorenko.factory;

import com.geeksforless.tfedorenko.persistence.entity.Drug;


public class DrugFactory {
    public static Drug createTwoArgsDrug(Long id, String name) {
        Drug drug = new Drug();
        drug.setId(id);
        drug.setName(name);
        return drug;
    }
}
