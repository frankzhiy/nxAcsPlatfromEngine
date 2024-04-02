    package com.zjubj.acs.nxacsplatfromengine.dao;

    import com.zjubj.acs.nxacsplatfromengine.entity.UserListEntity;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;

    import java.util.List;

    /**
     * @author frank_zhiy
     * @date 2023/4/4
     * @Description
     */
    public interface UserListRepository extends JpaRepository<UserListEntity, String> {
        List<UserListEntity> findByManageDoctors(String manageDoctors);
        void deleteByCaseNumberAndTimeOfAdmission(String caseNumber, String timeOfAdmission);

        @Query("SELECT COUNT(u) FROM UserListEntity u WHERE FUNCTION('JSON_EXTRACT', u.attribute, '$.sex') = '1'")
        int countByAttributeSexIs1();

        @Query("SELECT COUNT(u) FROM UserListEntity u WHERE FUNCTION('JSON_EXTRACT', u.attribute, '$.sex') = '2'")
        int countByAttributeSexIs2();

        @Query(value = "SELECT JSON_EXTRACT(u.attribute, '$.age') FROM user_list u", nativeQuery = true)
        List<String> findAllAges();

        @Query(value = "SELECT JSON_EXTRACT(u.attribute, '$.BMI') FROM user_list u", nativeQuery = true)
        List<String> findAllBMIs();

        @Query("SELECT u.timeOfAdmission FROM UserListEntity u")
        List<String> findAllTimeOfAdmissions();

    }
