package com.zjubj.acs.nxacsplatfromengine.controller;

import com.zjubj.acs.nxacsplatfromengine.service.MacePredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author frank_zhiy
 * @date 2023/10/31
 * @Description
 */

@RestController
@RequestMapping("/predict")
public class predictController {

    @Autowired
    private MacePredictService macePredictService;
    @RequestMapping(value = "/mace", method = RequestMethod.GET)
    public List<Map<String, Object>> getUserListByManageDoctors(@RequestParam String manageDoctors) {
        return macePredictService.findByManageDoctors(manageDoctors);
    }
}
