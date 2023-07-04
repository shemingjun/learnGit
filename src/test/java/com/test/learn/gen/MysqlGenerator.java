package com.test.learn.gen;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Oracle 代码生成
 *
 * @author smj
 * @since 3.5.3.1
 */
public class MysqlGenerator {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/user_db?characterEncoding=utf8&useSSL=false&autoReconnect=true&serverTimezone=UTC" ,
            "root" , "123456")
            .schema("user_db")
            .typeConvert(new MySqlTypeConvert())
             ;

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder
                                .disableOpenDir()
                                .outputDir(System.getProperty("user.dir") + "/src/main/java")
                                .author("smj")
//                        .author(scanner.apply("请输入作者名称"))
                )
                // 包配置
                .packageConfig((scanner, builder) -> builder
//                                .entity("domain")
                                .parent("com.test.learn")
//                                .parent("com")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mybatis/"))
                        .moduleName(scanner.apply("请输入模块名"))
//                                .moduleName("test")
                )
                /*.injectionConfig(builder -> builder
                        .customFile(new CustomFile.Builder()
                                .fileName("DTO.java")
                                .templatePath("/templates/entityDTO.java.vm")
                                .packageName("dto")
                                .enableFileOverride().build())
                        .customFile(new CustomFile.Builder()
                                .fileName(".js")
                                .templatePath("/templates/api.js.vm")
                                .packageName("static")
                                .enableFileOverride().build())
                        .customFile(new CustomFile.Builder()
                                .fileName("Index.vue")
                                .templatePath("/templates/index.vue.vm")
                                .packageName("static")
                                .enableFileOverride().build())
                        .customFile(new CustomFile.Builder()
                                .fileName(".SQL")
                                .templatePath("/templates/sql.vm")
                                .packageName("sql")
                                .enableFileOverride().build())
                )*/

                // 策略配置
                .strategyConfig((scanner, builder) -> builder
                        .enableSchema()
//                        .addInclude(scanner.apply("请输入表名，多个表名用,隔开"))
                        .addInclude(getTables(scanner.apply("请输入表名，多个表名用,隔开：")))
                        .entityBuilder()
                        .enableLombok()
                        .enableFileOverride()
                        .enableChainModel()
                        .enableTableFieldAnnotation()
                        .enableActiveRecord()
//                        .logicDeleteColumnName("DEL_FLAG")
//                        .logicDeletePropertyName("delFlag")
                        .naming(NamingStrategy.underline_to_camel)
                        .columnNaming(NamingStrategy.underline_to_camel)
//                        .addTableFills(new Column("ADD_DATE" , FieldFill.INSERT),
//                                new Column("ADD_BY",FieldFill.INSERT),
//                                new Column("EDIT_DATE" , FieldFill.INSERT_UPDATE),
//                                new Column("EDIT_BY" , FieldFill.INSERT_UPDATE))
                        .idType(IdType.INPUT)
//                        .addSuperEntityColumns(superEntityColumns())
                        .controllerBuilder()
                        .enableRestStyle()
//                        .superClass(BaseController.class)
                        .enableFileOverride()
                        .serviceBuilder()
                        .enableFileOverride()
                        .mapperBuilder()
//                        .enableBaseColumnList()
                        .enableFileOverride()
//                        .enableBaseResultMap()


                )
                .execute();
    }

    private static List<String> superEntityColumns() {
        List<String> stringList = new ArrayList<>();
        stringList.add("ID");
        stringList.add("DEL_FLAG");
        stringList.add("ADD_DATE");
        stringList.add("ADD_BY");
        stringList.add("EDIT_DATE");
        stringList.add("EDIT_BY");
        stringList.add("PROPERTY_01");
        stringList.add("PROPERTY_02");
        stringList.add("PROPERTY_03");
        stringList.add("PROPERTY_04");
        stringList.add("PROPERTY_05");
        stringList.add("PROPERTY_06");
        stringList.add("PROPERTY_07");
        stringList.add("PROPERTY_08");
        stringList.add("PROPERTY_09");
        stringList.add("PROPERTY_10");
        stringList.add("PROPERTY_ONE");
        stringList.add("PROPERTY_TWO");
        stringList.add("PROPERTY_THREE");
        stringList.add("PROPERTY_FOUR");
        stringList.add("PROPERTY_FIVE");
        stringList.add("PROPERTY_SIX");
        stringList.add("PROPERTY_SEVEN");
        stringList.add("PROPERTY_EIGHT");
        stringList.add("PROPERTY_NINE");
        stringList.add("PROPERTY_TEN");
        return stringList;
    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
