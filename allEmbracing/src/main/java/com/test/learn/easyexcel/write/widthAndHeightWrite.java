package com.test.learn.easyexcel.write;

/**
 * @author smj
 * @Title: widthAndHeightWrite
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/25 10:42
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.easyexcel.entity.WidthAndHeightData;
import com.test.learn.utils.easyExcel.TestFileUtil;

import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @date 2023/8/25 10:42
 * @return
 * @since 1.0
 *
 * 列宽、行高*
 * 使用注解{@link ColumnWidth}、{@link HeadRowHeight}、{@link ContentRowHeight}指定宽度或高度 *
*/
public class widthAndHeightWrite {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "widthAndHeightWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, WidthAndHeightData.class).sheet("模板").doWrite(data());

    }


    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}
