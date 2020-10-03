package com.epam.collections.main.flowergirl;

import java.util.Random;

public abstract class Color implements Comparable <Color>{

    //private variables
    private String name;
    private final int stemLength;
    private final FreshnessLevel fresh;
    private double cost;

    //parameterised constructor
    public Color(int _stemLength, FreshnessLevel _fresh){
        this.stemLength=_stemLength;
        this.fresh=_fresh;
    }

    //abstract methods
    public abstract void setFlowerName();

    public abstract void setFlowerCost();

    public double getCost() {
        return cost;
    }

    //concrete methods
    protected void getRandomFlower(String[] flowers){
        Random random = new Random();
        int n = random.nextInt(flowers.length);
        name = flowers[n];
    }

    protected void costByFreshness(double _cost){
        switch (fresh) {
            case Full:
                cost=_cost;
                break;
            case Middle:
                cost=_cost-1;
                break;
            case Old:
                cost=_cost-2;
                break;
        }
    }

    //enums
    public enum FreshnessLevel{
        Full, Middle, Old
    }

    @Override
    public String toString() {
        return name + "("+getClass().getSimpleName()+ "): " +
                "cost=" + cost +"$"+
                ", stemLength=" + stemLength +
                ", freshness=" + fresh ;
    }

    @Override
    public int compareTo(Color o) {
        return Integer.compare(this.fresh.ordinal(), o.fresh.ordinal());//ordinal(): order of enum constants
    }
}
