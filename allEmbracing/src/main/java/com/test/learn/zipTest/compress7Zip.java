package com.test.learn.zipTest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.compress.CompressUtil;
import com.test.learn.utils.easyExcel.TestFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

import java.io.File;

/**
 * @author smj
 * @Title: compressZip
 * @ProjectName learnGit
 * @packageName com.test.learn.zipTest
 * @date 2023/9/4 14:48
 */

/**
 * @author smj
 * @date 2023/9/4 16:14
 * @since 1.0
 *
 *
 *引入以下依赖
 *          <dependency>
 *             <groupId>org.apache.commons</groupId>
 *             <artifactId>commons-compress</artifactId>
 *             <version>1.23.0</version>
 *         </dependency>
 *         <!-- org/tukaani/xz/FilterOptions 异常时引入以下jar    -->
 *         <dependency>
 *             <groupId>org.tukaani</groupId>
 *             <artifactId>xz</artifactId>
 *             <version>1.9</version>
 *         </dependency>
 *
 *
 * 其中ArchiveStreamFactory.SEVEN_Z 就是自定义的压缩格式，可以自行选择
 * {@link ArchiveStreamFactory}
 *
 * add方法同时支持文件或目录，多个文件目录多次调用add方法即可。
 *
 *有时候我们不想把目录下所有的文件放到压缩包，这时候可以使用add方法的第二个参数Filter，此接口用于过滤不需要加入的文件。
*/
@Slf4j
public class compress7Zip {
    public static void main(String[] args) {
        final File file = FileUtil.file(TestFileUtil.getPath() + "compress" + File.separator + "compressDemo.7z");
        CompressUtil.createArchiver(CharsetUtil.CHARSET_UTF_8, ArchiveStreamFactory.SEVEN_Z, file)
                .add(FileUtil.file(TestFileUtil.getPath()+"demo"))
                .add(FileUtil.file(TestFileUtil.getPath()+"demo/demo.xlsx"))
                .add(FileUtil.file("e://1.png"))
                .add(FileUtil.file(TestFileUtil.getPath()+"converter"), (file1)->{
                    log.info("fileName:{}", file1.getName());
                    if (StrUtil.containsAny(file1.getName(),"img")) {
                        return false;
                    }
                    return true;
                })
                .finish()
                .close();

    }
}
