package com.grizzly.base.annotation.scan;


@MyAnnotation
public class HelloWorld {

    private String name = "grizzly";
    public String say(){
        return "hello "+name;
    }
}
