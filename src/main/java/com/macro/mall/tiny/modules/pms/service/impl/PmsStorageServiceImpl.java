package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.common.exception.Asserts;
import com.macro.mall.tiny.modules.pms.dao.PmsStorageDao;
import com.macro.mall.tiny.modules.pms.dto.PmsStorageDetail;
import com.macro.mall.tiny.modules.pms.mapper.PmsInventoryMapper;
import com.macro.mall.tiny.modules.pms.model.PmsInventory;
import com.macro.mall.tiny.modules.pms.model.PmsStorage;
import com.macro.mall.tiny.modules.pms.mapper.PmsStorageMapper;
import com.macro.mall.tiny.modules.pms.service.PmsStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 出入库表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Service
public class PmsStorageServiceImpl extends ServiceImpl<PmsStorageMapper, PmsStorage> implements PmsStorageService {

    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private PmsInventoryMapper inventoryMapper;
    @Autowired
    private PmsStorageDao storageDao;

    @Override
    public Page<PmsStorageDetail> list(String supplyName, String type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PmsStorageDetail> storageDetailList = storageDao.getList(supplyName,type);

        Page<PmsStorageDetail> page = new Page<>(pageNum, pageSize);
        page.setRecords(storageDetailList);

        return page;
    }

    @Override
    public boolean create(Long supplyId,String type, Integer qty) {
        UmsAdmin admin = adminService.getCurrentAdmin();

        PmsInventory inventory = inventoryMapper.selectById(supplyId);
        if(inventory == null){
            inventory = new PmsInventory();
        }

        if(type.equals("in")){
            inventory.setQty(inventory.getQty() + qty);
        } else if (type.equals("out")) {
            if(inventory.getQty() < qty){
                Asserts.fail("库存不足");
            }
            inventory.setQty(inventory.getQty() - qty);
        }else{
            Asserts.fail("非法的出入库类型");
        }
        inventoryMapper.updateById(inventory);

        PmsStorage pmsStorage = new PmsStorage();
        pmsStorage.setSupplyId(supplyId);
        pmsStorage.setQty(qty);
        pmsStorage.setType(type);
        pmsStorage.setOperatorId(admin.getId());
        pmsStorage.setCreateTime(new Date());

        return save(pmsStorage);
    }
}
