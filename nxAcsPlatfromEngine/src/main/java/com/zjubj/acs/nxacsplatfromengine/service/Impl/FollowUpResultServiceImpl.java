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

        //TODO:这里是个蠢办法，把所有空值都进行了替换，后续需要优化
        String defaultAttributeJson = "{\"b3\":\"\",\"n1\":\"\",\"n2\":\"\",\"n3\":\"\",\"n4\":\"\",\"n5\":\"\",\"n6\":\"\",\"n7\":\"\",\"d1\":\"\",\"d2\":\"\",\"d3\":\"\",\"d31\":\"\",\"d32\":\"\",\"i1\":\"\",\"n0\":\"\",\"i11\":\"\",\"i12\":\"\",\"i13\":\"\",\"i131\":\"\",\"i132\":\"\",\"i133\":\"\",\"i134\":\"\",\"i14\":\"\",\"i141\":\"\",\"i142\":\"\",\"i21\":\"\",\"i22\":\"\",\"i23\":\"\",\"i231\":\"\",\"i232\":\"\",\"i233\":\"\",\"i234\":\"\",\"i24\":\"\",\"i241\":\"\",\"i242\":\"\",\"i31\":\"\",\"i32\":\"\",\"i33\":\"\",\"i331\":\"\",\"i332\":\"\",\"i333\":\"\",\"i334\":\"\",\"i34\":\"\",\"i341\":\"\",\"i342\":\"\",\"a1\":\"\",\"n01\":\"\",\"a11\":\"\",\"a12\":\"\",\"a13o\":\"\",\"a131\":\"\",\"a132\":\"\",\"a133\":\"\",\"a134\":\"\",\"a135\":\"\",\"a1351\":\"\",\"a21\":\"\",\"a22\":\"\",\"a23o\":\"\",\"a231\":\"\",\"a232\":\"\",\"a233\":\"\",\"a234\":\"\",\"a235\":\"\",\"a2351\":\"\",\"a31\":\"\",\"a32\":\"\",\"a33o\":\"\",\"a331\":\"\",\"a332\":\"\",\"a333\":\"\",\"a334\":\"\",\"a335\":\"\",\"a3351\":\"\",\"r1\":\"\",\"r11\":\"\",\"r12\":\"\",\"r13\":\"\",\"r14\":\"\",\"r15\":\"\",\"r16\":\"\",\"r161\":\"\",\"r162\":\"\",\"r163\":\"\",\"r164\":\"\",\"f1\":\"\",\"f11\":\"\",\"f12\":\"\",\"f23\":\"\",\"s1\":\"\",\"s11\":\"\",\"s12\":\"\",\"b4\":\"\",\"b11\":\"\",\"b12\":\"\",\"b13\":\"\",\"p0\":\"\",\"p11\":\"\",\"p12\":\"\",\"p131\":\"\",\"p132\":\"\",\"p133\":\"\",\"p134\":\"\",\"p135\":\"\",\"p136\":\"\",\"p21\":\"\",\"p22\":\"\",\"p231\":\"\",\"p232\":\"\",\"p233\":\"\",\"p234\":\"\",\"p235\":\"\",\"p236\":\"\",\"p31\":\"\",\"p32\":\"\",\"p331\":\"\",\"p332\":\"\",\"p333\":\"\",\"p334\":\"\",\"p335\":\"\",\"p336\":\"\",\"p337\":\"\",\"p40\":\"\",\"p41\":\"\",\"p42\":\"\",\"p431\":\"\",\"p432\":\"\",\"p433\":\"\",\"p434\":\"\",\"p435\":\"\",\"p51\":\"\",\"p52\":\"\",\"p61\":\"\",\"p62\":\"\",\"p71\":\"\",\"p72\":\"\",\"p81\":\"\",\"p82\":\"\",\"p91\":\"\",\"p92\":\"\",\"p101\":\"\",\"p102\":\"\",\"p13\":\"\"}";

        try {
            String attributeJson = (followUpResultEntity.getAttribute() != null) ? followUpResultEntity.getAttribute() : defaultAttributeJson;
            Map<String, String> attributeMap = objectMapper.readValue(attributeJson, Map.class);
            dto.setAttribute(attributeMap);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing attribute JSON", e);
        }

        return dto;
//        try {
//            Map<String, String> attributeMap = objectMapper.readValue(followUpResultEntity.getAttribute(), Map.class);
//            dto.setAttribute(attributeMap);
//        } catch (Exception e) {
//            throw new RuntimeException("Error parsing attribute JSON", e);
//        }


    }
}
