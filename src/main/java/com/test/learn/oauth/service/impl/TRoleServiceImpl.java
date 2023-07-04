package com.test.learn.oauth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.read.metadata.holder.ReadHolder;
import com.alibaba.excel.read.metadata.property.ExcelReadHeadProperty;
import com.alibaba.excel.metadata.Head;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.test.learn.oauth.entity.TRole;
import com.test.learn.oauth.dto.TRoleDTO;
import com.test.learn.oauth.mapper.TRoleMapper;
import com.test.learn.oauth.service.ITRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.learn.utils.AjaxResult;
import com.test.learn.utils.BeanValidators;
import com.test.learn.utils.Constants;
import com.test.learn.utils.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author smj
 * @since 2023-07-04
 */
@Slf4j
@Service
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {
    @Resource
    protected Validator validator;
    @Resource
    private TRoleMapper tRoleMapper;
    @Resource(name = "threadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public int saveTRole(TRole tRole) {
        int result = 0;
        if (tRoleMapper.exists(new LambdaQueryWrapper<TRole>()
                .eq(TRole::getRoleName,tRole.getRoleName())
                .eq(TRole::getDescription,tRole.getDescription())
                .eq(TRole::getCreateTime,tRole.getCreateTime())
                .eq(TRole::getUpdateTime,tRole.getUpdateTime())
                .eq(TRole::getStatus,tRole.getStatus())
            )){
            result = tRoleMapper.update(tRole,new LambdaQueryWrapper<TRole>()
                    .eq(TRole::getRoleName,tRole.getRoleName())
                    .eq(TRole::getDescription,tRole.getDescription())
                    .eq(TRole::getCreateTime,tRole.getCreateTime())
                    .eq(TRole::getUpdateTime,tRole.getUpdateTime())
                    .eq(TRole::getStatus,tRole.getStatus())
            );
        } else {
            result = tRoleMapper.insert(tRole);
        }
        return result;
    }

    @Override
    public AjaxResult updateTRole(TRole tRole) {
        int result = 0;
        if (tRoleMapper.exists(new LambdaQueryWrapper<TRole>()
                .eq(TRole::getRoleName,tRole.getRoleName())
                .eq(TRole::getDescription,tRole.getDescription())
                .eq(TRole::getCreateTime,tRole.getCreateTime())
                .eq(TRole::getUpdateTime,tRole.getUpdateTime())
                .eq(TRole::getStatus,tRole.getStatus())
        )){
            return AjaxResult.error("XXXX、XXXX、XXXXXX 已存在！");
        } else {
            result = tRoleMapper.updateById(tRole);
        }
        return AjaxResult.success(result > 0);
    }

        /**
         * 导入信息
         *
         * @param file
         * @return 结果
         */
        @Override
        @Transactional(rollbackFor = Exception.class)
        public String importExcel(MultipartFile file) {
            AtomicInteger successNum = new AtomicInteger();
            AtomicInteger failureNum = new AtomicInteger();
            StringBuilder successMsg = new StringBuilder();
            StringBuilder failureMsg = new StringBuilder();
            try {
                EasyExcel.read(file.getInputStream(), TRole.class, new ReadListener<TRole>() {
                /**
                 * 单次缓存的数据量
                 */
                public static final int BATCH_COUNT = 10000;
                /**
                 *临时存储
                 */
                private List<TRole> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

                @Override
                public void onException(Exception exception, AnalysisContext context) {
                    log.error(exception.getMessage(), exception);
                    ExcelDataConvertException e = (ExcelDataConvertException) exception;
                    throw new ServiceException("第" + (e.getRowIndex()+1) + "行，第" + (e.getColumnIndex()+1) + "列，[" + context.currentReadHolder().excelReadHeadProperty().getHeadMap().get(e.getColumnIndex()).getHeadNameList().get(0) + "]数据为:"+e.getCellData().getStringValue()+"，格式不正确请完善数据后重新上传。");
                }

                @Override
                public void invoke(TRole data, AnalysisContext context) {
                    // 非必空字段校验
                    Map<String,Object> map = BeanUtil.beanToMap(data, false,false);
                    ReadHolder currentReadHolder = context.currentReadHolder();
                    ExcelReadHeadProperty excelReadHeadProperty = currentReadHolder.excelReadHeadProperty();
                    Map<Integer, Head> headMap = excelReadHeadProperty.getHeadMap();
                    headMap.forEach((key, value) ->{
                        Field field = value.getField();
                        NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
                        NotNull notNull = field.getAnnotation(NotNull.class);
                        if (ObjUtil.isEmpty(map.get(value.getFieldName()))
                                && (ObjUtil.isNotNull(notEmpty) || ObjUtil.isNotNull(notNull))){
                            throw new ServiceException("第"+(context.readRowHolder().getRowIndex() +1)+"行，第"+(key+1)+"列，["+value.getHeadNameList().get(0)+"]必填不能为空，请完善数据后重新上传。");
                        }
                    });
                    cachedDataList.add(data);
                    if (cachedDataList.size() >= BATCH_COUNT) {
                        saveData();
                        // 存储完成清理 list
                        cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                    }
                }
                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {
                    saveData();
                }
                /**
                 * 加上存储数据库
                 */
                private void saveData() {
                    CountDownLatch countDownLatch = new CountDownLatch(cachedDataList.size());
                    AtomicInteger successNum = new AtomicInteger();
                    AtomicInteger failureNum = new AtomicInteger();
                    StringBuilder failureMsg = new StringBuilder();
                    for (TRole tRole : cachedDataList){
                        try{
                            BeanValidators.validateWithException(validator, tRole);
                            CompletableFuture.runAsync(() -> {
                                saveTRole(tRole);
                                successNum.getAndIncrement();
                                successMsg.append("<br/>" + successNum.get() + "、 " + " 导入成功");
                            }, threadPoolTaskExecutor).whenComplete((v,e)->{
                                if (null != e){
                                    log.error(e.getMessage(), e);
                                    failureNum.getAndIncrement();
                                    failureMsg.append("<br/>导入异常，请联系系统管理员");
                                }
                                countDownLatch.countDown();
                            });
                        }catch (Exception e){
                            failureNum.getAndIncrement();
                            failureMsg.append("<br/>导入异常，请联系系统管理员");
                            log.error(failureNum.get() + " " + e.getMessage(), e);
                        }
                    }
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        log.error(e.getMessage(), e);
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    }
                    if (successNum.get() > 0) {
                        successMsg.insert(0, "恭喜您，共 " + successNum.get() + " 条数据已导入成功！");
                    }
                    if (failureNum.get() > 0) {
                        failureMsg.insert(0, "<br/>很抱歉，共 " + failureNum + " 条导入失败：");
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    }
                }
              }).sheet().doRead();
              return successMsg.append(failureMsg).toString();
            } catch (Exception e){
                log.error(e.getMessage(), e);
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return e.getMessage();
            }
        }

        @Override
        public void export(HttpServletResponse response, TRole tRole){
            final Integer[] total = {tRoleMapper.selectCount(new LambdaQueryWrapper<>(tRole)).intValue()};
            if(total[0] == 0){
                try {
                    String fileName="_"+DateUtil.format(DateUtil.date(),DatePattern.PURE_DATETIME_MS_PATTERN)+"_"+System.currentTimeMillis()+".xlsx";
                    response.reset();
                    response.setCharacterEncoding("utf8");
                    response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName, CharsetUtil.UTF_8));
                    response.setContentType("application/octet-stream");
                    response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
                    response.setHeader("luxsan","luxsan");
                    EasyExcel.write(response.getOutputStream(), TRoleDTO.class).sheet("数据").doWrite(new ArrayList<>());
                } catch (IOException ignored) {}
            }
            Integer sheetDataRows = Constants.SHEET_COUNT;
            Integer writeDataRows = Constants.SHEET_WRITE_NUM;
            final Integer[] maxSheetNum = {Constants.MAX_SHEET_NUM};
            final int[] sheetNum = {total[0] % sheetDataRows == 0 ? (total[0] / sheetDataRows) : (total[0] / sheetDataRows) + 1};
            final int[] oneSheetWriteCount = {total[0] > sheetDataRows ? sheetDataRows / writeDataRows : total[0] % writeDataRows > 0 ? total[0] / writeDataRows + 1 : total[0] / writeDataRows};
            int lastSheetWriteCount = total[0] % sheetDataRows == 0 ? oneSheetWriteCount[0] : (total[0] % sheetDataRows % writeDataRows == 0 ? (total[0] % sheetDataRows / writeDataRows) : (total[0] % sheetDataRows / writeDataRows + 1));

            if (sheetNum[0] <= maxSheetNum[0]){
                writExcel(response, sheetNum[0], oneSheetWriteCount[0],lastSheetWriteCount,tRole,null,0);
            } else {
                // 分成多个文件 压缩响应
                String filePath = TRoleServiceImpl.class.getResource("/").getPath()+
                File.separator + DateUtil.format(DateUtil.date(),DatePattern.PURE_DATETIME_MS_PATTERN) +
                File.separator + "_" + DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_MS_PATTERN)+ "_" +System.currentTimeMillis();
                log.info("filePath:{}", filePath);
                FileUtil.mkdir(new File(filePath));
                int fileNum = sheetNum[0] % maxSheetNum[0] == 0 ? (sheetNum[0] / maxSheetNum[0]) : (sheetNum[0] / maxSheetNum[0]) + 1;
                CountDownLatch countDownLatch = new CountDownLatch(fileNum);
                for (int f = 0; f < fileNum; f++) {
                    int finalF = f;
                    CompletableFuture.runAsync(() -> {
                        String fileName = filePath + File.separator + "_" + DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_MS_PATTERN)+ "_" +System.currentTimeMillis() +"_" +(finalF +1)+ ".xlsx";
                        int oneSheetWriteCount2 = 0;
                        int lastSheetWriteCount2 = oneSheetWriteCount[0];
                        if (finalF == fileNum-1){
                            total[0] = total[0] - sheetDataRows * finalF * maxSheetNum[0];
                            sheetNum[0] = total[0] % sheetDataRows == 0 ? (total[0] / sheetDataRows) : (total[0] / sheetDataRows) + 1;
                            oneSheetWriteCount2 =  total[0] > sheetDataRows ? sheetDataRows / writeDataRows : total[0] % writeDataRows > 0 ? total[0] / writeDataRows + 1 : total[0] / writeDataRows;
                            lastSheetWriteCount2 = total[0] % sheetDataRows == 0 ? oneSheetWriteCount2 : (total[0] % sheetDataRows % writeDataRows == 0 ? (total[0] % sheetDataRows / writeDataRows) : (total[0] % sheetDataRows / writeDataRows + 1));
                            maxSheetNum[0] = sheetNum[0];
                            oneSheetWriteCount[0] = oneSheetWriteCount2;
                        }
                        writExcel(response, maxSheetNum[0], oneSheetWriteCount[0],lastSheetWriteCount2,tRole,fileName , finalF);
                    },threadPoolTaskExecutor).whenComplete((v,e) -> {
                    countDownLatch.countDown();
                    });
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ServletOutputStream out= null;
                FileInputStream fileInputStream = null;
                File zipFile = null;
                try {
                    zipFile = ZipUtil.zip(filePath);
                    response.setCharacterEncoding("utf8");
                    response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(zipFile.getName(), CharsetUtil.UTF_8));
                    response.setContentType("application/octet-stream");
                    response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
                    response.setHeader("luxsan", "luxsan");
                    out = response.getOutputStream();
                    fileInputStream = IoUtil.toStream(zipFile);
                    IoUtil.write(out, true, IoUtil.readBytes(fileInputStream));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != fileInputStream){
                            fileInputStream.close();
                        }
                        if (null != out){
                            out.close();
                        }
                    } catch (IOException ignored) {}
                    IoUtil.close(out);
                    FileUtil.del(filePath);
                    FileUtil.del(zipFile);
                }
            }
        }

    public void writExcel(HttpServletResponse response,int sheetNum,int oneSheetWriteCount,int lastSheetWriteCount,
        TRole tRole,String fileName,int f){
        try {
            if (StrUtil.isEmpty(fileName)){
                String file = "_" + DateUtil.format(DateUtil.date(), DatePattern.PURE_DATETIME_MS_PATTERN)+ "_" +System.currentTimeMillis() + ".xlsx";
                response.reset();
                response.setCharacterEncoding("utf8");
                response.setHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(file, CharsetUtil.UTF_8));
                response.setContentType("application/octet-stream");
                response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
                response.setHeader("luxsan", "luxsan");
                try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream(), TRoleDTO.class).build()) {
                    handleExcel(excelWriter, sheetNum, oneSheetWriteCount, lastSheetWriteCount, tRole, f);
                } catch (IOException ignored) {}
            } else {
                try (ExcelWriter excelWriter = EasyExcel.write(fileName, TRoleDTO.class).build()) {
                    handleExcel(excelWriter, sheetNum, oneSheetWriteCount, lastSheetWriteCount, tRole, f);
                }
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    private void handleExcel(ExcelWriter excelWriter, int sheetNum, int oneSheetWriteCount, int lastSheetWriteCount, TRole tRole, int f) {
        for (int i = 0; i < sheetNum; i++) {
            WriteSheet writeSheet = EasyExcel.writerSheet(i, "报表" + (i+1)).build();
            CountDownLatch countDownLatch = new CountDownLatch((i != sheetNum - 1 || i == 0 ? oneSheetWriteCount : lastSheetWriteCount));
            for (int j = 0; j < (i != sheetNum - 1 || i == 0 ? oneSheetWriteCount : lastSheetWriteCount); j++) {
                int finalJ = j;
                int finalI = i;
                CompletableFuture.runAsync(() -> {
                    if (f > 0) {
                        PageHelper.startPage(finalJ + 1 + oneSheetWriteCount * finalI + f * Constants.MAX_SHEET_NUM * (Constants.SHEET_COUNT / Constants.SHEET_WRITE_NUM) , Constants.SHEET_WRITE_NUM, false);
                    } else {
                        PageHelper.startPage(finalJ + 1 + oneSheetWriteCount * finalI, Constants.SHEET_WRITE_NUM,false);
                    }
                    List<TRole> data = tRoleMapper.selectList(new LambdaQueryWrapper<TRole>(tRole));
                    synchronized (excelWriter){
                        excelWriter.write(data, writeSheet);
                    }
                    data.clear();
                },threadPoolTaskExecutor).whenComplete((v,e) -> {
                    countDownLatch.countDown();
                });
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
