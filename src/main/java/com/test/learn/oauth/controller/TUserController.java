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
import com.test.learn.oauth.entity.TUser;
import com.test.learn.oauth.service.ITUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.test.learn.oauth.dto.TUserDTO;

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
@RequestMapping("/oauth/tUser")
public class TUserController extends BaseController {
    @Autowired
    private ITUserService tUserService;

    /**
     * 查询列表
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUser tUser){
        startPage();
        List<TUser> list= tUserService.list(new LambdaQueryWrapper<TUser>(tUser));
        return getDataTable(list);
    }

    /**
     * 获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return AjaxResult.success(tUserService.getById(id));
    }

    /**
     * 新增
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUser:add')")
    @Log(title = "" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody TUser tUser){
        return toAjax(tUserService.saveTUser(tUser));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUser:edit')")
    @Log(title = "" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUser tUser){
        return tUserService.updateTUser(tUser);
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUser:remove')")
    @Log(title = "" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[]ids){
        return toAjax(tUserService.removeByIds(Arrays.asList(ids)));
    }

    /**
     * 导出
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUser:export')")
    @Log(title = "" , businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public void export(HttpServletResponse response,TUser tUser){
        tUserService.export(response,tUser);
    }

    /**
     * 导入列表
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUser:import')")
    @Log(title = "" , businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file)throws Exception{
        return AjaxResult.success(tUserService.importExcel(file));
    }

    /**
     * 导出模板
     */
    @PreAuthorize("@ss.hasPermi('oauth:tUser:import')")
    @GetMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)throws IOException{
        String fileName="_template"+ DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_MS_PATTERN)+"_"+System.currentTimeMillis()+".xlsx";
        response.reset();
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, CharsetUtil.UTF_8));
        response.setContentType("application/octet-stream");
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
        response.setHeader("luxsan","luxsan");
        EasyExcel.write(response.getOutputStream(), TUserDTO.class).sheet("").doWrite(new ArrayList<>());
    }

}

