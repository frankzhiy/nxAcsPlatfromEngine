package com.zjubj.acs.nxacsplatfromengine.dao;

import com.zjubj.acs.nxacsplatfromengine.entity.MacePredictEntity;
import com.zjubj.acs.nxacsplatfromengine.entity.UserListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author frank_zhiy
 * @date 2023/10/31
 * @Description
 */
public interface MacePredictRepository extends JpaRepository<MacePredictEntity, String> {
    List<MacePredictEntity> findByManageDoctors(String manageDoctors);
}
