package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyWithInventory;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyType;
import com.macro.mall.tiny.modules.pms.service.PmsInventoryService;
import com.macro.mall.tiny.modules.pms.service.PmsStorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 库存表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@RestController
@RequestMapping("/pms/pmsInventory")
@Api(tags = {"用品库存管理"})
public class PmsInventoryController {

    @Autowired
    private PmsInventoryService inventoryService;
    @Autowired
    private PmsStorageService storageService;

    @GetMapping
    @ApiOperation("用品库存列表")
    public CommonResult<CommonPage<PmsSupplyWithInventory>> list(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNum){

        Page<PmsSupplyWithInventory> supplyList = inventoryService.list(keyword, pageSize, pageNum);

        return CommonResult.success(CommonPage.restPage(supplyList));
    }

    @PutMapping("/{supply_id}/in")
    @ApiOperation("入库")
    public CommonResult in(@PathVariable("supply_id") Long supplyId,@RequestParam Integer qty){
        boolean success = storageService.create(supplyId,"in", qty);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping("/{supply_id}/out")
    @ApiOperation("出库")
    public CommonResult out(@PathVariable("supply_id") Long supplyId,@RequestParam Integer qty){
        boolean success = storageService.create(supplyId,"out", qty);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}

