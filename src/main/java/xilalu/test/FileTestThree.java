package xilalu.test;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lds
 * @date 2020/12/30 13:51
 */
public class FileTestTwo {
    public static void main(String[] args) throws IOException {

        String one = "UPDATE sales_train_sign SET position_name = '";
        String two = "' WHERE employee_id = '";
        String three = "' AND position_name = '';";

        String filePath = "E:\\work\\documentSpace\\培训app\\岗位名称丢失刷数\\人员id-uc.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        StringBuffer sb = new StringBuffer();
        String s;
        int i = 0;
        while ((s = bufferedReader.readLine()) != null) {
            String[] s1 = s.split("\t");
            sb.append(one).append(s1[1]).append(two).append(s1[0]).append(three);
            System.out.println(sb.toString());
            sb = new StringBuffer();
        }

        return;
    }
}
