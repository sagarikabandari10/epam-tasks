package com.epam.collections.main.gift;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<Candies> list = new ArrayList<>();
        list.add(new HersheyKiss(1.0, 5.0, 2.5));
        list.add(new KitKat(0.5, 2.5, 49));
        list.add(new Snickers(1.5, 7.0, 47));
        list.add(new Snickers(0.2, 2.0, 47));

        ChildrenGift newYearGift = new ChildrenGift("New Year Gift", list);
        System.out.println(newYearGift);
    }
}
