package com.geeksforless.tfedorenko.factory;

import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.type.ProcedureType;


public class ProcedureFactory {
    public static Procedure createTwoArgsProcedure(Long id, String name) {
        Procedure procedure = new Procedure();
        procedure.setId(id);
        procedure.setName(name);
        return procedure;
    }
    public static Procedure createThreeArgsProcedure(Long id, String name, ProcedureType procedureType) {
        Procedure procedure = new Procedure();
        procedure.setId(id);
        procedure.setName(name);
        procedure.setProcedureType(procedureType);
        return procedure;
    }
}
