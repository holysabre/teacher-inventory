package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyType;
import com.macro.mall.tiny.modules.pms.service.PmsSupplyTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用品类型表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@RestController
@RequestMapping("/pms/pmsSupplyType")
@Api(tags = {"用品类型管理"})
public class PmsSupplyTypeController {

    @Autowired
    private PmsSupplyTypeService supplyTypeService;

    @GetMapping
    @ApiOperation("用品类型列表")
    public CommonResult<CommonPage<PmsSupplyType>> list(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<PmsSupplyType> list = supplyTypeService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @PostMapping
    @ApiOperation("新增用品分类")
    public CommonResult create(@RequestBody PmsSupplyType pmsSupplyType) {
        boolean success = supplyTypeService.save(pmsSupplyType);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("修改用品分类")
    public CommonResult update(
            @PathVariable Long id,
            @RequestBody PmsSupplyType pmsSupplyType) {
        boolean success = supplyTypeService.updateById(pmsSupplyType);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除用品分类")
    public CommonResult delete(@RequestParam("id") Long id) {
        boolean success = supplyTypeService.removeById(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }
}

