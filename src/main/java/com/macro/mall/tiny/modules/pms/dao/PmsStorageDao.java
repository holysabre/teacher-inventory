package com.macro.mall.tiny.modules.pms.dao;

import com.macro.mall.tiny.modules.pms.dto.PmsStorageDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther Pange
 * @description
 * @date {2025/5/28}
 */
public interface PmsStorageDao {

    List<PmsStorageDetail> getList(@Param("supply_name") String supplyName, @Param("type") String type);
}
