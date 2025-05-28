package com.macro.mall.tiny.modules.pms.dto;

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
public class PmsSupplyApplyParam {

    @ApiModelProperty("用品ID")
    private Long supplyId;

    @ApiModelProperty("操作类型")
    private String operationType;

    @ApiModelProperty("理由")
    private String reason;

    @ApiModelProperty("申请数量")
    private Integer qty;
}
