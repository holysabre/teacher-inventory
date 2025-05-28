package com.macro.mall.tiny.modules.pms.dao;

import com.macro.mall.tiny.modules.pms.dto.PmsSupplyWithInventory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsSupplyDao {

    List<PmsSupplyWithInventory> getListWithInventory(@Param("keyword") String keyword);


}
