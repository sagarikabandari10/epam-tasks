package com.epam.collections.main.flowergirl;

public class White extends Color {
    public White(int _stemLength, FreshnessLevel _fresh) {
        super(_stemLength, _fresh);
    }

    @Override
    public String toString() {
        Flower flower = new Flower(Flower.COLORS.White);
        setCost(Flower.COLORS.White.value);
        return (flower.getName() + "("+ Flower.COLORS.White+"):"+getCost()+"$"+super.toString());
    }
}
