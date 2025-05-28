package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.model.PmsPurchase;
import com.macro.mall.tiny.modules.pms.service.PmsPurchaseService;
import com.macro.mall.tiny.modules.ums.model.UmsAdmin;
import com.macro.mall.tiny.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 * 采购表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@RestController
@RequestMapping("/pms/pmsPurchase")
@Api(tags = {"采购管理"})
public class PmsPurchaseController {

    @Autowired
    private PmsPurchaseService purchaseService;
    @Autowired
    private UmsAdminService adminService;

    @GetMapping
    @ApiOperation("采购列表")
    public CommonResult<CommonPage<PmsPurchase>> list(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<PmsPurchase> list = purchaseService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @PostMapping
    @ApiOperation("新增采购")
    public CommonResult create(@RequestBody PmsPurchase pmsPurchase) {
        UmsAdmin admin = adminService.getCurrentAdmin();
        pmsPurchase.setOperatorId(admin.getId());
        pmsPurchase.setCreateTime(new Date());
        boolean success = purchaseService.save(pmsPurchase);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}

