package xilalu.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MainOne {
    public static void main(String[] args) throws UnsupportedEncodingException {
        test003();
    }

    public static void test002() throws UnsupportedEncodingException {
        String code = "\\346\\227\\240\\350\\275\\246\\347\\211\\214";
        //1.获取八进制数据
        String[] split = code.substring(1).split("\\\\");

        StringBuffer s16 = new StringBuffer();

        //2.把八进制转换成格式为:%+十六进制
        for (String s : split) {
            s16.append("%" + Integer.toHexString(Integer.valueOf(s, 8)).toString().toUpperCase());
        }

        //3.解码
        String decode = URLDecoder.decode(s16.toString(), "UTF-8");
        System.out.println("decode = " + decode);

    }

    public static void test003() {
        String ascStr = "<Scheme><name>scheme</name><space><name>\345\215\247\345\256\244</name><component><cabinetNumber>5</cabinetNumber><uniqueCode></uniqueCode><name>\347\273\204\345\220\210\346\237\234</name><classification></classification><subClassification>BJFL0030</subClassification><pricingFormulaCode></pricingFormulaCode><technologyCode></technologyCode><material></material><size><length>1355.0</length><width>2790.0</width><height>580.0</height><extendMeter>0.0</extendMeter><quantity>0</quantity><orthographicProjectionArea>1.9335300512400033</orthographicProjectionArea><expandArea>0.0</expandArea></size><veneer></veneer><isLayerLevel>true</isLayerLevel><isExtraChargeItem>false</isExtraChargeItem><isShaped>false</isShaped><shapedInfo><beforeCuttingArea>0.0</beforeCuttingArea><afterCuttingArea>0.0</afterCuttingArea><shapedStructureQuantity>0,0</shapedStructureQuantity></shapedInfo><direction><backPanel>true</backPanel><doorPanel>true</doorPanel><backPanelAndDoorPanel>true</backPanelAndDoorPanel><referenceFront></referenceFront></direction><isCross>false</isCross><childComponent><cabinetNumber>5-1</cabinetNumber><uniqueCode>YG_DYG</uniqueCode><name>\344\276\247\345\260\201\346\235\277</name>";
        String one = "\\346\\234\\252\\345\\221\\275\\345\\220\\215";
        String str = new String(ascStr.getBytes(Charset.forName("ISO_8859_1")), StandardCharsets.UTF_8);
        System.out.println(str);
    }
}
