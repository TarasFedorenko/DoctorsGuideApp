package com.geeksforless.tfedorenko.facade.impl;

import com.geeksforless.tfedorenko.facade.DrugFacade;
import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.service.DrugService;
import com.geeksforless.tfedorenko.web.dto.DrugDto;
import com.geeksforless.tfedorenko.web.dto.detail.DrugDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DrugFacadeImpl implements DrugFacade {

    private final DrugService drugService;
    private final Set<Drug> temporaryDrugs = new HashSet<>();
    @Override
    public List<DrugDto> getDrugByFirstLetter(String letter) {
        List<Drug> drugList = drugService.getDrugByFirstLetter(letter);
        return drugList.stream().map(DrugDto::new).collect(Collectors.toList());
    }

    @Override
    public DrugDetailDto findByName(String name) {
        return drugService.findByName(name)
                .map(DrugDetailDto::new)
                .orElseThrow(() -> new RuntimeException("Drug not found"));
    }

    @Override
    public List<DrugDto> findAll() {
        List<Drug> drugList = drugService.findAll();
        return drugList.stream().map(DrugDto::new).collect(Collectors.toList());
    }

    @Override
    public DrugDetailDto findById(Long id) {
        Optional<Drug> drugOptional = drugService.findById(id);
        return drugOptional.map(DrugDetailDto::new).orElseThrow(()-> new RuntimeException("Drug not found"));
    }

    @Override
    public void createDrug(Drug newDrug) {
        List<Long> drugIds = convertSetToDrugIds(temporaryDrugs);
        List<Drug> analogs = drugService.findAllByIds(drugIds);

        newDrug.getAnalogs().addAll(analogs);

        drugService.saveDrug(newDrug);
        clearTemporaryList();
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
    private List<Long> convertSetToDrugIds(Set<Drug> temporaryDrugs) {
        return temporaryDrugs.stream()
                .map(Drug::getId)
                .collect(Collectors.toList());
    }
    @Override
    public Set<Drug> getTemporaryDrugs() {
        return temporaryDrugs;
    }

    private void clearTemporaryList() {
        temporaryDrugs.clear();
    }

}
