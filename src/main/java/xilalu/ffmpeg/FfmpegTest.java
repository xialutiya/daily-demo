package xilalu.ffmpeg;

import java.io.*;

/**
 * @author lds
 * @date 2021/1/25 23:32
 */
public class FfmpegTest {

    public static String cmd = "ffmpeg -i ";

    public static void main(String[] args) {

        final String sourceUrl = "https://oss-live-1.videocc.net/record/record/recordf/65724fa7f120190614163541338/2021-01-22-16-20-04_2021-01-22-16-21-35.m3u8";

        Process process = null;
        try {
            File tempFile = File.createTempFile("live", ".mp4");
            String path = tempFile.toString();
            String cmdUrl = cmd + sourceUrl + " -vcodec copy -acodec copy " + path + " -y -loglevel quiet";
            process = Runtime.getRuntime().exec(cmdUrl);
            final InputStream is = process.getInputStream();
            final InputStream errorStream = process.getErrorStream();
            process.waitFor();
            process.destroy();
            new Thread(() -> {
                try {
                    BufferedReader bis = new BufferedReader(new InputStreamReader(is));
                    while (bis.readLine() != null) { }
                    BufferedReader br = new BufferedReader(new InputStreamReader(errorStream));
                    while (br.readLine() != null) { }
                } catch (Exception e) {

                }
            }).start();

            tempFile.delete();

        } catch (Exception e) {

        }


        System.out.println("=============>");
    }
}
