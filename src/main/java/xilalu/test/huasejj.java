package xilalu.test;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class huasejj {

    public static void main(String[] args) {

        String OS = System.getProperty("os.name");
        String pwd = System.getProperty("user.dir");
        String from = "";
        if (OS.contains("indows")) {
            from = pwd.substring(0, pwd.lastIndexOf('\\') + 1) + "ts\\";
        } else {

        }

        try {
            String strUrl = "https://hot22.yyhdyl.com/20191230/6f814eaa13dd20a38ef4a6101db323bf/hls/hls-720p.m3u8?t=1577699284&sign=8fb71188cfae706a1697ebc91d3b91c4";
            URL url = new URL(strUrl);

            int index1 = strUrl.indexOf("//") + 2;
            int index2 = strUrl.indexOf("/", index1);
            String domainHttp = strUrl.substring(0, index2);
            String domain = strUrl.substring(index1, index2);

            URLConnection URLconnection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
//                System.err.println("成功");
                InputStream in = httpConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader bufr = new BufferedReader(isr);
                String str;
                int indexTS = 0;
                //download
                while ((str = bufr.readLine()) != null) {
                    if (str.contains(".jpg")) {
                        String pathname = from + domain + "/" + String.format("%4d", indexTS++).replace(" ", "0") + ".ts";
                        System.out.println(domainHttp + str);
                        System.out.println(pathname);
                        FileUtils.copyURLToFile(new URL(domainHttp + str), new File(pathname));
                        //break;
                    }
                }

                if (OS.contains("indows")) {
                    Runtime rt = Runtime.getRuntime();
                    Process pr = rt.exec("cmd /c copy /b " + from + domain + "\\*.ts  " + from + domain + ".mp4");
                    BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream(), "GBK"));
                    String line = null;
                    while ((line = input.readLine()) != null) {
                        System.out.println(line);
                    }
                    System.out.println();
                }

                bufr.close();
                System.out.println("succ");
            } else {
                System.err.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}