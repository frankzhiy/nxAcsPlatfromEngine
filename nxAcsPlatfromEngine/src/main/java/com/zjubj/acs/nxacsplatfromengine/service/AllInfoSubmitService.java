package com.zjubj.acs.nxacsplatfromengine.service;

import com.zjubj.acs.nxacsplatfromengine.dto.AllInfoDTO;
import com.zjubj.acs.nxacsplatfromengine.dto.Util.ResultDTO;

/**
 * @author frank_zhiy
 * @date 2023/9/6
 * @Description
 */
public interface AllInfoSubmitService {


    ResultDTO<String> submitInfo(AllInfoDTO allInfoDTO);
    ResultDTO<String> deleteInfo(String caseNumber, String timeOfAdmission);
}
