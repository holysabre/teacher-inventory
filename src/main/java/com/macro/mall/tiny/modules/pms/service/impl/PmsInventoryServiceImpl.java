package com.macro.mall.tiny.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.modules.pms.dao.PmsSupplyDao;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyWithInventory;
import com.macro.mall.tiny.modules.pms.model.PmsInventory;
import com.macro.mall.tiny.modules.pms.mapper.PmsInventoryMapper;
import com.macro.mall.tiny.modules.pms.service.PmsInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 库存表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Service
public class PmsInventoryServiceImpl extends ServiceImpl<PmsInventoryMapper, PmsInventory> implements PmsInventoryService {

    @Autowired
    private PmsSupplyDao supplyDao;

    @Override
    public Page<PmsSupplyWithInventory> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<PmsSupplyWithInventory> supplyList = supplyDao.getListWithInventory(keyword);
        Page<PmsSupplyWithInventory> page = new Page<>();
        page.setRecords(supplyList);
        return page;
    }
}
