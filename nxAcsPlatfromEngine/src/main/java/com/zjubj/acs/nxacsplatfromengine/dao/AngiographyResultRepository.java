package com.zjubj.acs.nxacsplatfromengine.dao;

import com.zjubj.acs.nxacsplatfromengine.entity.AngiographyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author frank_zhiy
 * @date 2023/4/17
 * @Description
 */
public interface AngiographyResultRepository extends JpaRepository<AngiographyEntity,String> {
    List<AngiographyEntity> findByCaseNumber(String caseNumber);
    void deleteByCaseNumberAndTimeOfAdmission(String caseNumber, String timeOfAdmission);

    @Query("SELECT COUNT(a) FROM AngiographyEntity a WHERE FUNCTION('JSON_EXTRACT', a.attribute, '$.operate') = '1'")
    int countByAttributeOperateIs1();

    @Query("SELECT COUNT(a) FROM AngiographyEntity a WHERE FUNCTION('JSON_EXTRACT', a.attribute, '$.operate') = '0'")
    int countByAttributeOperateIs0();
}
