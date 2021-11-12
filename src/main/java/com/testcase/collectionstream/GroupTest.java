package com.testcase.collectionstream;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-04-12
 * Time: 11:16
 */
public class GroupTest {

    public static void main(String[] args) {
        List<Map> list = new ArrayList<>();
        Map map = new HashMap();
        map.put("id", "1");
        map.put("name", "1");
        list.add(map);
        map = new HashMap();
        map.put("id", "2");
        map.put("name", "2");
        list.add(map);
        map = new HashMap();
        map.put("id", "2");
        map.put("name", "3");
        list.add(map);
        List<List<Map>> dataList = Lists.newArrayList();
        list.stream().collect(
                Collectors.groupingBy(m -> m.get("id")))
                .forEach((groupKey, groupList) -> {
                    System.out.println(groupKey);
                    System.out.println(groupList);
                    dataList.add(Lists.newArrayList(Lists.newArrayList(groupList)));
                });
        System.out.println(dataList);
    }

}
