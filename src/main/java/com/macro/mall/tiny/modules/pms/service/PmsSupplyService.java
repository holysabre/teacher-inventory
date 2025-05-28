package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.model.PmsSupply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyType;

/**
 * <p>
 * 用品表 服务类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
public interface PmsSupplyService extends IService<PmsSupply> {
    Page<PmsSupply> list(String keyword, Integer pageSize, Integer pageNum);

    boolean create(PmsSupply pmsSupply);

    boolean update(Long id, PmsSupply pmsSupply);

    boolean delete(Long id);
}
