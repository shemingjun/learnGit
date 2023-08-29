package com.test.learn.easyexcel.write;

/**
 * @author smj
 * @Title: longestMatchColumnWidthWrite
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/29 16:59
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.test.learn.easyexcel.entity.LongestMatchColumnWidthData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @date 2023/8/29 17:00
 * @since 1.0
 *
 * 自动列宽(不太精确)
 *  自己参照 {@link LongestMatchColumnWidthStyleStrategy} 重新实现
 *   poi 自带{@link SXSSFSheet#autoSizeColumn(int)} 对中文支持也不太好。
 *
 *  1. 创建excel对应的实体对象 参照{@link LongestMatchColumnWidthData}
 *  2. 注册策略{@link LongestMatchColumnWidthStyleStrategy}
 *
 *
*/
public class longestMatchColumnWidthWrite {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "longestMatchColumnWidthWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, LongestMatchColumnWidthData.class)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet("模板").doWrite(dataLong());

    }

    private static List<LongestMatchColumnWidthData> dataLong() {
        List<LongestMatchColumnWidthData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            LongestMatchColumnWidthData data = new LongestMatchColumnWidthData();
            data.setString("测试很长的字符串测试很长的字符串测试很长的字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(1000000000000.0);
            list.add(data);
        }
        return list;
    }
}
