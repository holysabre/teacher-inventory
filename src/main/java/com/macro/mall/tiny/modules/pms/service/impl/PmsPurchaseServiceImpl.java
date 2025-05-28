package com.macro.mall.tiny.modules.pms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.model.PmsPurchase;
import com.macro.mall.tiny.modules.pms.mapper.PmsPurchaseMapper;
import com.macro.mall.tiny.modules.pms.service.PmsPurchaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 采购表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Service
public class PmsPurchaseServiceImpl extends ServiceImpl<PmsPurchaseMapper, PmsPurchase> implements PmsPurchaseService {

    @Autowired
    private UmsAdminService adminService;

    @Override
    public Page<PmsPurchase> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<PmsPurchase> page = new Page<>(pageNum, pageSize);
        QueryWrapper<PmsPurchase> wrapper = new QueryWrapper<>();
        return page(page, wrapper);
    }

    @Override
    public boolean create(PmsPurchase pmsPurchase) {
        UmsAdmin admin = adminService.getCurrentAdmin();

        pmsPurchase.setOperatorId(admin.getId());
        pmsPurchase.setCreateTime(new Date());
        return save(pmsPurchase);
    }
}
