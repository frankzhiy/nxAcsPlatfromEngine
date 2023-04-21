package com.zjubj.acs.nxacsplatfromengine.service;

import com.zjubj.acs.nxacsplatfromengine.dto.FollowUpEntityDTO;

import java.util.List;

/**
 * @author frank_zhiy
 * @date 2023/4/17
 * @Description
 */
public interface FollowUpResultService {
    List<FollowUpEntityDTO> findByCaseNumber(String caseNumber);
}
