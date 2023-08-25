package com.test.learn.easyexcel.write;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.test.learn.easyexcel.entity.EcGrossProfit;
import com.test.learn.utils.easyExcel.TestFileUtil;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author smj
 * @Title: Test
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.write
 * @date 2023/8/25 13:52
 */

public class Test2 {
    public static long step = 0;
    public static void main(String[] args) {
        TimeInterval timer = DateUtil.timer();
        // 方法1: 如果写到同一个sheet
        String fileName = TestFileUtil.getPath() + File.separator + "100WrepeatedWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, EcGrossProfit.class).build()) {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 1; i <= 100; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<EcGrossProfit> data = data(i);
                excelWriter.write(data, writeSheet);
            }
            excelWriter.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Console.log(timer.interval()/1000);
//        Console.log(timer.intervalMinute());
    }



    private static List<EcGrossProfit> data(int j) {
        List<EcGrossProfit> list = ListUtils.newArrayList();
        for (int i = 1; i <= 10000; i++) {
            EcGrossProfit data = new EcGrossProfit();
            data.setId(step++);
            data.setTradeMonth("13123");
            data.setGrossProfitType(1);
            data.setGrossProfitTypeName("13123");
            data.setPlatform("131231");
            data.setOrderForwarding("13213123");
            data.setOrderQuantity(123);
            data.setShopName("sfsdfsef");
            data.setShopFixedName("13123123");
            data.setAccountMonth("1312312");
            data.setOrderMonth("1312312");
            data.setBillMonth("13123");
            data.setSubOrderNo("sfsdfrsdf");
            data.setSubSettleOrderNo("1312312");
            data.setProductNameAndBuyProduct("13123");
            data.setSellerCodeAndAuthor("fsdfsd");
            data.setProductName("131231");
            data.setBuyProductName("4324234");
            data.setProductSku("123123");
            data.setProductId("1q312312");
            data.setSellerCode("1231232");
            data.setProductPrice(BigDecimal.valueOf(100));
            data.setProductQuantity(123);
            data.setSplitQuantity(113);
            data.setOrderPayAmountSelf(BigDecimal.valueOf(100));
            data.setOrderPayAmount(BigDecimal.valueOf(100));
            data.setFreight(BigDecimal.valueOf(100));
            data.setTotalDisAmount(BigDecimal.valueOf(100));
            data.setPlatformDisInfo("3123");
            data.setSellerDisInfo("123123");
            data.setSellerDisAmount(BigDecimal.valueOf(100));
            data.setAuthorDisInfo("131231");
            data.setSellerChangePrice(BigDecimal.valueOf(100));
            data.setPayDisInfo("1q3212312");
            data.setRedPacketDeduct("12312312");
            data.setPayType("q32121");
            data.setTradeFee(BigDecimal.valueOf(100));
            data.setOrderCreateDate("123123");
            data.setFlagColor("1q3123");
            data.setOrderType("123123");
            data.setOrderFinishTime("12312312");
            data.setPayFinishTime("12312312");
            data.setAppChannel("123123");
            data.setOrderStatus("12312");
            data.setAuthorId("13123");
            data.setAuthorName("1312312");
            data.setAfterSalesStatus("1312312");
            data.setSettleStatus("1312312");
            data.setBillChangeDate("13123123");
            data.setActualOrderSettleAmount(BigDecimal.valueOf(100));
            data.setOrderFreight(BigDecimal.valueOf(100));
            data.setOrderSubsidyAmount(BigDecimal.valueOf(100));
            data.setOrderRefundAmount(BigDecimal.valueOf(100));
            data.setProductPlatformServiceFeeRate(BigDecimal.valueOf(100));
            data.setProductPlatformServiceFee(BigDecimal.valueOf(100));
            data.setProductOnlineCommissionRate(BigDecimal.valueOf(100));
            data.setProductOnlineCommissionAmount(BigDecimal.valueOf(100));
            data.setProductOfflineCommissionRate(BigDecimal.valueOf(100));
            data.setProductOfflineCommissionAmount(BigDecimal.valueOf(100));
            data.setProductBusinessServiceFeeRate(BigDecimal.valueOf(100));
            data.setProductBusinessServiceFee(BigDecimal.valueOf(100));
            data.setProductOtherFee(BigDecimal.valueOf(100));
            data.setOrderNetIncomeAmount(BigDecimal.valueOf(100));
            data.setOfflineSpCommissionRate(BigDecimal.valueOf(100));
            data.setOfflineCommissionAmount(BigDecimal.valueOf(100));
            data.setOnlineCommissionRate(BigDecimal.valueOf(100));
            data.setOnlineCommissionAmount(BigDecimal.valueOf(100));
            data.setBusinessServiceFeeRate(BigDecimal.valueOf(100));
            data.setBusinessServiceFee(BigDecimal.valueOf(100));
            data.setActualFreight(BigDecimal.valueOf(100));
            data.setOtherFee(BigDecimal.valueOf(100));
            data.setPlayerOrderIncomeAmount(BigDecimal.valueOf(100));
            data.setPlayerOrderNetIncomeAmount(BigDecimal.valueOf(100));
            data.setPlatformSubsidyAmount(BigDecimal.valueOf(100));
            data.setPlatformServiceFeeRate(BigDecimal.valueOf(100));
            data.setPlatformServiceFee(BigDecimal.valueOf(100));
            data.setActualInAmount(BigDecimal.valueOf(100));
            data.setCheckRow("13123");
            data.setOnlineCommissionAmountDiff(BigDecimal.valueOf(100));
            data.setOfflineCommissionAmountDiff(BigDecimal.valueOf(100));
            data.setBusinessServiceFeeDiff(BigDecimal.valueOf(100));
            data.setPlatformServiceFeeDiff(BigDecimal.valueOf(100));
            data.setOrderIncomeAmountDiff(BigDecimal.valueOf(100));
            data.setSupplierName("1312312");
            data.setProductRestockPrice(BigDecimal.valueOf(100));
            data.setProductFreight(BigDecimal.valueOf(100));
            data.setProductCostAmount(BigDecimal.valueOf(100));
            data.setActualProductRestockPrice(BigDecimal.valueOf(100));
            data.setActualProductFreight(BigDecimal.valueOf(100));
            data.setActualProductCostAmount(BigDecimal.valueOf(100));
            data.setProductRestockPriceDiff(BigDecimal.valueOf(100));
            data.setProductFreightDiff(BigDecimal.valueOf(100));
            data.setProductCostAmountDiff(BigDecimal.valueOf(100));
            data.setGrossProfitAmount(BigDecimal.valueOf(100));
            data.setMxProfitDivideAmount(BigDecimal.valueOf(100));
            data.setGrossProfitRate(BigDecimal.valueOf(100));
            data.setOperator("1111");
            data.setProductCostSettleStatus("1111");
            data.setFlowOrigin("1111");
            data.setSpProductCostAmount(BigDecimal.valueOf(100));
            data.setProductPackageAmount(BigDecimal.valueOf(100));
            data.setSpProductFreight(BigDecimal.valueOf(100));
            list.add(data);
        }
        return list;
    }



}
