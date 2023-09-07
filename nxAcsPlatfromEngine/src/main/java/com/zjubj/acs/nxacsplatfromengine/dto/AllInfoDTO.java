package com.zjubj.acs.nxacsplatfromengine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @author frank_zhiy
 * @date 2023/9/6
 * @Description
 */

@Data
public class AllInfoDTO {

    private JsonNode baseInfo;

    private JsonNode medicalHistory;

    private JsonNode angiography;

    private JsonNode echocardiography;

    private JsonNode followUp;

    private JsonNode test;

}
