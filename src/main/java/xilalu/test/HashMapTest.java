package xilalu.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lds
 * @date 2020/10/19 14:12
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(8);
        map.put("xialu", "hello");
        map.put("xialu", "hi");
        System.out.println(map.get("xialu"));
    }
}
