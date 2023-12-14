package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.factory.DiseaseFactory;
import com.geeksforless.tfedorenko.factory.DrugFactory;
import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.repository.DiseaseRepository;
import com.geeksforless.tfedorenko.persistence.repository.DrugRepository;
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

class DiseaseServiceImplTest {

    @Mock
    private DiseaseRepository diseaseRepository;
    @InjectMocks
    private DiseaseServiceImpl diseaseService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Disease expectedDisease = new Disease();
        expectedDisease.setId(1L);
        expectedDisease.setName("Test Procedure");

        when(diseaseRepository.findById(1L)).thenReturn(Optional.of(expectedDisease));
        Optional<Disease> result = diseaseService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(expectedDisease, result.get());

        verify(diseaseRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        List<Disease> expectedDisease = Arrays.asList(
                DiseaseFactory.createTwoArgsDisease(1L, "Disease1"),
                DiseaseFactory.createTwoArgsDisease(2L, "Disease2"),
                DiseaseFactory.createTwoArgsDisease(3L, "Disease3"));

        when(diseaseRepository.findAll()).thenReturn(expectedDisease);
        List<Disease> result = diseaseService.findAll();
        assertEquals(expectedDisease.size(), result.size());
        assertEquals(expectedDisease, result);

        verify(diseaseRepository, times(1)).findAll();
    }

    @Test
    void testGetDiseaseByFirstLetter() {
        String letter = "A";
        List<Disease> expectedDisease = Arrays.asList(
                DiseaseFactory.createTwoArgsDisease(1L, "Apnoea"),
                DiseaseFactory.createTwoArgsDisease(2L, "Allergy"));

        when(diseaseRepository.findByNameStartingWithIgnoreCase(letter)).thenReturn(expectedDisease);
        List<Disease> result = diseaseService.getDiseasesByFirstLetter(letter);
        assertEquals(expectedDisease.size(), result.size());
        assertEquals(expectedDisease, result);
        verify(diseaseRepository, times(1)).findByNameStartingWithIgnoreCase(letter);
    }

    @Test
    void testFindByName() {
        String diseaseName = "Allergy";
        Disease expectedDisease =  DiseaseFactory.createTwoArgsDisease(1L, diseaseName);

        when(diseaseRepository.findByName(diseaseName)).thenReturn(Optional.of(expectedDisease));
        Optional<Disease> result = diseaseService.findByName(diseaseName);
        assertTrue(result.isPresent());
        assertEquals(expectedDisease, result.get());
        verify(diseaseRepository, times(1)).findByName(diseaseName);
    }

    @Test
    void testFindAllByIds() {
        List<Long> diseaseIds = Arrays.asList(1L, 2L, 3L);
        List<Disease> expectedDisease = Arrays.asList(
                DiseaseFactory.createTwoArgsDisease(1L, "Disease1"),
                DiseaseFactory.createTwoArgsDisease(2L, "Disease2"),
                DiseaseFactory.createTwoArgsDisease(3L, "Disease3"));

        when(diseaseRepository.findAllById(diseaseIds)).thenReturn(expectedDisease);
        List<Disease> result = diseaseService.findAllByIds(diseaseIds);
        assertEquals(expectedDisease.size(), result.size());
        assertEquals(expectedDisease, result);
        verify(diseaseRepository, times(1)).findAllById(diseaseIds);
    }

}