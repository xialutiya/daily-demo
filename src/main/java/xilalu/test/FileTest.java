package xilalu.test;

import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.Map;

public class FileTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File("E:/work/documentSpace/电商对接/建单建档失败/orderTwo.txt")));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, Object> map = restTemplate.getForObject("http://mtdssales.oppein.com/salesCrmOrder/create/order?ids=" + s, Map.class);
            Boolean status = (Boolean) map.get("status");
            if (!status) {
                System.out.println(s + ":a");
                continue;
            }
            System.out.println(s);
        }
        bufferedReader.close();
    }
}
