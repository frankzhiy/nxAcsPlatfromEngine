package com.zjubj.acs.nxacsplatfromengine.dao;

import com.zjubj.acs.nxacsplatfromengine.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author frank_zhiy
 * @date 2023/4/17
 * @Description
 */
public interface TestResultRepository extends JpaRepository<TestEntity, String> {
    List<TestEntity> findByCaseNumber(String caseNumber);
    void deleteByCaseNumberAndTimeOfAdmission(String caseNumber, String timeOfAdmission);

}
