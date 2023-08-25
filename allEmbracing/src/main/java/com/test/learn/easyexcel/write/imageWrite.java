package com.test.learn.easyexcel.write;

/**
 * @author smj
 * @Title: imageWrite
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/25 8:19
 */

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.ImageData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.util.ListUtils;
import com.test.learn.easyexcel.entity.ImageDemoData;
import com.test.learn.utils.easyExcel.TestFileUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author smj
 * @date 2023/8/25 8:19
  *
 * @return
 * @since 1.0
 *
 * 图片导出*
 * 创建excel对应的实体对象 参照{@link ImageDemoData}* *
*/
public class imageWrite {
    public static void main(String[] args) {
        String fileName = TestFileUtil.getPath() + "imageWrite" + System.currentTimeMillis() + ".xlsx";

        // 这里注意下 所有的图片都会放到内存 暂时没有很好的解法，大量图片的情况下建议 2选1:
        // 1. 将图片上传到oss 或者其他存储网站: https://www.aliyun.com/product/oss ，然后直接放链接
        // 2. 使用: https://github.com/coobird/thumbnailator 或者其他工具压缩图片

        String imagePath = TestFileUtil.getPath() + "converter" + File.separator + "img.jpg";
        try (InputStream inputStream = FileUtils.openInputStream(new File(imagePath))) {
            List<ImageDemoData> list = ListUtils.newArrayList();
            ImageDemoData imageDemoData = new ImageDemoData();
            list.add(imageDemoData);
            // 放入五种类型的图片 实际使用只要选一种即可
            imageDemoData.setByteArray(FileUtils.readFileToByteArray(new File(imagePath)));
            imageDemoData.setFile(new File(imagePath));
            imageDemoData.setString(imagePath);
            imageDemoData.setInputStream(inputStream);
            imageDemoData.setUrl(new URL(
                    "https://img2.baidu.com/it/u=917382917,4109985544&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500"));

            // 这里演示
            // 需要额外放入文字
            // 而且需要放入2个图片
            // 第一个图片靠左
            // 第二个靠右 而且要额外的占用他后面的单元格
            WriteCellData<Void> writeCellData = new WriteCellData<>();
            imageDemoData.setWriteCellDataFile(writeCellData);
            // 这里可以设置为 EMPTY 则代表不需要其他数据了
            writeCellData.setType(CellDataTypeEnum.STRING);
            writeCellData.setStringValue("额外的放一些文字");

            // 可以放入多个图片
            List<ImageData> imageDataList = new ArrayList<>();
            ImageData imageData = new ImageData();
            imageDataList.add(imageData);
            writeCellData.setImageDataList(imageDataList);
            // 放入2进制图片
            imageData.setImage(FileUtils.readFileToByteArray(new File(imagePath)));
            // 图片类型
            imageData.setImageType(ImageData.ImageType.PICTURE_TYPE_PNG);
            // 上 右 下 左 需要留空
            // 这个类似于 css 的 margin
            // 这里实测 不能设置太大 超过单元格原始大小后 打开会提示修复。暂时未找到很好的解法。
            imageData.setTop(5);
            imageData.setRight(40);
            imageData.setBottom(5);
            imageData.setLeft(5);

            // 放入第二个图片
            imageData = new ImageData();
            imageDataList.add(imageData);
            writeCellData.setImageDataList(imageDataList);
            imageData.setImage(FileUtils.readFileToByteArray(new File(imagePath)));
            imageData.setImageType(ImageData.ImageType.PICTURE_TYPE_PNG);
            imageData.setTop(5);
            imageData.setRight(5);
            imageData.setBottom(5);
            imageData.setLeft(50);
            // 设置图片的位置 假设 现在目标 是 覆盖 当前单元格 和当前单元格右边的单元格
            // 起点相对于当前单元格为0 当然可以不写
            imageData.setRelativeFirstRowIndex(0);
            imageData.setRelativeFirstColumnIndex(0);
            imageData.setRelativeLastRowIndex(0);
            // 前面3个可以不写  下面这个需要写 也就是 结尾 需要相对当前单元格 往右移动一格
            // 也就是说 这个图片会覆盖当前单元格和 后面的那一格
            imageData.setRelativeLastColumnIndex(1);

            // 写入数据
            EasyExcel.write(fileName, ImageDemoData.class).sheet().doWrite(list);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
