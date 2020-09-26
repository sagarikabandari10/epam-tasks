package com.epam.collections.main.flowergirl;

public class Red extends Color{

    public Red(int _stemLength, FreshnessLevel _fresh) {
        super(_stemLength, _fresh);
    }

    @Override
    public void setFlowerName() {
        setName(getRandomFlower(new String[]{"Rose", "Anemone", "Chrysanthemum"}));
    }

    @Override
    public void setFlowerCost() {
        setCost(costByFreshness(COLORS.Red.value));
    }

    @Override
    public String toString() {
        setFlowerName();
        setFlowerCost();
        return (getName()+"("+ COLORS.Red +"): "+getCost()+ "$"+ super.toString());
    }
}
