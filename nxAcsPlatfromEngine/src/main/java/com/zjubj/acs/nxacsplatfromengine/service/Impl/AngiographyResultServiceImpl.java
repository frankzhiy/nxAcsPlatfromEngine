package com.zjubj.acs.nxacsplatfromengine.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjubj.acs.nxacsplatfromengine.dao.AngiographyResultRepository;
import com.zjubj.acs.nxacsplatfromengine.dto.AngiographyEntityDTO;
import com.zjubj.acs.nxacsplatfromengine.entity.AngiographyEntity;
import com.zjubj.acs.nxacsplatfromengine.service.AngiographyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author frank_zhiy
 * @date 2023/4/17
 * @Description
 */
@Service
public class AngiographyResultServiceImpl implements AngiographyResultService {

    @Autowired
    private AngiographyResultRepository angiographyResultRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<AngiographyEntityDTO> findByCaseNumber(String caseNumber) {
        List<AngiographyEntity> angiographyResultEntities = angiographyResultRepository.findByCaseNumber(caseNumber);

        return angiographyResultEntities.stream()
                .map(this::convertToAngiographyEntityDTO)
                .collect(Collectors.toList());
    }

    private AngiographyEntityDTO convertToAngiographyEntityDTO(AngiographyEntity angiographyResultEntity) {
        AngiographyEntityDTO dto = new AngiographyEntityDTO();
        dto.setCaseNumber(angiographyResultEntity.getCaseNumber());
        dto.setTimeOfAdmission(angiographyResultEntity.getTimeOfAdmission());
        dto.setManageDoctors(angiographyResultEntity.getManageDoctors());

        try {
            Map<String, String> attributeMap = objectMapper.readValue(angiographyResultEntity.getAttribute(), Map.class);
            dto.setAttribute(attributeMap);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing attribute JSON", e);
        }

        return dto;
    }

}