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
import com.test.learn.oauth.entity.OauthClientDetails;
import com.test.learn.oauth.service.IOauthClientDetailsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 接入客户端信息 前端控制器
 * </p>
 *
 * @author smj
 * @since 2023-07-04
 */
@Slf4j
@RestController
@RequestMapping("/oauth/oauthClientDetails")
public class OauthClientDetailsController extends BaseController {
    @Autowired
    private IOauthClientDetailsService oauthClientDetailsService;

    /**
     * 查询接入客户端信息列表
     */
    @PreAuthorize("@ss.hasPermi('oauth:oauthClientDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(OauthClientDetails oauthClientDetails){
        startPage();
        List<OauthClientDetails> list= oauthClientDetailsService.list(new LambdaQueryWrapper<OauthClientDetails>(oauthClientDetails));
        return getDataTable(list);
    }

    /**
     * 获取接入客户端信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('oauth:oauthClientDetails:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id){
        return AjaxResult.success(oauthClientDetailsService.getById(id));
    }

    /**
     * 新增接入客户端信息
     */
    @PreAuthorize("@ss.hasPermi('oauth:oauthClientDetails:add')")
    @Log(title = "接入客户端信息" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody OauthClientDetails oauthClientDetails){
        return toAjax(oauthClientDetailsService.saveOauthClientDetails(oauthClientDetails));
    }

    /**
     * 修改接入客户端信息
     */
    @PreAuthorize("@ss.hasPermi('oauth:oauthClientDetails:edit')")
    @Log(title = "接入客户端信息" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OauthClientDetails oauthClientDetails){
        return oauthClientDetailsService.updateOauthClientDetails(oauthClientDetails);
    }

    /**
     * 删除接入客户端信息
     */
    @PreAuthorize("@ss.hasPermi('oauth:oauthClientDetails:remove')")
    @Log(title = "接入客户端信息" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[]ids){
        return toAjax(oauthClientDetailsService.removeByIds(Arrays.asList(ids)));
    }

    /**
     * 导出接入客户端信息
     */
    @PreAuthorize("@ss.hasPermi('oauth:oauthClientDetails:export')")
    @Log(title = "接入客户端信息" , businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public void export(HttpServletResponse response,OauthClientDetails oauthClientDetails){
        oauthClientDetailsService.export(response,oauthClientDetails);
    }

    /**
     * 导入接入客户端信息列表
     */
    @PreAuthorize("@ss.hasPermi('oauth:oauthClientDetails:import')")
    @Log(title = "接入客户端信息" , businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file)throws Exception{
        return AjaxResult.success(oauthClientDetailsService.importExcel(file));
    }

    /**
     * 导出接入客户端信息模板
     */
    @PreAuthorize("@ss.hasPermi('oauth:oauthClientDetails:import')")
    @GetMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)throws IOException{
        String fileName="接入客户端信息_template"+ DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_MS_PATTERN)+"_"+System.currentTimeMillis()+".xlsx";
        response.reset();
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName, CharsetUtil.UTF_8));
        response.setContentType("application/octet-stream");
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
        response.setHeader("luxsan","luxsan");
        EasyExcel.write(response.getOutputStream(), OauthClientDetails.class).sheet("接入客户端信息").doWrite(new ArrayList<>());
    }

}

