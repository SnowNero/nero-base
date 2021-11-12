package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-06-25
 * Time: 15:44
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            System.out.println(a);
        }
        //String a = "I am a developer.";
        //String res = reverseWords(a, 0, 3);
        //System.out.println(res);
    }

    public static String reverseWords(String s, int start, int end) {
        if (start == end) {
            return "EMPTY";
        }
        StringBuffer res = new StringBuffer();
        String[] wordArr = s.split(" ");
        Map tempMap = new HashMap();
        int index = 0;
        for (String word : wordArr) {
            if (!word.equals("")) {
                tempMap.put(index, word);
                index++;
            }
        }
        if (index == 1) {
            return "EMPTY";
        }
        if (start >= index) {
            return "EMPTY";
        }
        for (int i = 0; i < start; i++) {
            res.append(tempMap.get(i));
            res.append(" ");
        }
        for (int i = end; i >= start; i--) {
            res.append(tempMap.get(i));
            res.append(" ");
        }
        for (int i = end + 1; i < index; i++) {
            res.append(tempMap.get(i));
            res.append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

}
