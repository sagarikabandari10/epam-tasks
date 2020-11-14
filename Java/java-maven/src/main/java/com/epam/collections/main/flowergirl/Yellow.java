package com.epam.collections.main.flowergirl;

public class Yellow extends Color {
    public Yellow(int stemLength, Freshness fresh) {
        super(stemLength, fresh);
        setFlowerName();
        setFlowerCost();
    }

    @Override
    public void setFlowerName() {
        getRandomFlower(new String[]{"Sunflower", "Yarrow", "Hibiscus", "Carnation"});
    }

    @Override
    public void setFlowerCost() {
        costByFreshness(7);
    }
}
