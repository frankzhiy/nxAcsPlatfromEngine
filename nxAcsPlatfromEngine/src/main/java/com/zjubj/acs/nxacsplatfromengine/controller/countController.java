package com.zjubj.acs.nxacsplatfromengine.controller;

import com.zjubj.acs.nxacsplatfromengine.service.CountResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author frank_zhiy
 * @date 2023/9/14
 * @Description
 */

@RestController
@RequestMapping("/count")
public class countController {
    @Autowired
    CountResultService countResultService;

    @RequestMapping(value = "/sex", method = RequestMethod.GET)
    public Map<String, Integer> getSexCount() {
        Map<String, Integer> result = new HashMap<>();
        result.put("male", countResultService.getMaleCount());
        result.put("female", countResultService.getFemaleCount());
        return result;
    }

    @RequestMapping(value = "/smoke", method = RequestMethod.GET)
    public Map<String, Integer> getSmokeCount() {
        Map<String, Integer> result = new HashMap<>();
        result.put("smoke", countResultService.getSmokeCount());
        result.put("noSmoke", countResultService.getNoSmokeCount());
        return result;
    }

    @RequestMapping(value = "/diagnosis", method = RequestMethod.GET)
    public Map<String, Integer> getDiagnosisCount() {
        Map<String, Integer> result = new HashMap<>();
        result.put("stemDiagnosis", countResultService.getStemDiagnosisCount());
        result.put("nonStemDiagnosis", countResultService.getNonStemDiagnosisCount());
        result.put("uaDiagnosis", countResultService.getUaDiagnosisCount());
        result.put("otherDiagnosis", countResultService.getOtherDiagnosisCount());
        return result;
    }
    @RequestMapping(value = "/operate", method = RequestMethod.GET)
    public Map<String, Integer> getOperateCount() {
        Map<String, Integer> result = new HashMap<>();
        result.put("operate", countResultService.getOperateCount());
        result.put("noOperate", countResultService.getNoOperateCount());
        return result;
    }

    @RequestMapping(value = "/diabetes", method = RequestMethod.GET)
    public Map<String, Integer> getDiabetesCount() {
        Map<String, Integer> result = new HashMap<>();
        result.put("diabetes", countResultService.getDiabetesCount());
        result.put("noDiabetes", countResultService.getNoDiabetesCount());
        return result;
    }

    @RequestMapping(value = "/hypertension", method = RequestMethod.GET)
    public Map<String, Integer> getHypertensionCount() {
        Map<String, Integer> result = new HashMap<>();
        result.put("hypertension", countResultService.getHypertensionCount());
        result.put("noHypertension", countResultService.getNoHypertensionCount());
        return result;
    }
    @RequestMapping(value = "/age", method = RequestMethod.GET)
    public Map<String, Long> getAgeStatistics() {
        return countResultService.getAllAgesGroupedByRange();
    }

    @RequestMapping(value = "/bmi", method = RequestMethod.GET)
    public Map<String, Long> getBMIStatistics() {
        return countResultService.getBMIStatistics();
    }


    @RequestMapping(value = "/timeOfAdmission", method = RequestMethod.GET)
    public Map<String, Long> getDuplicateTimeOfAdmissions() {
        return countResultService.getTimeOfAdmissionDuplicates();
    }

}
