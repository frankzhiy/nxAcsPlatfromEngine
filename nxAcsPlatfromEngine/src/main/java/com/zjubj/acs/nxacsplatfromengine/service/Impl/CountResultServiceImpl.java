package com.zjubj.acs.nxacsplatfromengine.service.Impl;

import com.zjubj.acs.nxacsplatfromengine.dao.AngiographyResultRepository;
import com.zjubj.acs.nxacsplatfromengine.dao.MedicalHistoryResultRepository;
import com.zjubj.acs.nxacsplatfromengine.dao.UserListRepository;
import com.zjubj.acs.nxacsplatfromengine.service.CountResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author frank_zhiy
 * @date 2023/9/14
 * @Description
 */

@Service
public class CountResultServiceImpl implements CountResultService {

    @Autowired
    private UserListRepository userListRepository;

    @Autowired
    private MedicalHistoryResultRepository medicalHistoryResultRepository;

    @Autowired
    private AngiographyResultRepository angiographyResultRepository;

    public int getMaleCount() {
        return userListRepository.countByAttributeSexIs1();
    }

    public int getFemaleCount() {
        return userListRepository.countByAttributeSexIs2();
    }

    public int getSmokeCount() {
        return medicalHistoryResultRepository.countByAttributeN53Is1();
    }

    public int getNoSmokeCount() {
        return medicalHistoryResultRepository.countByAttributeN53Is0();
    }

    public int getStemDiagnosisCount() {
        return medicalHistoryResultRepository.countByAttributeN97Is1();
    }

    public int getNonStemDiagnosisCount() {
        return medicalHistoryResultRepository.countByAttributeN97Is2();
    }

    public int getUaDiagnosisCount() {
        return medicalHistoryResultRepository.countByAttributeN97Is3();
    }

    public int getOtherDiagnosisCount() {
        return medicalHistoryResultRepository.countByAttributeN97Is4();
    }

    public int getDiabetesCount() {
        return medicalHistoryResultRepository.countByAttributeN1Is1();
    }

    public int getNoDiabetesCount() {
        return medicalHistoryResultRepository.countByAttributeN1Is0();
    }

    public int getHypertensionCount() {
        return medicalHistoryResultRepository.countByAttributeN7Is1();
    }

    public int getNoHypertensionCount() {
        return medicalHistoryResultRepository.countByAttributeN7Is0();
    }

    public int getOperateCount() {
        return angiographyResultRepository.countByAttributeOperateIs1();
    }

    public int getNoOperateCount() {
        return angiographyResultRepository.countByAttributeOperateIs0();
    }

    public Map<String, Long> getAllAgesGroupedByRange() {
        List<String> agesStr = userListRepository.findAllAges();

        // 转换并分类
        List<Integer> ages = agesStr.stream()
                .filter(ageStr -> ageStr != null && !ageStr.trim().isEmpty() && isNumeric(ageStr.replace("\"", "").trim()))
                .map(ageStr -> Integer.parseInt(ageStr.replace("\"", "").trim()))
                .collect(Collectors.toList());

        Map<String, Long> result = new HashMap<>();
        result.put("青年", ages.stream().filter(age -> age >= 18 && age <= 45).count());
        result.put("中年", ages.stream().filter(age -> age > 45 && age <= 65).count());
        result.put("老年", ages.stream().filter(age -> age > 65 && age <= 75).count());
        result.put("老老年", ages.stream().filter(age -> age > 75).count());

        return result;
    }

    public Map<String, Long> getBMIStatistics() {
        List<String> bmisStr = userListRepository.findAllBMIs();

        // Convert and categorize
        List<Double> bmis = bmisStr.stream()
                .filter(bmiStr -> bmiStr != null && !bmiStr.trim().isEmpty() && isNumericDouble(bmiStr.replace("\"", "").trim()))
                .map(bmiStr -> Double.parseDouble(bmiStr.replace("\"", "").trim()))
                .collect(Collectors.toList());

        Map<String, Long> result = new HashMap<>();
        result.put("消瘦", bmis.stream().filter(bmi -> bmi < 18.5).count());
        result.put("正常", bmis.stream().filter(bmi -> bmi >= 18.5 && bmi < 24).count());
        result.put("超重", bmis.stream().filter(bmi -> bmi >= 24 && bmi < 28).count());
        result.put("肥胖", bmis.stream().filter(bmi -> bmi >= 28).count());

        return result;
    }

    public Map<String, Long> getTimeOfAdmissionDuplicates() {
        List<String> times = userListRepository.findAllTimeOfAdmissions();

        return times.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private boolean isNumericDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
