package com.testcase.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2021-11-30
 * Time: 15:46
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
