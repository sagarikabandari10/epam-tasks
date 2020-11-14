package com.epam.collections.main.flowergirl;

public class Red extends Color {
    public Red(int stemLength, Freshness fresh) {
        super(stemLength, fresh);
        setFlowerName();
        setFlowerCost();
    }

    @Override
    public void setFlowerName() {
        getRandomFlower(new String[]{"Rose", "Anemone", "Chrysanthemum"});
    }

    @Override
    public void setFlowerCost() {
        costByFreshness(10);
    }
}
