package com.macro.mall.tiny.modules.pms.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 用品表
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Getter
@Setter
@TableName("pms_supply")
@ApiModel(value = "PmsSupply对象", description = "用品表")
public class PmsSupply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("类型id")
    private Long typeId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("规格")
    private String spec;

    @ApiModelProperty("单价")
    private BigDecimal price;

    @ApiModelProperty("描述")
    private String description;

    private Date createTime;

    private Date updateTime;


}
