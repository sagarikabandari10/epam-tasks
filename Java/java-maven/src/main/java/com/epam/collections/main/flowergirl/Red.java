package com.epam.collections.main.flowergirl;

public class Red extends Color{

    public Red(int _stemLength, FreshnessLevel _fresh) {
        super(_stemLength, _fresh);
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
