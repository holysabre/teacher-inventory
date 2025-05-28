package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.model.PmsSupply;
import com.macro.mall.tiny.modules.pms.service.PmsSupplyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用品表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@RestController
@RequestMapping("/pms/pmsSupply")
public class PmsSupplyController {
    @Autowired
    private PmsSupplyService supplyService;

    @GetMapping
    @ApiOperation("用品列表")
    public CommonResult<CommonPage<PmsSupply>> list(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<PmsSupply> list = supplyService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @PostMapping
    @ApiOperation("新增用品")
    public CommonResult create(@RequestBody PmsSupply pmsSupply) {
        boolean success = supplyService.save(pmsSupply);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("修改用品")
    public CommonResult update(
            @PathVariable Long id,
            @RequestBody PmsSupply pmsSupply) {
        boolean success = supplyService.updateById(pmsSupply);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用品")
    public CommonResult delete(@RequestParam("id") Long id) {
        boolean success = supplyService.removeById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}

