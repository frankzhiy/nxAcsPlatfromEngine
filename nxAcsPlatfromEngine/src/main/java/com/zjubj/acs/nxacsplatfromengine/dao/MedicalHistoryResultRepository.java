package com.zjubj.acs.nxacsplatfromengine.dao;

import com.zjubj.acs.nxacsplatfromengine.entity.MedicalHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author frank_zhiy
 * @date 2023/4/17
 * @Description
 */
public interface MedicalHistoryResultRepository extends JpaRepository<MedicalHistoryEntity, String>{
    List<MedicalHistoryEntity> findByCaseNumber(String caseNumber);
    void deleteByCaseNumberAndTimeOfAdmission(String caseNumber, String timeOfAdmission);

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n53') = '1'")
    int countByAttributeN53Is1();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n53') = '0'")
    int countByAttributeN53Is0();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n97') = '1'")
    int countByAttributeN97Is1();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n97') = '2'")
    int countByAttributeN97Is2();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n97') = '3'")
    int countByAttributeN97Is3();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n97') = '4'")
    int countByAttributeN97Is4();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n1') = '1'")
    int countByAttributeN1Is1();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n1') = '0'")
    int countByAttributeN1Is0();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n7') = '1'")
    int countByAttributeN7Is1();

    @Query("SELECT COUNT(m) FROM MedicalHistoryEntity m WHERE FUNCTION('JSON_EXTRACT', m.attribute, '$.n7') = '0'")
    int countByAttributeN7Is0();
}
