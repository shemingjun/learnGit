package com.test.learn.easyexcel.config;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.exception.ExcelDataConvertException;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import com.test.learn.easyexcel.entity.ExceptionDemoData;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author smj
 * @Title: DemoExceptionListener
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.config
 * @date 2023/9/2 16:36
 */

@Slf4j
public class DemoExceptionListener implements ReadListener<ExceptionDemoData> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;

    private List<ExceptionDemoData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);


    /**
     * All listeners receive this method when any one Listener does an error report. If an exception is thrown here, the
     * entire read will terminate.
     *
     * @param exception
     * @param context
     * @throws Exception
     */
    @Override
    public void onException(Exception exception, AnalysisContext context) {
        log.error("解析失败，但是继续解析下一行:{}", exception.getMessage());
        // 如果是某一个单元格的转换异常 能获取到具体行号
        // 如果要获取头的信息 配合invokeHeadMap使用
        if (exception instanceof ExcelDataConvertException) {
            ExcelDataConvertException excelDataConvertException = (ExcelDataConvertException)exception;
            log.error("第{}行，第{}列解析异常，数据为:{}", excelDataConvertException.getRowIndex(),
                    excelDataConvertException.getColumnIndex(), excelDataConvertException.getCellData());
        }
    }

    /**
     * When analysis one head row trigger invoke function.
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        log.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
    }

    /**
     * When analysis one row trigger invoke function.
     *
     * @param data    one row value. It is same as {@link AnalysisContext#readRowHolder()}
     * @param context analysis context
     */
    @Override
    public void invoke(ExceptionDemoData data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * The current method is called when extra information is returned
     *
     * @param extra   extra information
     * @param context analysis context
     */
    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        ReadListener.super.extra(extra, context);
    }

    /**
     * if have something to do after all analysis
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * Verify that there is another piece of data.You can stop the read by returning false
     *
     * @param context
     * @return
     */
    @Override
    public boolean hasNext(AnalysisContext context) {
        return ReadListener.super.hasNext(context);
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        log.info("存储数据库成功！");
    }
}
