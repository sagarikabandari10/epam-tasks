package com.epam.collections.main.flowergirl;

public class Red extends Color{

    public Red(int _stemLength, FreshnessLevel _fresh) {
        super(_stemLength, _fresh);
    }

    @Override
    public String toString() {
        Flower flower = new Flower(Flower.COLORS.Red);//randomly generates flower name.
        setCost(Flower.COLORS.Red.value);//set cost by calling costByFreshness method.
        return (flower.getName()+"("+ Flower.COLORS.Red+"): "+getCost()+ "$"+ super.toString());
    }
}
