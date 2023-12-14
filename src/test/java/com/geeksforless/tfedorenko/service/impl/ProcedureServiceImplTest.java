package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.factory.ProcedureFactory;
import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.repository.ProcedureRepository;
import com.geeksforless.tfedorenko.persistence.type.ProcedureType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ProcedureServiceImplTest {
    @Mock
    private ProcedureRepository procedureRepository;
    @InjectMocks
    private ProcedureServiceImpl procedureService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Procedure expectedProcedure = new Procedure();
        expectedProcedure.setId(1L);
        expectedProcedure.setName("Test Procedure");

        when(procedureRepository.findById(1L)).thenReturn(Optional.of(expectedProcedure));
        Optional<Procedure> result = procedureService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(expectedProcedure, result.get());

        verify(procedureRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        List<Procedure> expectedProcedures = Arrays.asList(
                ProcedureFactory.createTwoArgsProcedure(1L, "Procedure1"),
                ProcedureFactory.createTwoArgsProcedure(2L, "Procedure2"),
                ProcedureFactory.createTwoArgsProcedure(3L, "Procedure3"));

        when(procedureRepository.findAll()).thenReturn(expectedProcedures);
        List<Procedure> result = procedureService.findAll();
        assertEquals(expectedProcedures.size(), result.size());
        assertEquals(expectedProcedures, result);

        verify(procedureRepository, times(1)).findAll();
    }

    @Test
    void testFindAllByType() {

        ProcedureType procedureType = ProcedureType.INSTRUMENTAL;
        List<Procedure> expectedProcedures = Arrays.asList(
                ProcedureFactory.createThreeArgsProcedure(1L, "Procedure1", procedureType),
                ProcedureFactory.createThreeArgsProcedure(2L, "Procedure2", procedureType),
                ProcedureFactory.createThreeArgsProcedure(3L, "Procedure3", procedureType));

        when(procedureRepository.findAllByProcedureType(procedureType)).thenReturn(expectedProcedures);
        List<Procedure> result = procedureService.findAllByType(procedureType);
        assertEquals(expectedProcedures.size(), result.size());
        assertEquals(expectedProcedures, result);

        verify(procedureRepository, times(1)).findAllByProcedureType(procedureType);
    }

    @Test
    void testFindAllProcedureTypes() {

        List<ProcedureType> expectedProcedureTypes = Arrays.asList(
                ProcedureType.TREATMENT,
                ProcedureType.LABORATORY,
                ProcedureType.INSTRUMENTAL
                );

        when(procedureRepository.findAllUniqueProcedureTypes()).thenReturn(expectedProcedureTypes);
        List<ProcedureType> result = procedureService.findAllProcedureTypes();
        assertEquals(expectedProcedureTypes.size(), result.size());
        assertEquals(expectedProcedureTypes, result);

        verify(procedureRepository, times(1)).findAllUniqueProcedureTypes();
    }
}