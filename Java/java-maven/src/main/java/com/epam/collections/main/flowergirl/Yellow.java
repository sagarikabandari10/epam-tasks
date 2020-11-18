package com.epam.collections.main.flowergirl;

import com.epam.collections.main.flowergirl.models.Freshness;

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
