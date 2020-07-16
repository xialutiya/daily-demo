package xilalu.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainThree {

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, String> map = new HashMap<>();
        map.put("one", "two");
        map.put("one", "test");
        System.out.println(map.get("one"));

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(new GlobalOne());
        System.out.println(s);

        GlobalOne globalOne = new GlobalOne();
        Double v = globalOne.getPureColor() + 1.44D;
        System.out.println(v);

        List<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.add("1");
        lists.add("1");
        String s1 = lists.get(0);
        System.out.println(lists.size());
    }
}
