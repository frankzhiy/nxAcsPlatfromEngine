package com.zjubj.acs.nxacsplatfromengine.service;

import com.zjubj.acs.nxacsplatfromengine.dto.EchocardiographyEntityDTO;

import java.util.List;

/**
 * @author frank_zhiy
 * @date 2023/4/17
 * @Description
 */
public interface EchocardiographyResultService {
    List<EchocardiographyEntityDTO> findByCaseNumber(String caseNumber);
}
