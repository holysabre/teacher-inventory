package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.model.PmsPurchase;
import com.baomidou.mybatisplus.extension.service.IService;
import com.macro.mall.tiny.modules.pms.model.PmsSupply;

/**
 * <p>
 * 采购表 服务类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
public interface PmsPurchaseService extends IService<PmsPurchase> {
    Page<PmsPurchase> list(String keyword, Integer pageSize, Integer pageNum);

    boolean create(PmsPurchase pmsPurchase);
}
