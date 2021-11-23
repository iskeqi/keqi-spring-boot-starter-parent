package com.keqi.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.common.pojo.PageDto;
import com.keqi.system.domain.db.ConfigDO;
import com.keqi.system.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "配置管理")
@ApiSupport(order = 1, author = "keqi")
@RestController
@RequestMapping("/sys/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @ApiOperation("新增配置")
    @PostMapping
    public void insert(@Validated @RequestBody ConfigDO param) {
        configService.insert(param);
    }

    @ApiOperation("删除配置")
    @DeleteMapping("/{configKey}")
    public void deleteByConfigKey(@PathVariable String configKey) {
        configService.deleteByConfigKey(configKey);
    }

    @ApiOperation("修改配置")
    @PutMapping
    public void updateByConfigKey(@Validated @RequestBody ConfigDO param) {
        configService.updateByConfigKey(param);
    }

    @ApiOperation("查询配置详情")
    @GetMapping
    public ConfigDO getByConfigKey(String configKey) {
        return configService.getByConfigKey(configKey);
    }

    @ApiOperation("分页查询配置列表")
    @ApiOperationSupport(ignoreParameters = {
            "records", "total", "orders", "optimizeCountSql", "isSearchCount", "hitCount",
            "countId", "maxLimit", "searchCount", "searchName", "orderFiled", "orderType",
            "searchValue", "beginDate", "endDate", "beginTime", "endTime"})
    @GetMapping("/page")
    public PageDto<ConfigDO> page(Page<ConfigDO> param) {
        return configService.page(param);
    }
}