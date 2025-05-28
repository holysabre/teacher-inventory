package com.macro.mall.tiny.modules.pms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyType;
import com.macro.mall.tiny.modules.pms.mapper.PmsSupplyTypeMapper;
import com.macro.mall.tiny.modules.pms.service.PmsSupplyTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 用品类型表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Service
public class PmsSupplyTypeServiceImpl extends ServiceImpl<PmsSupplyTypeMapper, PmsSupplyType> implements PmsSupplyTypeService {

    @Override
    public Page<PmsSupplyType> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<PmsSupplyType> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsSupplyType> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsSupplyType> lambda = wrapper.lambda();
        lambda.like(StrUtil.isNotBlank(keyword),PmsSupplyType::getName,keyword);
        return page(page,wrapper);
    }

    @Override
    public boolean create(PmsSupplyType pmsSupplyType) {
        pmsSupplyType.setCreateTime(new Date());
        return save(pmsSupplyType);
    }

    @Override
    public boolean update(Long id, PmsSupplyType pmsSupplyType) {
        pmsSupplyType.setId(id);
        pmsSupplyType.setUpdateTime(new Date());
        return updateById(pmsSupplyType);
    }

    @Override
    public boolean delete(Long id) {
        return removeById(id);
    }
}
