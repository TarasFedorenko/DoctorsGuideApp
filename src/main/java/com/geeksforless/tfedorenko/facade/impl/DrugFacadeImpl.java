package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.DrugFacade;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.entity.Disease;
import com.geeksforless.tfedorenko.service.DiseaseService;
import com.geeksforless.tfedorenko.service.DrugService;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import com.geeksforless.tfedorenko.web.dto.detail.DrugDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrugFacadeImpl implements DrugFacade {

    private final DrugService drugService;

    private final DiseaseService diseaseService;
    private final Set<Drug> temporaryDrugs = new HashSet<>();
    private final Set<Disease> temporaryDiseases = new HashSet<>();

    @Override
    public List<DrugDto> getDrugByFirstLetter(String letter) {
        List<Drug> drugList = drugService.getDrugByFirstLetter(letter);
        return drugList.stream().map(DrugDto::new).collect(Collectors.toList());
    }

    @Override
    public DrugDetailDto findByName(String name) {
        return drugService.findByName(name)
                .map(DrugDetailDto::new)
                .orElse(null);
    }

    @Override
    public List<DrugDto> findAll() {
        List<Drug> drugList = drugService.findAll();
        return drugList.stream().map(DrugDto::new).collect(Collectors.toList());
    }

    @Override
    public DrugDetailDto findById(Long id) {
        Optional<Drug> drugOptional = drugService.findById(id);
        return drugOptional.map(DrugDetailDto::new).orElseThrow(() -> new RuntimeException("Drug not found"));
    }

    @Override
    public void updateDrug(Drug drug) {
        drugService.updateDrug(drug);
    }

    @Override
    public void removeDrug(Long id) {
        drugService.removeDrug(id);
    }

    @Override
    public void createDrug(Drug newDrug) {
        List<Long> drugIds = convertSetToDrugIds();
        List<Drug> analogs = drugService.findAllByIds(drugIds);

        List<Long> diseaseIds = convertSetToDiseaseIds();
        List<Disease> diseases = diseaseService.findAllByIds(diseaseIds);

        newDrug.getDiseases().addAll(diseases);
        newDrug.getAnalogs().addAll(analogs);

        drugService.saveDrug(newDrug);
        clearTemporaryDiseaseList();
        clearTemporaryDrugList();
    }

    @Override
    public void addDiseaseToTempList(Long diseaseId) {
        Optional<Disease> optionalDisease = diseaseService.findById(diseaseId);
        if (optionalDisease.isPresent()) {
            Disease diseaseToAdd = optionalDisease.get();
            if (!temporaryDiseases.contains(diseaseToAdd)) {
                temporaryDiseases.add(diseaseToAdd);
            } else {
                throw new RuntimeException("Disease is already in the list");
            }
        } else {
            throw new RuntimeException("Disease not found");
        }
    }

    @Override
    public void addAnalogToTempList(Long id) {
        Optional<Drug> optionalDrug = drugService.findById(id);
        if (optionalDrug.isPresent()) {
            Drug drugToAdd = optionalDrug.get();
            if (!temporaryDrugs.contains(drugToAdd)) {
                temporaryDrugs.add(drugToAdd);
            } else {
                throw new RuntimeException("Drug is already in the list");
            }
        } else {
            throw new RuntimeException("Drug not found");
        }
    }

    private List<Long> convertSetToDrugIds() {
        return temporaryDrugs.stream()
                .map(Drug::getId)
                .collect(Collectors.toList());
    }

    private List<Long> convertSetToDiseaseIds() {
        return temporaryDiseases.stream()
                .map(Disease::getId)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Drug> getTemporaryDrugs() {
        return temporaryDrugs;
    }

    @Override
    public Set<Disease> getTemporaryDiseases() {
        return temporaryDiseases;
    }

    private void clearTemporaryDrugList() {
        temporaryDrugs.clear();
    }

    private void clearTemporaryDiseaseList() {
        temporaryDiseases.clear();
    }

    @Override
    public void removeAnalogFromNewDrug(Long drugId) {
        temporaryDrugs.removeIf(drug -> Objects.equals(drug.getId(), drugId));
    }

    @Override
    public void removeDiseaseFromNewDrug(Long diseaseId) {
        temporaryDiseases.removeIf(disease -> Objects.equals(disease.getId(), diseaseId));
    }
}
