package com.epam.collections.main.flowergirl;

public class White extends Color {
    public White(int stemLength, Freshness fresh) {
        super(stemLength, fresh);
        setFlowerName();
        setFlowerCost();
    }

    @Override
    public void setFlowerName() {
        getRandomFlower(new String[] { "Camellia", "Daffodil", "Daisy" });
    }

    @Override
    public void setFlowerCost() {
        costByFreshness(5);
    }
}
