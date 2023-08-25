package com.test.learn.easyexcel.write;

/**
 * @author smj
 * @Title: templateWrite
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/25 10:25
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @date 2023/8/25 10:25
 * @return
 * @since 1.0
 *
 * 根据模板写入* *
*/
public class templateWrite {

    public static void main(String[] args) {
        String templateFileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        String fileName = TestFileUtil.getPath() + "templateWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 这里要注意 withTemplate 的模板文件会全量存储在内存里面，所以尽量不要用于追加文件，如果文件模板文件过大会OOM
        // 如果要再文件中追加（无法在一个线程里面处理，可以在一个线程的建议参照多次写入的demo） 建议临时存储到数据库 或者 磁盘缓存(ehcache) 然后再一次性写入
        EasyExcel.write(fileName, DemoData.class).withTemplate(templateFileName).sheet().doWrite(data());

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
