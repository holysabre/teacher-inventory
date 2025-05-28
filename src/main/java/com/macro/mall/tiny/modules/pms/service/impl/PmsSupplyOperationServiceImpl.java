package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.common.exception.Asserts;
import com.macro.mall.tiny.modules.pms.dao.PmsSupplyOperationDao;
import com.macro.mall.tiny.modules.pms.dto.PmsStorageDetail;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyApplyParam;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyOperationDetail;
import com.macro.mall.tiny.modules.pms.mapper.PmsAdminAssetMapper;
import com.macro.mall.tiny.modules.pms.model.PmsAdminAsset;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyOperation;
import com.macro.mall.tiny.modules.pms.mapper.PmsSupplyOperationMapper;
import com.macro.mall.tiny.modules.pms.service.PmsSupplyOperationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用品操作记录表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Service
public class PmsSupplyOperationServiceImpl extends ServiceImpl<PmsSupplyOperationMapper, PmsSupplyOperation> implements PmsSupplyOperationService {

    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private PmsSupplyOperationDao supplyOperationDao;

    @Autowired
    private PmsSupplyOperationMapper supplyOperationMapper;

    @Autowired
    private PmsAdminAssetMapper adminAssetMapper;

    @Override
    public Page<PmsSupplyOperationDetail> list(String supplyName, String applyName, String type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PmsSupplyOperationDetail> operationDetailList = supplyOperationDao.getList(supplyName,applyName,type);

        Page<PmsSupplyOperationDetail> page = new Page<>(pageNum, pageSize);
        page.setRecords(operationDetailList);

        return page;
    }

    @Override
    public boolean create(PmsSupplyApplyParam supplyApplyParam) {

        UmsAdmin admin = adminService.getCurrentAdmin();

        PmsSupplyOperation supplyOperation = new PmsSupplyOperation();
        BeanUtils.copyProperties(supplyApplyParam, supplyOperation);
        supplyOperation.setAdminId(admin.getId());
        supplyOperation.setApplyTime(new Date());
        supplyOperation.setStatus("pending");

        return save(supplyOperation);
    }

    @Override
    public boolean pass(Long id) {
        UmsAdmin admin = adminService.getCurrentAdmin();

        PmsSupplyOperation supplyOperation = supplyOperationMapper.selectById(id);
        if(supplyOperation == null) {
            Asserts.fail("操作对象不存在");
        }
        supplyOperation.setStatus("pass");
        supplyOperation.setAuditUserId(admin.getId());
        supplyOperation.setAuditTime(new Date());
        updateById(supplyOperation);

        QueryWrapper<PmsAdminAsset> adminAssetWrapper = new QueryWrapper<>();
        adminAssetWrapper.lambda().eq(PmsAdminAsset::getAdminId, admin.getId())
                .eq(PmsAdminAsset::getSupplyId, supplyOperation.getSupplyId());
        PmsAdminAsset adminAsset = adminAssetMapper.selectOne(adminAssetWrapper);
        boolean success = false;
        if(adminAsset == null) {
            adminAsset = new PmsAdminAsset();
            adminAsset.setSupplyId(supplyOperation.getSupplyId());
            adminAsset.setAdminId(admin.getId());
            Integer originalQty = adminAsset.getQty() == null ? 0 : adminAsset.getQty();
            adminAsset.setQty(originalQty + supplyOperation.getQty());
            adminAsset.setCreateTime(new Date());
            success = adminAssetMapper.insert(adminAsset) > 0;
        }else{
            Integer originalQty = adminAsset.getQty() == null ? 0 : adminAsset.getQty();
            adminAsset.setQty(originalQty + supplyOperation.getQty());
            success = adminAssetMapper.updateById(adminAsset) > 0;
        }

        return success;
    }

    @Override
    public boolean refuse(Long id) {
        UmsAdmin admin = adminService.getCurrentAdmin();

        PmsSupplyOperation supplyOperation = supplyOperationMapper.selectById(id);
        if(supplyOperation == null) {
            Asserts.fail("操作对象不存在");
        }
        supplyOperation.setStatus("refuse");
        supplyOperation.setAuditUserId(admin.getId());
        supplyOperation.setAuditTime(new Date());
        return updateById(supplyOperation);
    }
}
