package com.html;

import org.apache.commons.text.StringEscapeUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2022-11-25
 * Time: 11:56
 *
 * @author nero
 */
public class HtmlUtils {

    public static String parseHtml(String str) {
        String res = StringEscapeUtils.unescapeHtml4(str);
        return res;
    }

    public static void main(String[] args) {
        String a = "select &#39;测试&#39;";
        System.out.println(parseHtml(a));
    }

}
