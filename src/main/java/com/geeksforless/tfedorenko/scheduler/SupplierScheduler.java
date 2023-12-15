package com.geeksforless.tfedorenko.scheduler;


import com.geeksforless.tfedorenko.persistence.entity.Drug;
import com.geeksforless.tfedorenko.persistence.repository.DrugRepository;
import com.geeksforless.tfedorenko.web.dto.DrugQuantityDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierScheduler {

    @Value("${supplier_base.auth.token}")
    private String supplierAuthToken;

    @Value("${supplier_base.url}")
    private String supplierUrl;

    private final DrugRepository drugRepository;

    @Scheduled(cron = "0 * * ? * *")
    public void callToSupplier() {
        List<String> articleList = drugRepository.findAllArticleWhereQuantityIsZero();
        if (CollectionUtils.isNotEmpty(articleList)) {
            StringBuilder queryBuilder = new StringBuilder("/api/drugs?article=");
            for (String article : articleList) {
                queryBuilder.append(article);
                queryBuilder.append(",");
            }
            final String url = supplierUrl + queryBuilder;
            final RestTemplate restTemplate = new RestTemplate();
            final HttpHeaders headers = new HttpHeaders();
            headers.add("Auth-token", supplierAuthToken);
            HttpEntity<DrugQuantityDto[]> entity = new HttpEntity<>(headers);
            ResponseEntity<DrugQuantityDto[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    DrugQuantityDto[].class);
            if (response.getStatusCodeValue() == 200) {
                DrugQuantityDto[] body = response.getBody();
                if (ArrayUtils.isNotEmpty(body)) {
                    List<DrugQuantityDto> dtoList = Arrays.asList(body);
                    List<Drug> drugs = drugRepository.findAllByArticleIn(articleList);
                    for (Drug drug : drugs) {
                        DrugQuantityDto dto = dtoList
                                .stream()
                                .filter(drugQuantityDto -> drugQuantityDto.getArticle().equals(drug.getArticle()))
                                .findFirst()
                                .get();
                        drug.setQuantity(dto.getQuantity());
                    }
                    drugRepository.saveAll(drugs);
                }
            }
        }
    }
}