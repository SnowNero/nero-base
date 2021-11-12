package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-03-16
 * Time: 09:38
 *
 * @author nero
 */
public class CombinationUtils {

    public static void main(String[] args) {
        List<List<String>> res = new ArrayList();
        List<String> list = new ArrayList();
        list.add("id1");
        list.add("id2");
        list.add("id3");
        System.out.println(list);
        res = combineTwoElement(list);
        System.out.println(res);
    }

    public static List<List<String>> combineTwoElement(List<String> list) {
        List<List<String>> resultList = new ArrayList();
        if (list.size() == 0) {
            return null;
        }
        if (list.size() >= 2) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    List tempList = new ArrayList();
                    tempList.add(list.get(i));
                    tempList.add(list.get(j));
                    resultList.add(tempList);
                }
            }
        }
        return resultList;
    }

}
