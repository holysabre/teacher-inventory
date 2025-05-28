package com.macro.mall.tiny.modules.pms.dto;

import com.macro.mall.tiny.modules.pms.model.PmsSupplyOperation;
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
public class PmsSupplyOperationDetail extends PmsSupplyOperation {
    @ApiModelProperty("申请人")
    private String applyName;
    @ApiModelProperty("用品名称")
    private String supplyName;
}
