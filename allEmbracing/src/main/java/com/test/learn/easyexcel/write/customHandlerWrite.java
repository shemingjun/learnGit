package com.test.learn.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.easyexcel.config.CustomCellWriteHandler;
import com.test.learn.easyexcel.config.CustomSheetWriteHandler;
import com.test.learn.easyexcel.entity.DemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

/**
 * @author smj
 * @Title: customHandlerWrite
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/29 17:53
 *
 * 下拉，超链接等自定义拦截器（上面几点都不符合但是要对单元格进行操作的参照这个）
 * demo这里实现2点。1. 对第一行第一列的头超链接到:https://github.com/alibaba/easyexcel
 *                2. 对第一列第一行和第二行的数据新增下拉框，显示 测试1 测试2
 * 1. 创建excel对应的实体对象 参照{@link DemoData}
 * 2. 注册拦截器 {@link CustomCellWriteHandler} {@link CustomSheetWriteHandler}
 *
 *
 */
@Slf4j
public class customHandlerWrite {

    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "customHandlerWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, DemoData.class).registerWriteHandler(new CustomSheetWriteHandler())
                .registerWriteHandler(new CustomCellWriteHandler()).sheet("模板").doWrite(data());

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
