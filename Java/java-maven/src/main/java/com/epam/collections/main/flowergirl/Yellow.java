package com.epam.collections.main.flowergirl;

public class Yellow extends Color {
    public Yellow(int _stemLength, FreshnessLevel _fresh) {
        super(_stemLength, _fresh);
    }

    @Override
    public void setFlowerName() {
        setName(getRandomFlower(new String[] { "Sunflower", "Yarrow", "Hibiscus", "Carnation" }));
    }

    @Override
    public void setFlowerCost() {
        setCost(costByFreshness(COLORS.Yellow.value));
    }

    @Override
    public String toString() {
        setFlowerName();
        setFlowerCost();
        return (getName()+"("+ COLORS.Yellow +"): "+getCost()+ "$"+ super.toString());
    }
}
