package com.zjubj.acs.nxacsplatfromengine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author frank_zhiy
 * @date 2023/4/17
 * @Description
 */
@Data
public class TestEntityDTO {
    @JsonProperty("caseNumber")
    private String caseNumber;

    @JsonProperty("timeOfAdmission")
    private String timeOfAdmission;

    @JsonProperty("attribute")
    private Map<String, String> attribute;

    @JsonProperty("manageDoctors")
    private String manageDoctors;
}
