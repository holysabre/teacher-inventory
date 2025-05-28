package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.dto.PmsStorageDetail;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyApplyParam;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyOperationDetail;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyOperation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用品操作记录表 服务类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
public interface PmsSupplyOperationService extends IService<PmsSupplyOperation> {

    Page<PmsSupplyOperationDetail> list(String supplyName,String applyName, String type, Integer pageNum, Integer pageSize);

    boolean create(PmsSupplyApplyParam supplyApplyParam);

    @Transactional
    boolean pass(Long id);

    boolean refuse(Long id);
}
