package com.zjubj.acs.nxacsplatfromengine.dao;

import com.zjubj.acs.nxacsplatfromengine.entity.UserListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author frank_zhiy
 * @date 2023/4/4
 * @Description
 */
public interface UserListRepository extends JpaRepository<UserListEntity, String> {
    List<UserListEntity> findByManageDoctors(String manageDoctors);
    void deleteByCaseNumberAndTimeOfAdmission(String caseNumber, String timeOfAdmission);

}
