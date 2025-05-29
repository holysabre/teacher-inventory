package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.macro.mall.tiny.modules.pms.dto.PmsAdminAssetDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsAdminAssetDao {

    IPage<PmsAdminAssetDetail> getList(
            IPage<PmsAdminAssetDetail> page,
            @Param("admin_id") Long adminId,
            @Param("supply_name") String supply_name,
            @Param("create_time") String create_time);
}
