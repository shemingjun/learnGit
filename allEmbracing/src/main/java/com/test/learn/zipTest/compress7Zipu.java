package com.test.learn.zipTest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.extra.compress.CompressUtil;
import cn.hutool.extra.compress.extractor.Extractor;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author smj
 * @Title: compress7Zipu
 * @ProjectName learnGit
 * @packageName com.test.learn.zipTest
 * @date 2023/9/4 16:33
 * 解压文件*
 */

@Slf4j
public class compress7Zipu {
    public static void main(String[] args) {
        final File file = FileUtil.file(TestFileUtil.getPath() + "compress" + File.separator + "compressDemo.7z");
        Extractor extractor = CompressUtil.createExtractor(
                CharsetUtil.defaultCharset(), file);

        extractor.extract(FileUtil.file(TestFileUtil.getPath()+"test/compress/test2/"));
    }
}
