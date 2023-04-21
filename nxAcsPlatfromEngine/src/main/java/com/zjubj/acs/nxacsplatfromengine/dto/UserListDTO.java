package com.zjubj.acs.nxacsplatfromengine.dto;

import lombok.Data;

import java.sql.Date;

/**
 * @author frank_zhiy
 * @date 2023/4/4
 * @Description
 */
@Data
public class UserListDTO {
    private long serialNumber;
    private String caseNumber;
    private String timeOfAdmission;
}
