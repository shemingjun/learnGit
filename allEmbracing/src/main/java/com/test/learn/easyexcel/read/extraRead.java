package com.test.learn.easyexcel.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.test.learn.easyexcel.config.DemoExtraListener;
import com.test.learn.easyexcel.entity.DemoExtraData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author smj
 * @Title: extraRead
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.read
 * @date 2023/9/2 16:01
 */

@Slf4j
public class extraRead {
    public static void main(String[] args) {
        {
            String fileName = TestFileUtil.getPath() + "demo" + File.separator + "extra.xlsx";
            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
            EasyExcel.read(fileName, DemoExtraData.class, new DemoExtraListener())
                    // 需要读取批注 默认不读取
                    .extraRead(CellExtraTypeEnum.COMMENT)
                    // 需要读取超链接 默认不读取
                    .extraRead(CellExtraTypeEnum.HYPERLINK)
                    // 需要读取合并单元格信息 默认不读取
                    .extraRead(CellExtraTypeEnum.MERGE).sheet().doRead();
        }
    }
}
