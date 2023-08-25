package com.test.learn.easyexcel.write;

/**
 * @author smj
 * @Title: annotationStyleWrite
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/25 11:02
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.easyexcel.entity.DemoStyleData;
import com.test.learn.utils.easyExcel.TestFileUtil;

import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @date 2023/8/25 11:03
 * @return
 * @since 1.0
 * 注解形式自定义样式
 * 创建excel对应的实体对象 参照{@link DemoStyleData}
*/
public class annotationStyleWrite {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "annotationStyleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoStyleData.class).sheet("模板").doWrite(data());

    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 50; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}
