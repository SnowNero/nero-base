package com.testcase.extend;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-12-25
 * Time: 14:19
 */
public class Test {

    public static void parse(A a) {
        System.out.println("A");
    }

    public static void parse(D d) {
        System.out.println("D");
    }

    public static void print(D d) {
        parse(d);//
    }

    public static void main(String[] args) {
        A a = new A();
        Class aa = a.getClass();
        System.out.println(aa);
        parse(a);

        D ad = new A();
        Class adad = ad.getClass();
        System.out.println(adad);
        parse(ad);

        D d = new D();
        Class dd = d.getClass();
        System.out.println(dd);
        parse(d);

    }

}
