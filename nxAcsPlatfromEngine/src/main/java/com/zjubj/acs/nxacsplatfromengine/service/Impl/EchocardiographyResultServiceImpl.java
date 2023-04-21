package com.zjubj.acs.nxacsplatfromengine.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjubj.acs.nxacsplatfromengine.dao.EchocardiographyResultRepository;
import com.zjubj.acs.nxacsplatfromengine.dto.EchocardiographyEntityDTO;
import com.zjubj.acs.nxacsplatfromengine.entity.EchocardiographyEntity;
import com.zjubj.acs.nxacsplatfromengine.service.EchocardiographyResultService;
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
public class EchocardiographyResultServiceImpl implements EchocardiographyResultService {

    @Autowired
    private EchocardiographyResultRepository echocardiographyResultRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<EchocardiographyEntityDTO> findByCaseNumber(String caseNumber) {
        List<EchocardiographyEntity> echocardiographyResultEntities = echocardiographyResultRepository.findByCaseNumber(caseNumber);

        return echocardiographyResultEntities.stream()
                .map(this::convertToEchocardiographyEntityDTO)
                .collect(Collectors.toList());
    }

    private EchocardiographyEntityDTO convertToEchocardiographyEntityDTO(EchocardiographyEntity echocardiographyResultEntity) {
        EchocardiographyEntityDTO dto = new EchocardiographyEntityDTO();
        dto.setCaseNumber(echocardiographyResultEntity.getCaseNumber());
        dto.setTimeOfAdmission(echocardiographyResultEntity.getTimeOfAdmission());
        dto.setManageDoctors(echocardiographyResultEntity.getManageDoctors());

        try {
            Map<String, String> attributeMap = objectMapper.readValue(echocardiographyResultEntity.getAttribute(), Map.class);
            dto.setAttribute(attributeMap);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing attribute JSON", e);
        }

        return dto;
    }
}

