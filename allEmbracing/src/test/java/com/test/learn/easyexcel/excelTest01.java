package com.test.learn.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.util.TestFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @Title: excelTest01
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel
 * @date 2023/7/4 11:28
 */
@Slf4j
public class excelTest01 {

    @Test
    void test01(){
        // 写法1
        String fileName = TestFileUtil.getPath() + "noModelWrite" + System.currentTimeMillis() + ".xlsx";

        List<List<String>> head = ListUtils.newArrayList();
        List<String> head0 = ListUtils.newArrayList();
        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = ListUtils.newArrayList();
        head1.add("数字" + System.currentTimeMillis());
        List<String> head2 = ListUtils.newArrayList();
        head2.add("日期" + System.currentTimeMillis());
        head.add(head0);
        head.add(head1);
        head.add(head2);

        List<List<Object>> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            List<Object> data = ListUtils.newArrayList();
            data.add("字符串" + i);
            data.add(0.56);
            data.add(new Date());
            list.add(data);
        }


        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName).head(head).sheet("模板").doWrite(list);
    }
}
