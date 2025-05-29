package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyWithInventory;
import org.apache.ibatis.annotations.Param;

public interface PmsSupplyDao {

    IPage<PmsSupplyWithInventory> getListWithInventory(
            IPage<PmsSupplyWithInventory> page,
            @Param("keyword") String keyword);


}
