package com.grizzly.base.lambda;


import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class lambdaTest1 {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("lambda写法")).start();

        ArrayList<Object> list = new ArrayList<>();
        list.forEach(t -> System.out.println(t.toString()));

        Consumer<String> sc = System.out::println;
        sc.accept("618, 狂欢happy");

        System.out.println();

        Function<Integer, String> sf = String::valueOf;
        //等效
        Function<Integer, String> sf2 = (x) -> String.valueOf(x);
        String apply1 = sf.apply(61888);
    }
}
