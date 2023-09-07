package com.zjubj.acs.nxacsplatfromengine.service.Impl;

import com.zjubj.acs.nxacsplatfromengine.dao.*;
import com.zjubj.acs.nxacsplatfromengine.dto.AllInfoDTO;
import com.zjubj.acs.nxacsplatfromengine.dto.Util.ResultDTO;
import com.zjubj.acs.nxacsplatfromengine.entity.*;
import com.zjubj.acs.nxacsplatfromengine.service.AllInfoSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author frank_zhiy
 * @date 2023/9/6
 * @Description
 */

@Service
public class AllInfoSubmitServiceImpl implements AllInfoSubmitService {

    @Autowired
    private UserListRepository userListRepository;
    @Autowired
    private AngiographyResultRepository angiographyResultRepository;

    @Autowired
    private EchocardiographyResultRepository echocardiographyResultRepository;

    @Autowired
    private FollowUpResultRepository followUpResultRepository;

    @Autowired
    private MedicalHistoryResultRepository medicalHistoryResultRepository;

    @Autowired
    private TestResultRepository testResultRepository;
    @Override
    public ResultDTO submitInfo(AllInfoDTO allInfoDTO) {
        ResultDTO resultDTO = new ResultDTO();

        try {
            UserListEntity entity = new UserListEntity();
            entity.setCaseNumber(allInfoDTO.getBaseInfo().get("caseNumber").toString().replace("\"", ""));
            entity.setTimeOfAdmission(allInfoDTO.getBaseInfo().get("timeOfAdmission").toString().replace("\"", ""));
            entity.setManageDoctors(allInfoDTO.getBaseInfo().get("manageDoctors").toString().replace("\"", ""));
            userListRepository.save(entity);

            String originalTimeOfAdmission = allInfoDTO.getBaseInfo().get("timeOfAdmission").toString().replace("\"", "");
            String convertedTimeOfAdmission = convertDateFormat(originalTimeOfAdmission);

            MedicalHistoryEntity medicalHistoryEntity = new MedicalHistoryEntity();
            medicalHistoryEntity.setCaseNumber(allInfoDTO.getBaseInfo().get("caseNumber").toString().replace("\"", ""));
            medicalHistoryEntity.setTimeOfAdmission(convertedTimeOfAdmission);
            medicalHistoryEntity.setManageDoctors(allInfoDTO.getBaseInfo().get("manageDoctors").toString().replace("\"", ""));
            medicalHistoryEntity.setAttribute(allInfoDTO.getMedicalHistory().toString());
            medicalHistoryResultRepository.save(medicalHistoryEntity);

            AngiographyEntity angiographyEntity = new AngiographyEntity();
            angiographyEntity.setCaseNumber(allInfoDTO.getBaseInfo().get("caseNumber").toString().replace("\"", ""));
            angiographyEntity.setTimeOfAdmission(convertedTimeOfAdmission);
            angiographyEntity.setManageDoctors(allInfoDTO.getBaseInfo().get("manageDoctors").toString().replace("\"", ""));
            angiographyEntity.setAttribute(allInfoDTO.getAngiography().toString());
            angiographyResultRepository.save(angiographyEntity);

            EchocardiographyEntity echocardiographyEntity = new EchocardiographyEntity();
            echocardiographyEntity.setCaseNumber(allInfoDTO.getBaseInfo().get("caseNumber").toString().replace("\"", ""));
            echocardiographyEntity.setTimeOfAdmission(convertedTimeOfAdmission);
            echocardiographyEntity.setManageDoctors(allInfoDTO.getBaseInfo().get("manageDoctors").toString().replace("\"", ""));
            echocardiographyEntity.setAttribute(allInfoDTO.getEchocardiography().toString());
            echocardiographyResultRepository.save(echocardiographyEntity);

            FollowUpEntity followUpEntity = new FollowUpEntity();
            followUpEntity.setCaseNumber(allInfoDTO.getBaseInfo().get("caseNumber").toString().replace("\"", ""));
            followUpEntity.setTimeOfAdmission(convertedTimeOfAdmission);
            followUpEntity.setManageDoctors(allInfoDTO.getBaseInfo().get("manageDoctors").toString().replace("\"", ""));
            followUpEntity.setAttribute(allInfoDTO.getFollowUp().toString());
            followUpResultRepository.save(followUpEntity);

            TestEntity testEntity = new TestEntity();
            testEntity.setCaseNumber(allInfoDTO.getBaseInfo().get("caseNumber").toString().replace("\"", ""));
            testEntity.setTimeOfAdmission(convertedTimeOfAdmission);
            testEntity.setManageDoctors(allInfoDTO.getBaseInfo().get("manageDoctors").toString().replace("\"", ""));
            testEntity.setAttribute(allInfoDTO.getTest().toString());
            testResultRepository.save(testEntity);

            resultDTO.setSuccess(true);
        } catch (Exception e) {
            resultDTO.sendFailedMessage(e);
        }


//        System.out.println("Received BaseInfo: " + allInfoDTO.getBaseInfo());
//        System.out.println("Received BaseInfo: " + allInfoDTO.getMedicalHistory());
//        System.out.println("Received BaseInfo: " + allInfoDTO.getAngiography());
//        System.out.println("Received BaseInfo: " + allInfoDTO.getTest());
        System.out.println("Received BaseInfo: " + allInfoDTO.getFollowUp());
//        System.out.println("Received BaseInfo: " + allInfoDTO.getEchocardiography());
        return resultDTO;
    }

    private String convertDateFormat(String originalDate) {
        if (originalDate == null || originalDate.trim().isEmpty()) {
            return null;
        }
        String[] parts = originalDate.split("-");
        if (parts.length != 3) {
            return null;
        }
        return parts[2] + "/" + parts[1] + "/" + parts[0];
    }
}
