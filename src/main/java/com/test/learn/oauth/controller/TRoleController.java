package com.test.learn.oauth.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import com.alibaba.excel.EasyExcel;
import com.test.learn.utils.AjaxResult;
import com.test.learn.utils.BaseController;
import com.test.learn.utils.annotation.Log;
import com.test.learn.utils.enums.BusinessType;
import com.test.learn.utils.page.TableDataInfo;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.test.learn.oauth.entity.TRole;
import com.test.learn.oauth.service.ITRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.learn.oauth.dto.TRoleDTO;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author smj
 * @since 2023-07-04
 */
@Slf4j
@RestController
@RequestMapping("/oauth/tRole")
public class TRoleController extends BaseController {
    @Autowired
    private ITRoleService tRoleService;

    /**
     * 查询列表
     */
    @PreAuthorize("@ss.hasPermi('oauth:tRole:list')")
    @GetMapping("/list")
    public TableDataInfo list(TRole tRole){
        startPage();
        List<TRole> list= tRoleService.list(new LambdaQueryWrapper<TRole>(tRole));
        return getDataTable(list);
    }

    /**
     * 获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('oauth:tRole:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return AjaxResult.success(tRoleService.getById(id));
    }

    /**
     * 新增
     */
    @PreAuthorize("@ss.hasPermi('oauth:tRole:add')")
    @Log(title = "" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody TRole tRole){
        return toAjax(tRoleService.saveTRole(tRole));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('oauth:tRole:edit')")
    @Log(title = "" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TRole tRole){
        return tRoleService.updateTRole(tRole);
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('oauth:tRole:remove')")
    @Log(title = "" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[]ids){
        return toAjax(tRoleService.removeByIds(Arrays.asList(ids)));
    }

    /**
     * 导出
     */
    @PreAuthorize("@ss.hasPermi('oauth:tRole:export')")
    @Log(title = "" , businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public void export(HttpServletResponse response,TRole tRole){
        tRoleService.export(response,tRole);
    }

    /**
     * 导入列表
     */
    @PreAuthorize("@ss.hasPermi('oauth:tRole:import')")
    @Log(title = "" , businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file)throws Exception{
        return AjaxResult.success(tRoleService.importExcel(file));
    }

    /**
     * 导出模板
     */
    @PreAuthorize("@ss.hasPermi('oauth:tRole:import')")
    @GetMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)throws IOException{
        String fileName="_template"+ DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_MS_PATTERN)+"_"+System.currentTimeMillis()+".xlsx";
        response.reset();
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, CharsetUtil.UTF_8));
        response.setContentType("application/octet-stream");
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
        response.setHeader("luxsan","luxsan");
        EasyExcel.write(response.getOutputStream(), TRoleDTO.class).sheet("").doWrite(new ArrayList<>());
    }

}

