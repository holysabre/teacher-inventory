package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.macro.mall.tiny.modules.pms.dto.PmsStorageDetail;
import org.apache.ibatis.annotations.Param;

/**
 * @auther Pange
 * @description
 * @date {2025/5/28}
 */
public interface PmsStorageDao {

    IPage<PmsStorageDetail> getList(
            IPage<PmsStorageDetail> page,
            @Param("supply_name") String supplyName,
            @Param("type") String type);
}
