package com.zjubj.acs.nxacsplatfromengine.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjubj.acs.nxacsplatfromengine.dao.MedicalHistoryResultRepository;
import com.zjubj.acs.nxacsplatfromengine.dto.MedicalHistoryEntityDTO;
import com.zjubj.acs.nxacsplatfromengine.entity.MedicalHistoryEntity;
import com.zjubj.acs.nxacsplatfromengine.service.MedicalHistoryResultService;
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
public class MedicalHistoryResultServiceImpl implements MedicalHistoryResultService {

    @Autowired
    private MedicalHistoryResultRepository medicalHistoryResultRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<MedicalHistoryEntityDTO> findByCaseNumber(String caseNumber) {
        List<MedicalHistoryEntity> medicalHistoryResultEntities = medicalHistoryResultRepository.findByCaseNumber(caseNumber);

        return medicalHistoryResultEntities.stream()
                .map(this::convertToMedicalHistoryEntityDTO)
                .collect(Collectors.toList());
    }

    private MedicalHistoryEntityDTO convertToMedicalHistoryEntityDTO(MedicalHistoryEntity medicalHistoryResultEntity) {
        MedicalHistoryEntityDTO dto = new MedicalHistoryEntityDTO();
        dto.setCaseNumber(medicalHistoryResultEntity.getCaseNumber());
        dto.setTimeOfAdmission(medicalHistoryResultEntity.getTimeOfAdmission());
        dto.setManageDoctors(medicalHistoryResultEntity.getManageDoctors());

        try {
            Map<String, String> attributeMap = objectMapper.readValue(medicalHistoryResultEntity.getAttribute(), Map.class);
            dto.setAttribute(attributeMap);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing attribute JSON", e);
        }

        return dto;
    }
}
