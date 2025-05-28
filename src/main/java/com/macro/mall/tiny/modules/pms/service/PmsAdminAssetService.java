package com.macro.mall.tiny.modules.pms.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.dto.PmsAdminAssetDetail;
import com.macro.mall.tiny.modules.pms.model.PmsAdminAsset;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 个人资产表 服务类
 * </p>
 *
 * @author macro
 * @since 2025-05-28
 */
public interface PmsAdminAssetService extends IService<PmsAdminAsset> {
    Page<PmsAdminAssetDetail> list(String supplyName,String createTime, Integer pageSize, Integer pageNum);
}
