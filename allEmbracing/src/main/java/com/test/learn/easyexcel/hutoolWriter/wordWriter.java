package com.test.learn.easyexcel.hutoolWriter;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.word.Word07Writer;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;


/**
 * @author smj
 * @Title: wordWriter
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.hutoolWriter
 * @date 2023/9/4 8:57
 */

@Slf4j
public class wordWriter {
    public static void main(String[] args) {
        Word07Writer writer = new Word07Writer();

        // 添加段落（标题）
        writer.addText(new Font("方正小标宋简体", Font.PLAIN, 22), "我是第一部分", "我是第二部分");
        // 添加段落（正文）
        writer.addText(new Font("宋体", Font.PLAIN, 22), "我是正文第一部分", "我是正文第二部分");
        // 写出到文件
        writer.flush(FileUtil.file(TestFileUtil.getPath() + "wordWrite" + System.currentTimeMillis() + ".docx"));
        // 关闭
        writer.close();
    }
}
