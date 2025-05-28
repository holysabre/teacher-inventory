package com.macro.mall.tiny.modules.pms.dto;

import com.macro.mall.tiny.modules.pms.model.PmsStorage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @auther Pange
 * @description
 * @date {2025/5/28}
 */
@Getter
@Setter
public class PmsStorageDetail extends PmsStorage {

    @ApiModelProperty("用品名称")
    private String supplyName;

    @ApiModelProperty("用品描述")
    private String supplyDescription;

    @ApiModelProperty("操作人")
    private String operatorName;
}
