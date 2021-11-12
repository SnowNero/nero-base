package com.nero.run;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-11-30
 * Time: 15:58
 */
public class X {
    Y y = new Y();
    static int aa = 10;

    static {
        System.out.println("tttt");
    }

    public X() {
        System.out.println("X");
    }

    public static void main(String[] args) {
        new Z();
    }
}

class Y {
    Y() {
        System.out.println('Y');
    }
}

class Z extends X {
    static int bb = 10;
    Y y = new Y();

    static {
        System.out.println("tt");
    }

    Z() {
        System.out.println("Z");
    }
}
