package com.zjubj.acs.nxacsplatfromengine.service.Impl;

import com.zjubj.acs.nxacsplatfromengine.dao.UserListRepository;
import com.zjubj.acs.nxacsplatfromengine.entity.UserListEntity;
import com.zjubj.acs.nxacsplatfromengine.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author frank_zhiy
 * @date 2023/4/4
 * @Description
 */
@Service
public class UserListServiceImpl implements UserListService {
    @Autowired
    private UserListRepository userListRepository;

    public List<Map<String, Object>> findByManageDoctors(String manageDoctors) {
        List<UserListEntity> users = userListRepository.findByManageDoctors(manageDoctors);
        List<Map<String, Object>> outputList = new ArrayList<>();

        for (UserListEntity user : users) {
            Map<String, Object> userMap = new LinkedHashMap<>();
            userMap.put("serialNumber", user.getSerialNumber());
            userMap.put("caseNumber", user.getCaseNumber());
            userMap.put("timeOfAdmission", user.getTimeOfAdmission());
            userMap.put("manageDoctors", user.getManageDoctors());
            userMap.put("attribute", user.getAttribute());

            outputList.add(userMap);
        }

        return outputList;
    }
}