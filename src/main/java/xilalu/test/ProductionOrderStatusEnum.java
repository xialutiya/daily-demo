package com.oppein.retail.order.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * 订单状态枚举
 * </pre>
 * @author keshijun
 * @version 1.00.00
 * @date 2020-08-25 15:27
 */
public enum ProductionOrderStatusEnum {

    ORDER_STATU_1000("1000","已传单"),
    ORDER_STATU_0("0","未传单"),
    ORDER_STATU_1001("1001","已接单"),
    ORDER_STATU_1006("1006","技术审核中"),
    ORDER_STATU_1009("1009","技术审核通过"),
    ORDER_STATU_1011("1011","技术审核不通过"),
    ORDER_STATU_1012("1012","已取消"),
    ORDER_STATU_1014("1014","价格审核通过"),
    ORDER_STATU_1015("1015","价格审核不通过"),
    ORDER_STATU_1016("1016","价格审核中"),
    ORDER_STATU_1020("1020","等待扣款"),
    ORDER_STATU_1021("1021","扣款通过"),
    ORDER_STATU_1022("1022","扣款失败"),
    ORDER_STATU_1023("1023","已排期"),
    ORDER_STATU_1024("1024","已排产"),
    ORDER_STATU_1026("1026","生产中"),
    ORDER_STATU_1027("1027","包装完成"),
    ORDER_STATU_1029("1029","入库中"),
    ORDER_STATU_1030("1030","已入库"),
    ORDER_STATU_1032("1032","等待收货"),
    ORDER_STATU_350("350","排产待确定"),
    ORDER_STATU_400("400","排产完成"),
    ORDER_STATU_450("450","已暂停"),
    ORDER_STATU_997("997","审核五金"),
    ORDER_STATU_998("998","已归档"),
    ORDER_STATU_100("100","待排产"),
    ORDER_STATU_1046("1046","流程暂停"),
    ORDER_STATU_1047("1047","炸单中"),
    ORDER_STATU_1048("1048","趟门下单中"),
    ORDER_STATU_1049("1049","趟门下单不通过"),
    ORDER_STATU_1050("1050","趟门下单通过"),
    ORDER_STATU_1060("1060","编程审核中"),
    ORDER_STATU_1070("1070","QC审核中"),
    ORDER_STATU_1080("1080","炸单成功"),
    ORDER_STATU_999("999","未提交"),
    ORDER_STATU_1040("1040","等待价格确认"),
    ORDER_STATU_1041("1041","已签收"),
    ORDER_STATU_1042("1042","遗留申请审核中"),
    ORDER_STATU_1043("1043","遗留申请审核通过"),
    ORDER_STATU_1045("1045","遗留申请审核不通过"),
    ORDER_STATU_1110("1110","WCC技审"),
    ORDER_STATU_MINUS_3("-3","炸单失败"),
    ORDER_STATU_MINUS_4("-4","已作废"),
    ORDER_STATU_MINUS_1("-1","已退回"),
    ORDER_STATU_MINUS_2("-2","MTDS传单失败"),
    ORDER_STATU_MINUS_5("-5","传单中"),
    // -6状态比较页数，在系统中业务意义是调度中，调度开始获取的订单标识为该状态，但对前端展示中文为传单中
    ORDER_STATU_MINUS_6("-6","传单中"),
    // 软装需求增加
    ORDER_STATU_MINUS_8("-8","修改结算价"),
    // 软装需求增加
    ORDER_STATU_MINUS_7("-7","已处理");

    private final String value;

    private final String name;

    ProductionOrderStatusEnum(String value, String name){
        this.value = value;
        this.name = name;
    }

    
    public String value() {
        return value;
    }

    
    public String getName() {
        return name;
    }
    
    private static final Map<String, String> CODE_NAME_MAP = EnumSet.allOf(ProductionOrderStatusEnum.class).stream().collect(Collectors.toMap(ProductionOrderStatusEnum::value, ProductionOrderStatusEnum::getName));

    public static String getNameByCode(String value) {
        String result = CODE_NAME_MAP.get(value);
        return result == null ? "" : result;
    }
    
    private static final Map<String, ProductionOrderStatusEnum> CODE_OBJECT_MAP = EnumSet.allOf(ProductionOrderStatusEnum.class).stream().collect(Collectors.toMap(ProductionOrderStatusEnum::value, x -> x));
    public static ProductionOrderStatusEnum getByCode(String value) {
        return CODE_OBJECT_MAP.get(value);
    }
}
