package com.testcase.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-11-30
 * Time: 14:12
 */
public class DownloadImageUrl {

    public static void main(String[] args) throws Exception {
        String urlStr = "https://irv.iresearch.com.cn/public/logos/adver/10538.png";
        // 构造URL
        URL url = new URL(urlStr);
        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        String filename = "/Users/nero/Downloads/down/" + System.currentTimeMillis() + ".png";
        File file = new File(filename);
        FileOutputStream os = new FileOutputStream(file, true);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

}
