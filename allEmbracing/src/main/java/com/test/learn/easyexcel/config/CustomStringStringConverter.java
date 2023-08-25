package com.test.learn.easyexcel.config;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @author smj
 * @Title: CustomStringStringConverter
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.config
 * @date 2023/8/24 19:30
 */

public class CustomStringStringConverter implements Converter<String> {
    /**
     * Back to object types in Java
     *
     * @return Support for Java class
     */
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    /**
     * Back to object enum in excel
     *
     * @return Support for {@link CellDataTypeEnum}
     */
    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }



    /**
     * Convert excel objects to Java objects
     *
     * @param context read converter context
     * @return Data to put into a Java object
     * @throws Exception Exception.
     */
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) throws Exception {
        return context.getReadCellData().getStringValue();
    }

    /**
     * Convert Java objects to excel objects
     *
     * @param value               Java Data.NotNull.
     * @param contentProperty     Content property.Nullable.
     * @param globalConfiguration Global configuration.NotNull.
     * @return Data to put into a Excel
     * @throws Exception Exception.
     */
    @Override
    public WriteCellData<?> convertToExcelData(String value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return Converter.super.convertToExcelData(value, contentProperty, globalConfiguration);
    }

    /**
     * Convert Java objects to excel objects
     *
     * @param context write context
     * @return Data to put into a Excel
     * @throws Exception Exception.
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        return new WriteCellData<>("自定义：" + context.getValue());
    }
}
