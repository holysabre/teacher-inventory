package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.dto.PmsStorageDetail;
import com.macro.mall.tiny.modules.pms.model.PmsStorage;
import com.macro.mall.tiny.modules.pms.model.PmsSupply;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyType;
import com.macro.mall.tiny.modules.pms.service.PmsStorageService;
import com.macro.mall.tiny.modules.pms.service.PmsSupplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 出入库表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@RestController
@RequestMapping("/pms/pmsStorage")
@Api(tags = {"出入库管理"})
public class PmsStorageController {

    @Autowired
    private PmsStorageService pmsStorageService;

    @GetMapping
    @ApiOperation("出入库管理列表")
    public CommonResult<CommonPage<PmsStorageDetail>> list(
            @RequestParam("supply_name") String supplyName,
            @RequestParam("type") String type,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ){
        Page<PmsStorageDetail> page = pmsStorageService.list(supplyName, type, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }

}

