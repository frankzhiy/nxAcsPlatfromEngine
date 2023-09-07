package com.zjubj.acs.nxacsplatfromengine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


/**
 * @author frank_zhiy
 * @date 2023/9/6
 * @Description
 */

@Data
public class BaseInfoDTO  {
    @JsonProperty("caseNumber")
    private String caseNumber;

    @JsonProperty("timeOfAdmission")
    private String timeOfAdmission;

    @JsonProperty("manageDoctors")
    private String manageDoctors;
}
