package xilalu.test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lds
 * @date 2020/10/16 9:22
 */
public class TestThree {
    public static void main(String[] args) throws IOException {
        List<String> old = new ArrayList<>(256);
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(new File("E:\\work\\documentSpace\\橱柜好好学\\好好学误删附件\\误删原附件.txt")));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
//            boolean netFileAvailable = isNetFileAvailable(s);
//            if (!netFileAvailable) {
//                System.out.println(s);
//            }
            old.add(s);
        }
        bufferedReader.close();

        BufferedReader bufferedReaderTwo = new BufferedReader(
                new FileReader(new File("E:\\work\\documentSpace\\橱柜好好学\\好好学误删附件\\误删任然有问题的附件.txt")));
        String s2;
        int a = 0;
        while ((s2 = bufferedReaderTwo.readLine()) != null) {
//            boolean netFileAvailable = isNetFileAvailable(s);
//            if (!netFileAvailable) {
//                System.out.println(s);
//            }
            a++;
            if (!old.contains(s2)) {
                System.out.println(s2);
            }
        }
        System.out.println(a);
        bufferedReaderTwo.close();
    }

    public static boolean isNetFileAvailable(String strUrl) {
        InputStream netFileInputStream = null;
        try {
            URL url = new URL(strUrl);
            URLConnection urlConn = url.openConnection();
            netFileInputStream = urlConn.getInputStream();
            if (null != netFileInputStream) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            return false;
        } finally {
            try {
                if (netFileInputStream != null)
                    netFileInputStream.close();
            } catch (IOException e) {
            }
        }
    }

}
