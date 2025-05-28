package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.dto.PmsStorageDetail;
import com.macro.mall.tiny.modules.pms.model.PmsStorage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 出入库表 服务类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
public interface PmsStorageService extends IService<PmsStorage> {

    Page<PmsStorageDetail> list(String supplyName, String type, Integer pageNum, Integer pageSize);

    @Transactional
    boolean create(Long supplyId,String type, Integer qty);
}
