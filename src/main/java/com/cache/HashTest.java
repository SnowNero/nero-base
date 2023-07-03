package com.cache;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2023-06-14
 * Time: 14:45
 *
 * @author nero
 */
public class HashTest {

    public static void main(String[] args) {
        System.out.println(VM.current().details());
        Object obj = new Object();
        System.out.println(obj + " 十六进制哈希：" + Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        /*        System.out.println(VM.current().details());
        synchronized (obj){
            System.out.println(obj + " 十六进制哈希：" + Integer.toHexString(obj.hashCode()));
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            System.out.println("-----");
            System.out.println(ClassLayout.parseInstance(Test2.class).toPrintable());
            System.out.println("---Thread--");
            System.out.println(ClassLayout.parseInstance(Thread.currentThread()).toPrintable());
        }*/
    }

}
