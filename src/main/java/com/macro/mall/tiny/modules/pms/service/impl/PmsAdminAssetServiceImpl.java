package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.dao.PmsAdminAssetDao;
import com.macro.mall.tiny.modules.pms.dto.PmsAdminAssetDetail;
import com.macro.mall.tiny.modules.pms.model.PmsAdminAsset;
import com.macro.mall.tiny.modules.pms.mapper.PmsAdminAssetMapper;
import com.macro.mall.tiny.modules.pms.service.PmsAdminAssetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人资产表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2025-05-28
 */
@Service
public class PmsAdminAssetServiceImpl extends ServiceImpl<PmsAdminAssetMapper, PmsAdminAsset> implements PmsAdminAssetService {
    @Autowired
    private PmsAdminAssetDao adminAssetDao;
    @Autowired
    private UmsAdminService adminService;

    @Override
    public Page<PmsAdminAssetDetail> list(String keyword, String createTime, Integer pageSize, Integer pageNum) {
        UmsAdmin admin = adminService.getCurrentAdmin();
        Page<PmsAdminAssetDetail> page = new Page<>(pageNum, pageSize);
        return (Page<PmsAdminAssetDetail>) adminAssetDao.getList(page,admin.getId(),keyword,createTime);
    }
}
