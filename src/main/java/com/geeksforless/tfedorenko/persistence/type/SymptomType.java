package com.geeksforless.tfedorenko.persistence.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public enum SymptomType {
    COMMON("ЗАГАЛЬНІ"),
    ORGAN_SPECIFIC("СПЕЦИФІЧНІ ДЛЯ ПЕВНОГО ОРГАНУ"),
    INSTRUMENTAL("ІНСТРУМЕНТАЛЬНІ"),
    LABORATORY("ЛАБОРАТОРНІ"),
    PSYCHOLOGICAL("ПСИХОЛОГІЧНІ");

    private final String ukrName;

    SymptomType(String ukrName) {
        this.ukrName = ukrName;
    }

    public String getUkrName() {
        return ukrName;
    }
}
