package xilalu.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileExcelTest {
    public static void main(String[] args) throws IOException {

        List<String> listOne = new ArrayList<>(7000000);
        String filePath = "C:\\Users\\27707\\Documents\\电商临时导出数据\\测试\\one.txt";

        getStrByFile(listOne, filePath);

        return;
    }

    private static void getStrByFile(List<String> list, String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));

        String s;
        while ((s = bufferedReader.readLine()) != null) {
            // 最后一个样的索引位置.
            int indexOf = s.lastIndexOf("样");
            String str = s.substring(0, indexOf);
            char[] chars = str.toCharArray();
            for (char aChar : chars) {

            }
            list.add(s);
        }
        bufferedReader.close();
    }
}
