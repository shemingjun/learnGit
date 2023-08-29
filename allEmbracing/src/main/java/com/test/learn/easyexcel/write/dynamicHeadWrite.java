package com.test.learn.easyexcel.write;

/**
 * @author smj
 * @Title: dynamicHeadWrite
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/29 16:40
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;

import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @date 2023/8/29 16:40
 * @since 1.0
 *
 * 动态头，实时生成头写入
 * 思路是这样子的，先创建List<String>头格式的sheet仅仅写入头,然后通过table 不写入头的方式 去写入数据
 *
*/
public class dynamicHeadWrite {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "dynamicHeadWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName)
                // 这里放入动态头
                .head(head()).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(data());
    }

    private static List<List<String>> head() {
        List<List<String>> list = ListUtils.newArrayList();
        List<String> head0 = ListUtils.newArrayList();
        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = ListUtils.newArrayList();
        head1.add("数字" + System.currentTimeMillis());
        List<String> head2 = ListUtils.newArrayList();
        head2.add("日期" + System.currentTimeMillis());
        list.add(head0);
        list.add(head1);
        list.add(head2);
        return list;
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
