package com.zjubj.acs.nxacsplatfromengine.service;

import java.util.List;
import java.util.Map;

/**
 * @author frank_zhiy
 * @date 2023/10/31
 * @Description
 */
public interface MacePredictService {
    List<Map<String, Object>> findByManageDoctors(String manageDoctors);
}
