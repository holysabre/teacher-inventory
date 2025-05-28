package com.macro.mall.tiny.modules.pms.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 采购表
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Getter
@Setter
@TableName("pms_purchase")
@ApiModel(value = "PmsPurchase对象", description = "采购表")
public class PmsPurchase implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("用品id")
    private Long supplyId;

    @ApiModelProperty("采购数量")
    private Integer qty;

    @ApiModelProperty("采购单价")
    private BigDecimal price;

    @ApiModelProperty("供应商")
    private String supplier;

    @ApiModelProperty("操作人ID")
    private Long operatorId;

    @ApiModelProperty("创建时间")
    private Date createTime;


}
