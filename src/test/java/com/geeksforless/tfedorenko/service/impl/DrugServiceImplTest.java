package com.geeksforless.tfedorenko.service.impl;

import com.geeksforless.tfedorenko.factory.DrugFactory;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.entity.Procedure;
import com.geeksforless.tfedorenko.persistence.repository.DrugRepository;
import com.geeksforless.tfedorenko.persistence.repository.ProcedureRepository;
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

class DrugServiceImplTest {
    @Mock
    private DrugRepository drugRepository;
    @InjectMocks
    private DrugServiceImpl drugService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Drug expectedDrug = new Drug();
        expectedDrug.setId(1L);
        expectedDrug.setName("Test Procedure");

        when(drugRepository.findById(1L)).thenReturn(Optional.of(expectedDrug));
        Optional<Drug> result = drugService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(expectedDrug, result.get());

        verify(drugRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        List<Drug> expectedDrug = Arrays.asList(
                DrugFactory.createTwoArgsDrug(1L, "Drug1"),
                DrugFactory.createTwoArgsDrug(2L, "Drug2"),
                DrugFactory.createTwoArgsDrug(3L, "Drug3"));

        when(drugRepository.findAll()).thenReturn(expectedDrug);
        List<Drug> result = drugService.findAll();
        assertEquals(expectedDrug.size(), result.size());
        assertEquals(expectedDrug, result);

        verify(drugRepository, times(1)).findAll();
    }

    @Test
    void testGetDrugByFirstLetter() {
        String letter = "A";
        List<Drug> expectedDrugs = Arrays.asList(
                DrugFactory.createTwoArgsDrug(1L, "Aspirin"),
                DrugFactory.createTwoArgsDrug(2L, "Advil"));

        when(drugRepository.findByNameStartingWithIgnoreCase(letter)).thenReturn(expectedDrugs);
        List<Drug> result = drugService.getDrugByFirstLetter(letter);
        assertEquals(expectedDrugs.size(), result.size());
        assertEquals(expectedDrugs, result);
        verify(drugRepository, times(1)).findByNameStartingWithIgnoreCase(letter);
    }

    @Test
    void testFindByName() {
        String drugName = "Aspirin";
        Drug expectedDrug =  DrugFactory.createTwoArgsDrug(1L, drugName);

        when(drugRepository.findByName(drugName)).thenReturn(Optional.of(expectedDrug));
        Optional<Drug> result = drugService.findByName(drugName);
        assertTrue(result.isPresent());
        assertEquals(expectedDrug, result.get());
        verify(drugRepository, times(1)).findByName(drugName);
    }

    @Test
    void testFindAllByIds() {
        List<Long> drugIds = Arrays.asList(1L, 2L, 3L);
        List<Drug> expectedDrugs = Arrays.asList(
                DrugFactory.createTwoArgsDrug(1L, "Drug1"),
                DrugFactory.createTwoArgsDrug(2L, "Drug2"),
                DrugFactory.createTwoArgsDrug(3L, "Drug3"));

        when(drugRepository.findAllById(drugIds)).thenReturn(expectedDrugs);
        List<Drug> result = drugService.findAllByIds(drugIds);
        assertEquals(expectedDrugs.size(), result.size());
        assertEquals(expectedDrugs, result);
        verify(drugRepository, times(1)).findAllById(drugIds);
    }

    @Test
    void testSaveDrug() {
        Drug drugToSave = new Drug();
        drugToSave.setId(1L);
        drugToSave.setName("TestDrug");
        drugService.saveDrug(drugToSave);
        verify(drugRepository, times(1)).save(drugToSave);
    }

    @Test
    void testUpdateDrug() {
        Drug drugToUpdate = new Drug();
        drugToUpdate.setId(1L);
        drugToUpdate.setName("UpdatedDrug");
        drugService.updateDrug(drugToUpdate);
        verify(drugRepository, times(1)).save(drugToUpdate);
    }

    @Test
    void removeDrug() {
        Long drugId = 1L;
        Drug mockDrug = new Drug();
        mockDrug.setId(drugId);
        mockDrug.setName("TestDrug");

        when(drugRepository.findById(drugId)).thenReturn(Optional.of(mockDrug));

        drugService.removeDrug(drugId);
        verify(drugRepository, times(1)).findById(drugId);
        verify(drugRepository, times(1)).delete(mockDrug);
    }
}