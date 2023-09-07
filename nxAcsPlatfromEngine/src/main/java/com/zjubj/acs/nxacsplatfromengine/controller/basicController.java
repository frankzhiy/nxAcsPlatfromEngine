package com.zjubj.acs.nxacsplatfromengine.controller;

import com.zjubj.acs.nxacsplatfromengine.dto.*;
import com.zjubj.acs.nxacsplatfromengine.dto.Util.ResultDTO;
import com.zjubj.acs.nxacsplatfromengine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author frank_zhiy
 * @date 2023/4/4
 * @Description
 */
@RestController
@RequestMapping("/basic")
public class basicController {
    @Autowired
    private UserListService userListService;

    @Autowired
    private TestResultService testResultService;

    @Autowired
    private MedicalHistoryResultService medicalHistoryResultService;

    @Autowired
    private FollowUpResultService followUpResultService;

    @Autowired
    private EchocardiographyResultService echocardiographyResultService;

    @Autowired
    private AngiographyResultService angiographyResultService;

    @Autowired
    private AllInfoSubmitService allInfoSubmitService;

    @RequestMapping(value="/userList", method = RequestMethod.GET)
    public List<Map<String, Object>> getUserListByManageDoctors(@RequestParam String manageDoctors) {
        return userListService.findByManageDoctors(manageDoctors);
    }

    @RequestMapping(value="/testResult", method = RequestMethod.GET)
    public List<TestEntityDTO> getTestResultByCaseNumber(@RequestParam String caseNumber) {
        return testResultService.findByCaseNumber(caseNumber);
    }

    @RequestMapping(value="/medicalHistoryResult", method = RequestMethod.GET)
    public List<MedicalHistoryEntityDTO> getMedicalHistoryResultByCaseNumber(@RequestParam String caseNumber) {
        return medicalHistoryResultService.findByCaseNumber(caseNumber);
    }

    @RequestMapping(value="/followUpResult", method = RequestMethod.GET)
    public List<FollowUpEntityDTO> getFollowUpResultByCaseNumber(@RequestParam String caseNumber) {
        return followUpResultService.findByCaseNumber(caseNumber);
    }

    @RequestMapping(value="/echocardiographyResult", method = RequestMethod.GET)
    public List<EchocardiographyEntityDTO> getEchocardiographyResultByCaseNumber(@RequestParam String caseNumber) {
        return echocardiographyResultService.findByCaseNumber(caseNumber);
    }

    @RequestMapping(value="/angiographyResult", method = RequestMethod.GET)
    public List<AngiographyEntityDTO> getAngiographyResultByCaseNumber(@RequestParam String caseNumber) {
        return angiographyResultService.findByCaseNumber(caseNumber);
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ResultDTO submitAllInfo(@RequestBody AllInfoDTO allInfoDTO) {
        allInfoSubmitService.submitInfo(allInfoDTO);
        return null;
    }

    @RequestMapping(value="/deleteInfo", method = RequestMethod.DELETE)
    public ResponseEntity<ResultDTO<String>> deleteInfoByCaseNumberAndTimeOfAdmission(
            @RequestParam String caseNumber,
            @RequestParam String timeOfAdmission) {

        ResultDTO<String> result = allInfoSubmitService.deleteInfo(caseNumber, timeOfAdmission);

        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}