package xilalu.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lds
 * @date 2020/9/28 15:57
 */
public class IoTest {
    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new HashMap<>(120000);

        String str;
        String fileName = "E:\\work\\documentSpace\\电商对接\\测试数据\\one.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "UTF-8");

        BufferedReader br = new BufferedReader(isr);
        while ((str = br.readLine()) != null) {
            if (map.get(str) != null) {
                System.out.println(str);
            } else {
                map.put(str, 0);
            }
        }

    }
}
