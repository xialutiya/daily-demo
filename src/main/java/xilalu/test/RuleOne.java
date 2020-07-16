package xilalu.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RuleOne {

    public static void main(String[] args) throws DocumentException {

        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("E:\\work\\documentSpace\\设计软件规则校验\\xml\\one.xml"));

        Element rootElement = document.getRootElement();

        Element products = (Element) rootElement.selectSingleNode("Products");

        Element product = (Element) products.selectSingleNode("Product");
        String topVeneer = product.selectSingleNode("Attribute/PriceTable/@topVeneerSalesCode").getStringValue();

        String xpathLabel = rootElement.selectSingleNode("Products/Product/Attribute/@Label").getStringValue();

        List<Element> list = new ArrayList<>();

        getDesignatedNodes(products, list, "Product");

        System.out.println("===========>");
    }

    private static List<Element> getDesignatedNodes(Element node, List<Element> productNodes, String nodeName) {
        // 递归遍历当前节点所有的子节点
        List<Element> listElement = node.elements();
        if(listElement != null) {
            for (Element e : listElement) {
                // 如果该节点是目标节点，收集到列表中
                if(nodeName.equals(e.getName())) {
                    // 当前节点的名称、文本内容和属性
                    // showCurrentNodeInfo(e);
                    // 当前节点的所有属性的list
//                     showElementAttributes(e);
                    productNodes.add(e);
                }
                getDesignatedNodes(e, productNodes, nodeName);
            }
        }
        return productNodes;
    }
}
