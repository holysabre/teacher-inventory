package com.macro.mall.tiny.modules.pms.dto;

import com.macro.mall.tiny.modules.pms.model.PmsSupply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @auther Pange
 * @description
 * @date {2025/5/28}
 */
@Getter
@Setter
public class PmsSupplyWithInventory extends PmsSupply {

    @ApiModelProperty("库存数量")
    private Integer qty;

    @ApiModelProperty("入库时间")
    private Date lastUpdateTime;
}
