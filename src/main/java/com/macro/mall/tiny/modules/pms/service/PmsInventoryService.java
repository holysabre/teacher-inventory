package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyWithInventory;
import com.macro.mall.tiny.modules.pms.model.PmsInventory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 库存表 服务类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
public interface PmsInventoryService extends IService<PmsInventory> {
    Page<PmsSupplyWithInventory> list(String keyword, Integer pageSize, Integer pageNum);
}
