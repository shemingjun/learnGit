package com.test.learn.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author smj
 * @Title: EcGrossProfit
 * @ProjectName learnGit
 * @packageName com.test.learn.easyexcel.entity
 * @date 2023/8/25 14:00
 */
@Data
public class EcGrossProfit implements Serializable {
    private static final long serialVersionUID = -18157132088731742L;
    /**

     主键ID
     */
     @ExcelProperty("序号")
     private Long id;
     /*
     所属月份
     */
    @ExcelIgnore
    private String tradeMonth;
    @ExcelIgnore
    private Integer grossProfitType;
    /**

     所属状态
     */
     @ExcelProperty("所属状态")
     private String grossProfitTypeName;
     /*
     平台-1
     */
     @ExcelProperty("平台")
     private String platform;
     /*
     订单进退-2
     */
     @ExcelProperty("订单进退")
     private String orderForwarding;
     /*
     订单数量-3
     */
     @ExcelProperty("订单数量")
     private Integer orderQuantity;
     /*
     店铺名称-4
     */
     @ExcelProperty("店铺名称")
     private String shopName;
     /*
     店铺固定名称-5
     */
     @ExcelProperty("店铺固定名称")
     private String shopFixedName;
     /*
     入账月份-6
     */
     @ExcelProperty("入账月份")
     private String accountMonth;
     /*
     订单月份-7
     */
     @ExcelProperty("订单月份")
     private String orderMonth;
     /*
     到账月份-8
     */
     @ExcelProperty("到账月份")
     private String billMonth;
     /*
     子订单号-9
     */
     @ExcelProperty("子订单号")
     private String subOrderNo;
     /*
     已结算子订单号-10
     */
     @ExcelProperty("已结算子订单号")
     private String subSettleOrderNo;
     /*
     商品名称&选购商品-11
     */
     @ExcelProperty("商品名称&选购商品")
     private String productNameAndBuyProduct;
     /*
     商家编码&达人名称-12
     */
     @ExcelProperty("商家编码&达人名称")
     private String sellerCodeAndAuthor;
     /*
     商品名称-13
     */
     @ExcelProperty("商品名称")
     private String productName;
     /*
     选购商品-14
     */
     @ExcelProperty("选购商品")
     private String buyProductName;
     /*
     商品规格-15
     */
     @ExcelProperty("商品规格")
     private String productSku;
     /*
     商品ID-16
     */
     @ExcelProperty("商品ID")
     private String productId;
     /*
     商家编码-17
     */
     @ExcelProperty("商家编码")
     private String sellerCode;
     /*
     商品单价-18
     */
     @ExcelProperty("商品单价")
     private BigDecimal productPrice;
     /*
     商品数量-19
     */
     @ExcelProperty("商品数量")
     private Integer productQuantity;
     /*
     数量拆分（总）-20
     */
     @ExcelProperty("数量拆分（总）")
     private Integer splitQuantity;
     /*
     订单应付金额（自置）-21
     */
     @ExcelProperty("订单应付金额（自置）")
     private BigDecimal orderPayAmountSelf;
     /*
     订单应付金额-22
     */
     @ExcelProperty("订单应付金额")
     private BigDecimal orderPayAmount;
     /*
     订单-运费-23
     */
     @ExcelProperty("运费")
     private BigDecimal freight;
     /*
     优惠总金额-24
     */
     @ExcelProperty("优惠总金额")
     private BigDecimal totalDisAmount;
     /*
     平台优惠-25
     */
     @ExcelProperty("平台优惠")
     private String platformDisInfo;
     /*
     商家优惠-26
     */
     @ExcelProperty("商家优惠")
     private String sellerDisInfo;
     /*
     商家优惠金额-27
     */
     @ExcelProperty("商家优惠金额")
     private BigDecimal sellerDisAmount;
     /*
     主播优惠-28
     */
     @ExcelProperty("主播优惠")
     private String authorDisInfo;
     /*
     商家改价-29
     */
     @ExcelProperty("商家改价")
     private BigDecimal sellerChangePrice;
     /*
     支付优惠-30
     */
     @ExcelProperty("支付优惠")
     private String payDisInfo;
     /*
     红包抵扣-31
     */
     @ExcelProperty("红包抵扣")
     private String redPacketDeduct;
     /*
     支付方式-32
     */
     @ExcelProperty("支付方式")
     private String payType;
     /*
     手续费-33
     */
     @ExcelProperty("手续费")
     private BigDecimal tradeFee;
     /*
     订单提交日期-34
     */
     @ExcelProperty("订单提交日期")
     private String orderCreateDate;
     /*
     旗帜颜色-35
     */
     @ExcelProperty("旗帜颜色")
     private String flagColor;
     /*
     订单类型-36
     */
     @ExcelProperty("订单类型")
     private String orderType;
     /*
     订单完成时间-37
     */
     @ExcelProperty("订单完成时间")
     private String orderFinishTime;
     /*
     支付完成时间-38
     */
     @ExcelProperty("支付完成时间")
     private String payFinishTime;
     /*
     APP渠道-39
     */
     @ExcelProperty("APP渠道")
     private String appChannel;
     /*
     订单状态-40
     */
     @ExcelProperty("订单状态")
     private String orderStatus;
     /*
     达人ID-41
     */
     @ExcelProperty("达人ID")
     private String authorId;
     /*
     达人昵称-42
     */
     @ExcelProperty("达人昵称")
     private String authorName;
     /*
     售后状态1-43
     */
     @ExcelProperty("售后状态1")
     private String afterSalesStatus;
     /*
     结算状态（动账）-44
     */
     @ExcelProperty("结算状态（动账）")
     private String settleStatus;
     /*
     动账日期-45
     */
     @ExcelProperty("动账日期")
     private String billChangeDate;
     /*
     订单实付应结（+）-46
     */
     @ExcelProperty("订单实付应结（+）")
     private BigDecimal actualOrderSettleAmount;
     /*
     订单运费（+）-47
     */
     @ExcelProperty("订单运费（+）")
     private BigDecimal orderFreight;
     /*
     订单补贴（+）-48
     */
     @ExcelProperty("订单补贴（+）")
     private BigDecimal orderSubsidyAmount;
     /*
     订单退款(-）-49
     */
     @ExcelProperty("订单退款(-）")
     private BigDecimal orderRefundAmount;
     /*
     平台服务费比例-50
     */
     @ExcelProperty("平台服务费比例")
     private BigDecimal productPlatformServiceFeeRate;
     /*
     平台服务费（-）-51
     */
     @ExcelProperty("平台服务费（-）")
     private BigDecimal productPlatformServiceFee;
     /*
     佣金比例(线上）-52
     */
     @ExcelProperty("佣金比例(线上）")
     private BigDecimal productOnlineCommissionRate;
     /*
     线上佣金(-)-53
     */
     @ExcelProperty("线上佣金(-)")
     private BigDecimal productOnlineCommissionAmount;
     /*
     佣金比例(线下）-54
     */
     @ExcelProperty("佣金比例(线下）")
     private BigDecimal productOfflineCommissionRate;
     /*
     线下佣金(-)-55
     */
     @ExcelProperty("线下佣金(-)")
     private BigDecimal productOfflineCommissionAmount;
     /*
     招商服务费(比例)-56
     */
     @ExcelProperty("招商服务费(比例)")
     private BigDecimal productBusinessServiceFeeRate;
     /*
     招商服务费(-)-57
     */
     @ExcelProperty("招商服务费(-)")
     private BigDecimal productBusinessServiceFee;
     /*
     其他费用（-）-58
     */
     @ExcelProperty("其他费用(-)")
     private BigDecimal productOtherFee;
     /*
     订单净收益-59
     */
     @ExcelProperty("订单净收益")
     private BigDecimal orderNetIncomeAmount;
     /*
     线下佣金比例(特殊)-60
     */
     @ExcelProperty("动账-线下佣金比例(特殊)")
     private BigDecimal offlineSpCommissionRate;
     /*
     线下佣金(元)-61
     */
     @ExcelProperty("动账-线下佣金(元)")
     private BigDecimal offlineCommissionAmount;
     /*
     线上佣金比例-62
     */
     @ExcelProperty("动账-线上佣金比例")
     private BigDecimal onlineCommissionRate;
     /*
     线上佣金(元)-63
     */
     @ExcelProperty("动账-线上佣金(元)")
     private BigDecimal onlineCommissionAmount;
     /*
     招商服务费比例-64
     */
     @ExcelProperty("动账-招商服务费比例")
     private BigDecimal businessServiceFeeRate;
     /*
     招商服务费(-)-65
     */
     @ExcelProperty("动账-招商服务费(-)")
     private BigDecimal businessServiceFee;
     /*
     运费实付-66
     */
     @ExcelProperty("动账-运费实付")
     private BigDecimal actualFreight;
     /*
     其他费用（-）-67
     */
     @ExcelProperty("动账-其他费用（-）")
     private BigDecimal otherFee;
     /*
     订单收益（销售订单玩家付款）-68
     */
     @ExcelProperty("动账-订单收益（销售订单玩家付款）")
     private BigDecimal playerOrderIncomeAmount;
     /*
     订单净收益（销售订单金额-达人佣金-招商服务费-其他费用）-69
     */
     @ExcelProperty("动账-订单净收益（销售订单金额-达人佣金-招商服务费-其他费用）")
     private BigDecimal playerOrderNetIncomeAmount;
     /*
     平台补帖-70
     */
     @ExcelProperty("动账-平台补帖")
     private BigDecimal platformSubsidyAmount;
     /*
     平台服务费比例-71
     */
     @ExcelProperty("动账-平台服务费比例")
     private BigDecimal platformServiceFeeRate;
     /*
     平台服务费（-）-72
     */
     @ExcelProperty("动账-平台服务费（-）")
     private BigDecimal platformServiceFee;
     /*
     应收(入账数据)-73
     */
     @ExcelProperty("动账-应收(入账数据)")
     private BigDecimal actualInAmount;
     /*
     检验列-74
     */
     @ExcelProperty("动账-检验列")
     private String checkRow;
     /*
     线上佣金差异-75
     */
     @ExcelProperty("线上佣金差异")
     private BigDecimal onlineCommissionAmountDiff;
     /*
     线下佣金差异-76
     */
     @ExcelProperty("线下佣金差异")
     private BigDecimal offlineCommissionAmountDiff;
     /*
     订单招商服务费差异-77
     */
     @ExcelProperty("订单招商服务费差异")
     private BigDecimal businessServiceFeeDiff;
     /*
     平台服务费差异-78
     */
     @ExcelProperty("平台服务费差异")
     private BigDecimal platformServiceFeeDiff;
     /*
     订单收益差异-79
     */
     @ExcelProperty("订单收益差异")
     private BigDecimal orderIncomeAmountDiff;
     /*
     计提-供应商名称-80
     */
     @ExcelProperty("供应商名称")
     private String supplierName;
     /*
     计提-产品进货单价-81
     */
     @ExcelProperty("计提-产品进货单价")
     private BigDecimal productRestockPrice;
     /*
     计提-运费-82
     */
     @ExcelProperty("计提-运费")
     private BigDecimal productFreight;
     /*
     计提-产品成本金额-83
     */
     @ExcelProperty("计提-产品成本金额")
     private BigDecimal productCostAmount;
     /*
     实际结算-产品进货单价-84
     */
     @ExcelProperty("实际结算-产品进货单价")
     private BigDecimal actualProductRestockPrice;
     /*
     实际结算-运费-85
     */
     @ExcelProperty("实际结算-运费")
     private BigDecimal actualProductFreight;
     /*
     实际结算-产品成本金额-86
     */
     @ExcelProperty("实际结算-产品成本金额")
     private BigDecimal actualProductCostAmount;
     /*
     成本单价差异-87
     */
     @ExcelProperty("成本单价差异")
     private BigDecimal productRestockPriceDiff;
     /*
     运费差异-88
     */
     @ExcelProperty("运费差异")
     private BigDecimal productFreightDiff;
     /*
     结算差异-89
     */
     @ExcelProperty("结算差异")
     private BigDecimal productCostAmountDiff;
     /*
     毛利-90
     */
     @ExcelProperty("毛利")
     private BigDecimal grossProfitAmount;
     /*
      */
     @ExcelProperty("XX分润")
     private BigDecimal mxProfitDivideAmount;
     /*
     毛利率-92
     */
     @ExcelProperty("毛利率")
     private BigDecimal grossProfitRate;
     /*
     运营方-93
     */
     @ExcelProperty("运营方")
     private String operator;
     /*
     成本结算状态-94
     */
     @ExcelProperty("成本结算状态")
     private String productCostSettleStatus;
     /*
     流量来源-95
     */
     @ExcelProperty("流量来源")
     private String flowOrigin;
     /*
     成本(康多洁/泉州善芳/画之心/拼多多）-96
     */
     @ExcelProperty("成本(康多洁/泉州善芳/画之心/拼多多）")
     private BigDecimal spProductCostAmount;
     /*
     外包装（鹏城印务）-97
     */
     @ExcelProperty("外包装（鹏城印务）")
     private BigDecimal productPackageAmount;
     /*
     运费（格林/苍龙/wukong云仓）-98
     */
     @ExcelProperty("运费（格林/苍龙/wukong云仓）")
     private BigDecimal spProductFreight;
     /*
     创建人
     */
     @ExcelIgnore
     private String createBy;
     /*
     创建时间
     */
     @ExcelIgnore
     private Date createTime;
     /*
     更新人
     */
     @ExcelIgnore
     private String updateBy;
     /*
     更新时间
     */
    @ExcelIgnore
    private Date updateTime;
}
