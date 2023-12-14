package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.factory.SymptomFactory;
import com.geeksforless.tfedorenko.persistence.entity.Symptom;
import com.geeksforless.tfedorenko.persistence.repository.SymptomRepository;
import com.geeksforless.tfedorenko.persistence.type.SymptomType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SymptomServiceImplTest {
    @Mock
    private SymptomRepository symptomRepository;
    @InjectMocks
    private SymptomServiceImpl symptomService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        Symptom expectedSymptom = new Symptom();
        expectedSymptom.setId(1L);
        expectedSymptom.setName("Test Symptom");

        when(symptomRepository.findById(1L)).thenReturn(Optional.of(expectedSymptom));
        Optional<Symptom> result = symptomService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(expectedSymptom, result.get());

        verify(symptomRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        List<Symptom> expectedSymptoms = Arrays.asList(
                SymptomFactory.createTwoArgsSymptom(1L, "Symptom1"),
                SymptomFactory.createTwoArgsSymptom(2L, "Symptom2"),
                SymptomFactory.createTwoArgsSymptom(3L, "Symptom3"));

        when(symptomRepository.findAll()).thenReturn(expectedSymptoms);
        List<Symptom> result = symptomService.findAll();
        assertEquals(expectedSymptoms.size(), result.size());
        assertEquals(expectedSymptoms, result);

        verify(symptomRepository, times(1)).findAll();
    }

    @Test
    void testFindAllByType() {

        SymptomType symptomType = SymptomType.COMMON;
        List<Symptom> expectedSymptoms = Arrays.asList(
                SymptomFactory.createThreeArgsSymptom(1L, "Symptom1", symptomType),
                SymptomFactory.createThreeArgsSymptom(2L, "Symptom2", symptomType),
                SymptomFactory.createThreeArgsSymptom(3L, "Symptom3", symptomType));

        when(symptomRepository.findAllByType(symptomType)).thenReturn(expectedSymptoms);
        List<Symptom> result = symptomService.findAllByType(symptomType);
        assertEquals(expectedSymptoms.size(), result.size());
        assertEquals(expectedSymptoms, result);

        verify(symptomRepository, times(1)).findAllByType(symptomType);
    }

    @Test
    void testFindAllSymptomTypes() {

        List<SymptomType> expectedSymptomTypes = Arrays.asList(
                SymptomType.COMMON,
                SymptomType.ORGAN_SPECIFIC,
                SymptomType.INSTRUMENTAL,
                SymptomType.LABORATORY,
                SymptomType.PSYCHOLOGICAL);

        when(symptomRepository.findAllUniqueSymptomTypes()).thenReturn(expectedSymptomTypes);
        List<SymptomType> result = symptomService.findAllSymptomTypes();
        assertEquals(expectedSymptomTypes.size(), result.size());
        assertEquals(expectedSymptomTypes, result);

        verify(symptomRepository, times(1)).findAllUniqueSymptomTypes();
    }
}