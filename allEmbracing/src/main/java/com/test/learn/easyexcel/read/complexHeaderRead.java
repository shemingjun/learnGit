package com.test.learn.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.test.learn.easyexcel.config.DemoDataListener;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author smj
 * @Title: complexHeaderRead
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.read
 * @date 2023/9/2 15:25
 */

/**
 * 多行头
 *
 * <p>
 * 1. 创建excel对应的实体对象 参照{@link DemoData}
 * <p>
 * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link DemoDataListener}
 * <p>
 * 3. 设置headRowNumber参数，然后读。 这里要注意headRowNumber如果不指定， 会根据你传入的class的{@link ExcelProperty#value()}里面的表头的数量来决定行数，
 * 如果不传入class则默认为1.当然你指定了headRowNumber不管是否传入class都是以你传入的为准。
 */
@Slf4j
public class complexHeaderRead {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet()
                // 这里可以设置1，因为头就是一行。如果多行头，可以设置其他值。不传入也可以，因为默认会根据DemoData 来解析，他没有指定头，也就是默认1行
                .headRowNumber(1).doRead();
    }

}
