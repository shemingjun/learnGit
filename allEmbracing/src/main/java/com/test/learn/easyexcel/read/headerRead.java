package com.test.learn.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.test.learn.easyexcel.config.DemoHeadDataListener;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author smj
 * @Title: headerRead
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.read
 * @date 2023/9/2 15:34
 */
/**
 * 读取表头数据
 *
 * <p>
 * 1. 创建excel对应的实体对象 参照{@link DemoData}
 * <p>
 * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoHeadDataListener}
 * <p>
 * 3. 直接读即可
 */
@Slf4j
public class headerRead {
    public static void main(String[] args) {
        {
            String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
            EasyExcel.read(fileName, DemoData.class, new DemoHeadDataListener()).sheet().doRead();
        }
    }
}
