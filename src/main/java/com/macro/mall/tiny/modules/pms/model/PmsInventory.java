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
 * 库存表
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Getter
@Setter
@TableName("pms_inventory")
@ApiModel(value = "PmsInventory对象", description = "库存表")
public class PmsInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用品id")
    private Long supplyId;

    @ApiModelProperty("数量")
    private Integer qty;

    @ApiModelProperty("最后更新时间")
    private Date lastUpdateTime;


}
