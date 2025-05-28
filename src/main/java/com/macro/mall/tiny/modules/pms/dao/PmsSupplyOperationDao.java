package com.macro.mall.tiny.modules.pms.dao;

import com.macro.mall.tiny.modules.pms.dto.PmsSupplyOperationDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther Pange
 * @description
 * @date {2025/5/28}
 */
public interface PmsSupplyOperationDao {
    List<PmsSupplyOperationDetail> getList(
            @Param("supply_name") String supplyName,
            @Param("apply_name") String applyName,
            @Param("type") String type
            );
}
