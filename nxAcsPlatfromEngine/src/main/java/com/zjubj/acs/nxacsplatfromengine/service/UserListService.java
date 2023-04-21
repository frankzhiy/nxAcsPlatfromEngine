package com.zjubj.acs.nxacsplatfromengine.service;

import com.zjubj.acs.nxacsplatfromengine.entity.UserListEntity;

import java.util.List;
import java.util.Map;

/**
 * @author frank_zhiy
 * @date 2023/4/4
 * @Description
 */
public interface UserListService {
    List<Map<String, Object>> findByManageDoctors(String manageDoctors);
}
