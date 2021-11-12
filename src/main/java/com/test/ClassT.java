package com.test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-02-04
 * Time: 10:13
 */
public class ClassT {

    /*public class Chart {
        *//**
         * 图结构生成器
         *
         * @param chartType
         * @return
         *//*
        public static <T extends ParentVO> T build(String chartType) throws IllegalAccessException, InstantiationException {
            switch (chartType) {
                case "TYPE_TEST":
                    ChirldVO t = ChirldVO.class.newInstance();
                    return (T) t;
            }
            return null;
        }

        public static void main(String[] args) throws InstantiationException, IllegalAccessException {
            String type = "columnGrouped";
            ChirldVO chirldVO = Chart.build(type);
            chirldVO.setParam(1);
            System.out.println(1);

        }


    }*/


}
