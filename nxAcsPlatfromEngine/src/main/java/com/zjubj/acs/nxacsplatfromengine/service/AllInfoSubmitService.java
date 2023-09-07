package com.zjubj.acs.nxacsplatfromengine.service;

import com.zjubj.acs.nxacsplatfromengine.dto.AllInfoDTO;
import com.zjubj.acs.nxacsplatfromengine.dto.Util.ResultDTO;

/**
 * @author frank_zhiy
 * @date 2023/9/6
 * @Description
 */
public interface AllInfoSubmitService {


    ResultDTO submitInfo(AllInfoDTO allInfoDTO);
}
