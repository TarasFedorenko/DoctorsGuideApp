package com.geeksforless.tfedorenko.factory;

import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.type.SymptomType;

public class SymptomFactory {
    public static Symptom createTwoArgsSymptom(Long id, String name) {
        Symptom symptom = new Symptom();
        symptom.setId(id);
        symptom.setName(name);
        return symptom;
    }
    public static Symptom createThreeArgsSymptom(Long id, String name, SymptomType symptomType) {
        Symptom symptom = new Symptom();
        symptom.setId(id);
        symptom.setName(name);
        symptom.setType(symptomType);
        return symptom;
    }
}
