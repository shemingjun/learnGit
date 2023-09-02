package com.test.learn.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.test.learn.easyexcel.config.CellDataDemoHeadDataListener;
import com.test.learn.easyexcel.entity.CellDataReadDemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author smj
 * @Title: cellDataRead
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.read
 * @date 2023/9/2 16:14
 */


/**
 * 读取公式和单元格类型
 *
 * <p>
 * 1. 创建excel对应的实体对象 参照{@link CellDataReadDemoData}
 * <p>
 * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoHeadDataListener}
 * <p>
 * 3. 直接读即可
 *
 * @since 2.2.0-beat1
 */
@Slf4j
public class cellDataRead {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "cellDataDemo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, CellDataReadDemoData.class, new CellDataDemoHeadDataListener()).sheet().doRead();
    }

}
