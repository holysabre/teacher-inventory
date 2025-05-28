package com.macro.mall.tiny.modules.pms.dto;

import com.macro.mall.tiny.modules.pms.model.PmsAdminAsset;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PmsAdminAssetDetail extends PmsAdminAsset {

    @ApiModelProperty("用品名称")
    private String supplyName;

    @ApiModelProperty("用品规格")
    private String supplySpec;

    @ApiModelProperty("用品描述")
    private String supplyDescription;

    @ApiModelProperty("用品类型名称")
    private String supplyTypeName;
}
