package com.macro.mall.tiny.modules.pms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.macro.mall.tiny.modules.pms.dto.PmsSupplyOperationDetail;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @auther Pange
 * @description
 * @date {2025/5/28}
 */
public interface PmsSupplyOperationDao extends BaseMapper<PmsSupplyOperationDetail> {

    IPage<PmsSupplyOperationDetail> getPageList(
            IPage<PmsSupplyOperationDetail> page,
            @Param("param")Map<String, Object> param
            );
}
