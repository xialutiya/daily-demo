package xilalu.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTest {
    public static void main(String[] args) throws IOException {

        List<String> listOne = new ArrayList<>(7000000);
        String filePath = "C:\\Users\\27707\\Documents\\电商临时导出数据\\测试\\one.txt";
        List<String> listTwo = new ArrayList<>(5000000);
        String filePathTwo = "C:\\Users\\27707\\Documents\\电商临时导出数据\\测试\\two.txt";

        getStrByFile(listOne, filePath);
        getStrByFile(listTwo, filePathTwo);

        StringBuffer sb = new StringBuffer();
        int i = listOne.size() - listTwo.size();
        List<String> list = new ArrayList<>(100000);
        for (String s : listOne) {
            if (!listTwo.contains(s)) {
                list.add(s);
            }
        }
        if (i == list.size()) {
            System.out.println(list.size());
        }
        return;
    }

    private static void getStrByFile(List<String> list, String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));

        String s;
        while ((s = bufferedReader.readLine()) != null) {
          list.add(s);
        }
        bufferedReader.close();
    }
}
