package com.testcase.file;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-12-07
 * Time: 10:32
 */
public class FileUtils {

    /**
     * 将str转换为inputStream
     *
     * @param str
     * @return
     */
    public static InputStream str2InputStream(String str) {
        ByteArrayInputStream is = new ByteArrayInputStream(str.getBytes());
        return is;
    }

    /**
     * 将inputStream转换为str
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static String inputStream2Str(InputStream is) throws IOException {
        StringBuffer sb;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is));

            sb = new StringBuffer();

            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
        } finally {
            br.close();
        }

        return sb.toString();
    }

    /**
     * 将file转换为inputStream
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static InputStream file2InputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    /**
     * 将inputStream转化为file
     *
     * @param is
     * @param file 要输出的文件目录
     */
    public static void inputStream2File(InputStream is, File file) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int len = 0;
            byte[] buffer = new byte[8192];

            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } finally {
            os.close();
            is.close();
        }
    }
    
}
