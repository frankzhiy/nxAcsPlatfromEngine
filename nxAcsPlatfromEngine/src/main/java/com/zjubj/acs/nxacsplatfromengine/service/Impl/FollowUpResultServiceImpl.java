package com.zjubj.acs.nxacsplatfromengine.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjubj.acs.nxacsplatfromengine.dao.FollowUpResultRepository;
import com.zjubj.acs.nxacsplatfromengine.dto.FollowUpEntityDTO;
import com.zjubj.acs.nxacsplatfromengine.entity.FollowUpEntity;
import com.zjubj.acs.nxacsplatfromengine.service.FollowUpResultService;
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
public class FollowUpResultServiceImpl implements FollowUpResultService {

    @Autowired
    private FollowUpResultRepository followUpResultRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<FollowUpEntityDTO> findByCaseNumber(String caseNumber) {
        List<FollowUpEntity> followUpResultEntities = followUpResultRepository.findByCaseNumber(caseNumber);

        return followUpResultEntities.stream()
                .map(this::convertToFollowUpEntityDTO)
                .collect(Collectors.toList());
    }

    private FollowUpEntityDTO convertToFollowUpEntityDTO(FollowUpEntity followUpResultEntity) {
        FollowUpEntityDTO dto = new FollowUpEntityDTO();
        dto.setCaseNumber(followUpResultEntity.getCaseNumber());
        dto.setTimeOfAdmission(followUpResultEntity.getTimeOfAdmission());
        dto.setManageDoctors(followUpResultEntity.getManageDoctors());

        try {
            Map<String, String> attributeMap = objectMapper.readValue(followUpResultEntity.getAttribute(), Map.class);
            dto.setAttribute(attributeMap);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing attribute JSON", e);
        }

        return dto;
    }
}
