package com.zjubj.acs.nxacsplatfromengine.service;

import java.util.List;
import java.util.Map;

/**
 * @author frank_zhiy
 * @date 2023/9/14
 * @Description
 */
public interface CountResultService {
    int getMaleCount();
    int getFemaleCount();
    int getSmokeCount();
    int getNoSmokeCount();
    int getStemDiagnosisCount();
    int getNonStemDiagnosisCount();
    int getUaDiagnosisCount();
    int getOtherDiagnosisCount();
    int getDiabetesCount();
    int getNoDiabetesCount();
    int getHypertensionCount();
    int getNoHypertensionCount();
    int getOperateCount();
    int getNoOperateCount();
    Map<String, Long> getAllAgesGroupedByRange();
    Map<String, Long> getBMIStatistics();
    Map<String, Long> getTimeOfAdmissionDuplicates();
}
