package com.test.learn.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.converters.DefaultConverterLoader;
import com.test.learn.easyexcel.config.ConverterDataListener;
import com.test.learn.easyexcel.entity.ConverterData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author smj
 * @Title: converterRead
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.read
 * @date 2023/9/2 15:08
 */

/**
 * 日期、数字或者自定义格式转换
 * <p>
 * 默认读的转换器{@link DefaultConverterLoader#loadDefaultReadConverter()}
 * <p>
 * 1. 创建excel对应的实体对象 参照{@link ConverterData}.里面可以使用注解{@link DateTimeFormat}、{@link NumberFormat}或者自定义注解
 * <p>
 * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link ConverterDataListener}
 * <p>
 * 3. 直接读即可
 */
@Slf4j
public class converterRead {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet
        EasyExcel.read(fileName, ConverterData.class, new ConverterDataListener())
                // 这里注意 我们也可以registerConverter来指定自定义转换器， 但是这个转换变成全局了， 所有java为string,excel为string的都会用这个转换器。
                // 如果就想单个字段使用请使用@ExcelProperty 指定converter
                // .registerConverter(new CustomStringStringConverter())
                // 读取sheet
                .sheet().doRead();
    }

}
