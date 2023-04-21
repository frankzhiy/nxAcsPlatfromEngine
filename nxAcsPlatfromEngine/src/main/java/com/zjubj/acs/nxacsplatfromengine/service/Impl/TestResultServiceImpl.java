package com.zjubj.acs.nxacsplatfromengine.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjubj.acs.nxacsplatfromengine.dao.TestResultRepository;
import com.zjubj.acs.nxacsplatfromengine.dto.TestEntityDTO;
import com.zjubj.acs.nxacsplatfromengine.entity.TestEntity;
import com.zjubj.acs.nxacsplatfromengine.service.TestResultService;
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
public class TestResultServiceImpl implements TestResultService {
    @Autowired
    private TestResultRepository testResultRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<TestEntityDTO> findByCaseNumber(String caseNumber) {
        List<TestEntity> testEntities = testResultRepository.findByCaseNumber(caseNumber);

        return testEntities.stream()
                .map(this::convertToTestEntityDTO)
                .collect(Collectors.toList());
    }

    private TestEntityDTO convertToTestEntityDTO(TestEntity testEntity) {
        TestEntityDTO dto = new TestEntityDTO();
        dto.setCaseNumber(testEntity.getCaseNumber());
        dto.setTimeOfAdmission(testEntity.getTimeOfAdmission());
        dto.setManageDoctors(testEntity.getManageDoctors());

        try {
            Map<String, String> attributeMap = objectMapper.readValue(testEntity.getAttribute(), Map.class);
            dto.setAttribute(attributeMap);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing attribute JSON", e);
        }

        return dto;
    }

//    @Autowired
//    private TestResultRepository testResultRepository;
//
//    @Override
//    public List<TestEntity> findByCaseNumber(String caseNumber) {
//        return testResultRepository.findByCaseNumber(caseNumber);
//    }
}
