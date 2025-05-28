package com.macro.mall.tiny.modules.pms.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用品操作记录表
 * </p>
 *
 * @author macro
 * @since 2025-05-28
 */
@Getter
@Setter
@TableName("pms_supply_operation")
@ApiModel(value = "PmsSupplyOperation对象", description = "用品操作记录表")
public class PmsSupplyOperation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户id")
    private Long adminId;

    @ApiModelProperty("用品id")
    private Long supplyId;

    @ApiModelProperty("操作类型")
    private String operationType;

    @ApiModelProperty("原因")
    private String reason;

    @ApiModelProperty("申请数量")
    private Integer qty;

    @ApiModelProperty("申请时间")
    private Date applyTime;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("审核id")
    private Long auditUserId;

    @ApiModelProperty("审核时间")
    private Date auditTime;


}
