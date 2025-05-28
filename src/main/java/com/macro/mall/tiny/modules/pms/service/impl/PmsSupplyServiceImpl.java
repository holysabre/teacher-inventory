package com.macro.mall.tiny.modules.pms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.macro.mall.tiny.modules.pms.model.PmsSupply;
import com.macro.mall.tiny.modules.pms.mapper.PmsSupplyMapper;
import com.macro.mall.tiny.modules.pms.model.PmsSupplyType;
import com.macro.mall.tiny.modules.pms.service.PmsSupplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 用品表 服务实现类
 * </p>
 *
 * @author macro
 * @since 2025-05-27
 */
@Service
public class PmsSupplyServiceImpl extends ServiceImpl<PmsSupplyMapper, PmsSupply> implements PmsSupplyService {

    @Override
    public Page<PmsSupply> list(String keyword, Integer pageSize, Integer pageNum) {
        Page<PmsSupply> page = new Page<>(pageNum,pageSize);
        QueryWrapper<PmsSupply> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<PmsSupply> lambda = wrapper.lambda();
        lambda.like(StrUtil.isNotBlank(keyword),PmsSupply::getName,keyword);
        return page(page,wrapper);
    }

    @Override
    public boolean create(PmsSupply pmsSupply) {
        pmsSupply.setCreateTime(new Date());
        return save(pmsSupply);
    }

    @Override
    public boolean update(Long id, PmsSupply pmsSupply) {
        pmsSupply.setId(id);
        pmsSupply.setUpdateTime(new Date());
        return updateById(pmsSupply);
    }

    @Override
    public boolean delete(Long id) {
        return removeById(id);
    }
}
