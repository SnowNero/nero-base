package com.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2019-11-04
 * Time: 16:43
 */
public class TestCompleteFuture {

    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> {
            return "Hello ";
        }).thenApplyAsync(v -> v + "world").join();
        System.out.println(result);
    }
}
