package com.grizzly.base.test1;


import org.springframework.stereotype.Component;

@Component
public class Boy implements IBuy {
    @Override
    public String buy(double price) {
        System.out.println(String.format("男孩花了%s元买了一个游戏机", price));
        return "游戏机";
    }
}
