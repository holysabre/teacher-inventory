package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyApplyParam;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyOperationDetail;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyOperation;
import com.macro.mall.tiny.modules.pms.service.PmsSupplyOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用品操作记录表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2025-05-28
 */
@RestController
@RequestMapping("/pms/pmsSupplyOperation")
@Api(tags = {"审核管理"})
public class PmsSupplyOperationController {

    @Autowired
    private PmsSupplyOperationService supplyOperationService;

    @GetMapping
    @ApiOperation("审核管理列表")
    public CommonResult<CommonPage<PmsSupplyOperationDetail>> list(
            @RequestParam("supply_name") String supplyName,
            @RequestParam("apply_name") String applyName,
            @RequestParam("type") String type,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        Page<PmsSupplyOperationDetail> operationDetailPage = supplyOperationService.list(supplyName, applyName, type, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(operationDetailPage));
    }

    @PostMapping
    @ApiOperation("申请")
    public CommonResult apply(@RequestBody PmsSupplyApplyParam pmsSupplyApplyParam) {
        boolean success = supplyOperationService.create(pmsSupplyApplyParam);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping("/{id}/pass")
    @ApiOperation("通过")
    public CommonResult pass(@PathVariable Long id){
        boolean success = supplyOperationService.pass(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping("/{id}/refuse")
    @ApiOperation("驳回")
    public CommonResult refuse(@PathVariable Long id){
        boolean success = supplyOperationService.refuse(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}

