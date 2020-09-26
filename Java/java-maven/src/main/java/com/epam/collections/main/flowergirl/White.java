package com.epam.collections.main.flowergirl;

public class White extends Color {
    public White(int _stemLength, FreshnessLevel _fresh) {
        super(_stemLength, _fresh);
    }

    @Override
    public void setFlowerName() {
        setName(getRandomFlower(new String[] { "Camellia", "Daffodil", "Daisy" }));
    }

    @Override
    public void setFlowerCost() {
        setCost(costByFreshness(COLORS.White.value));
    }

    @Override
    public String toString() {
        setFlowerName();
        setFlowerCost();
        return (getName()+"("+ COLORS.White +"): "+getCost()+ "$"+ super.toString());
    }
}
