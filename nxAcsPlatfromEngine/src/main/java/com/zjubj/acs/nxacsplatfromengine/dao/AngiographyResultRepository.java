package com.zjubj.acs.nxacsplatfromengine.dao;

import com.zjubj.acs.nxacsplatfromengine.entity.AngiographyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author frank_zhiy
 * @date 2023/4/17
 * @Description
 */
public interface AngiographyResultRepository extends JpaRepository<AngiographyEntity,String> {
    List<AngiographyEntity> findByCaseNumber(String caseNumber);
}
