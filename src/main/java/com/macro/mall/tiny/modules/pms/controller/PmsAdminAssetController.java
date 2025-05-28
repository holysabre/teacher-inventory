package com.macro.mall.tiny.modules.pms.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.modules.pms.dto.PmsAdminAssetDetail;
import com.macro.mall.tiny.modules.pms.service.PmsAdminAssetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 个人资产表 前端控制器
 * </p>
 *
 * @author macro
 * @since 2025-05-28
 */
@RestController
@RequestMapping("/pms/pmsAdminAsset")
@Api(tags = {"个人资产管理"})
public class PmsAdminAssetController {
    @Autowired
    private PmsAdminAssetService adminAssetService;

    @GetMapping
    @ApiOperation("个人资产列表")
    public CommonResult<CommonPage<PmsAdminAssetDetail>> list(
            @RequestParam String keyword,
            @RequestParam String createTime,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") Integer pageNum){

        Page<PmsAdminAssetDetail> assetList = adminAssetService.list(keyword,createTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(assetList));
    }
}

