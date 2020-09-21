package com.epam.collections.main.flowergirl;

public class Yellow extends Color {
    public Yellow(int _stemLength, FreshnessLevel _fresh) {
        super(_stemLength, _fresh);
    }

    @Override
    public String toString() {
        Flower flower = new Flower(Flower.COLORS.Yellow);
        setCost(Flower.COLORS.Yellow.value);
        return (flower.getName() + "("+ Flower.COLORS.Yellow+"):"+getCost()+"$"+super.toString());
    }
}
