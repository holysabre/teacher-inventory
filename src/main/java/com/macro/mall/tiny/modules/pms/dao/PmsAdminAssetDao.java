package com.macro.mall.tiny.modules.pms.dao;

import com.macro.mall.tiny.modules.pms.dto.PmsAdminAssetDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsAdminAssetDao {

    List<PmsAdminAssetDetail> getList(
            @Param("admin_id") Long adminId,
            @Param("supply_name") String supply_name,
            @Param("create_time") String create_time);
}
