package xilalu.enumtest;

import org.springframework.util.StringUtils;

/**
 * @author lds
 * @date 2021/2/24 16:06
 */
public enum BackReasonEnum {

    one("1", "非本区域客户"),
    two("2", "派单品类出错"),
    three("3", "申请之前已交定金、已量尺、已签合同"),
    four("4", "三次以上不同时间拨打多次联系不上/电话号码空号"),
    five("5", "同一安装地址客户重复报名"),
    six("6", "定制材料、工艺、工期要求无法满足客户需求/非定制类完整订单"),
    seven("7", "客户实际收楼时间与订单等级不符"),
    eight("8", "经商场确认属竞品故意测试的体验卡"),
    nine("9", "客户因为先考虑装修，定好硬装再看柜子，暂时无法量尺或者进店的AB类客户体验卡，可修改客户派单类别"),
    ten("10", "48小时内客户已购其他品牌或全包给整装公司，明确表示不需要了（因客户对商场服务不满意导致不需要的情况除外）的体验卡");

    private String value;
    private String name;

    BackReasonEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    /**
     * 根据value返回namel
     *
     * @param value
     * @return name.
     */
    public static String getNameByValue(final String value) {
        if (StringUtils.isEmpty(value)) return "";
        for (BackReasonEnum backReasonEnum : BackReasonEnum.values()) {
            if (backReasonEnum.getValue().equals(value)) {
                return backReasonEnum.getName();
            }
        }
        return "";
    }
}
