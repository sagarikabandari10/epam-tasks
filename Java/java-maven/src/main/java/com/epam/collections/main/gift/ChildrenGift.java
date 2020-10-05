package com.epam.collections.main.gift;

import java.util.List;

public class ChildrenGift {
    private final String name;
    private final List<Candies> candies;

    public ChildrenGift(String name, List<Candies> candies){
        this.name=name;
        this.candies=candies;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Gift Box: '").append(name).append("'\n****************************\n");
        double cost = 0;
        double quality = 0;
        double weight = 0;
        for (Candies c : candies) {
            s.append(c.toString()).append("\n");
            cost += c.getPrice();
            quality += c.getSugars();
            weight += c.getWeight();
        }
        s.append("\nTotal Cost for Gift: %s$");
        s.append("\nTotal Sugars: %sq");
        s.append("\nTotal Weight: %skg");
        return String.format(s.toString(), cost, quality, weight);
    }
}
