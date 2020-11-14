package com.epam.collections.main.gift;

import java.util.List;

public class ChildrenGift {
    private final String name;
    private final List<Candies> candies;

    public ChildrenGift(String name, List<Candies> candies) {
        this.name = name;
        this.candies = candies;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Gift Box: '").append(name).append("'\n****************************\n");
        double cost = 0;
        double quality = 0;
        double weight = 0;
        for (Candies candies : candies) {
            stringBuilder.append(candies.toString()).append("\n");
            cost += candies.getPrice();
            quality += candies.getSugars();
            weight += candies.getWeight();
        }
        stringBuilder.append("\nTotal Cost for Gift: %s$");
        stringBuilder.append("\nTotal Sugars: %sq");
        stringBuilder.append("\nTotal Weight: %skg");
        return String.format(stringBuilder.toString(), cost, quality, weight);
    }
}
