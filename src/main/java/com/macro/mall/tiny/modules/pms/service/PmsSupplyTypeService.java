package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用品类型表 服务类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
public interface PmsSupplyTypeService extends IService<PmsSupplyType> {

    Page<PmsSupplyType> list(String keyword, Integer pageSize, Integer pageNum);

    boolean create(PmsSupplyType pmsSupplyType);

    boolean update(Long id, PmsSupplyType pmsSupplyType);

    boolean delete(Long id);
}
