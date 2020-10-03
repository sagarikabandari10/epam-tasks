package com.epam.collections.main.flowergirl;

public class Yellow extends Color {
    public Yellow(int _stemLength, FreshnessLevel _fresh) {
        super(_stemLength, _fresh);
        setFlowerName();
        setFlowerCost();
    }

    @Override
    public void setFlowerName() {
        getRandomFlower(new String[] { "Sunflower", "Yarrow", "Hibiscus", "Carnation" });
    }

    @Override
    public void setFlowerCost() {
        costByFreshness(7);
    }
}
