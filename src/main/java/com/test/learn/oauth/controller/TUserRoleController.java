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
import com.test.learn.oauth.entity.TUserRole;
import com.test.learn.oauth.service.ITUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.learn.oauth.dto.TUserRoleDTO;

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
@RequestMapping("/oauth/tUserRole")
public class TUserRoleController extends BaseController {
    @Autowired
    private ITUserRoleService tUserRoleService;

    /**
     * 查询列表
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUserRole:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUserRole tUserRole){
        startPage();
        List<TUserRole> list= tUserRoleService.list(new LambdaQueryWrapper<TUserRole>(tUserRole));
        return getDataTable(list);
    }

    /**
     * 获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUserRole:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return AjaxResult.success(tUserRoleService.getById(id));
    }

    /**
     * 新增
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUserRole:add')")
    @Log(title = "" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody TUserRole tUserRole){
        return toAjax(tUserRoleService.saveTUserRole(tUserRole));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUserRole:edit')")
    @Log(title = "" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUserRole tUserRole){
        return tUserRoleService.updateTUserRole(tUserRole);
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUserRole:remove')")
    @Log(title = "" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[]ids){
        return toAjax(tUserRoleService.removeByIds(Arrays.asList(ids)));
    }

    /**
     * 导出
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUserRole:export')")
    @Log(title = "" , businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public void export(HttpServletResponse response,TUserRole tUserRole){
        tUserRoleService.export(response,tUserRole);
    }

    /**
     * 导入列表
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUserRole:import')")
    @Log(title = "" , businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file)throws Exception{
        return AjaxResult.success(tUserRoleService.importExcel(file));
    }

    /**
     * 导出模板
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUserRole:import')")
    @GetMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)throws IOException{
        String fileName="_template"+ DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_MS_PATTERN)+"_"+System.currentTimeMillis()+".xlsx";
        response.reset();
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, CharsetUtil.UTF_8));
        response.setContentType("application/octet-stream");
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
        response.setHeader("luxsan","luxsan");
        EasyExcel.write(response.getOutputStream(), TUserRoleDTO.class).sheet("").doWrite(new ArrayList<>());
    }

}

