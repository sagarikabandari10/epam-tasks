package com.epam.collections.main.flowergirl;

import java.util.Random;

public abstract class Color implements Comparable <Color>{

    //private variables
    private String name;
    private int stemLength;
    private FreshnessLevel fresh;
    private double cost;

    //parameterised constructor
    public Color(int _stemLength, FreshnessLevel _fresh){
        this.stemLength=_stemLength;
        this.fresh=_fresh;
    }

    //abstract methods
    public abstract void setFlowerName();

    public abstract void setFlowerCost();

    //properties
    public String getName() {
        return name;
    }

    public void setName(String _name) { name = _name; }

    public double getCost() {
        return cost;
    }

    public void setCost(double _cost) { cost = _cost;  }

    //concrete methods
    protected String getRandomFlower(String[] flowers){
        Random random = new Random();
        int n = random.nextInt(flowers.length);
        return flowers[n];
    }

    protected double costByFreshness(double _cost){
        switch (fresh) {
            case Middle:
                cost=_cost-1;
                break;
            case Old:
                cost=_cost-2;
                break;
            default:
                cost=_cost;
                break;
        }
        return cost;
    }

    //enums
    public enum FreshnessLevel{
        Full, Middle, Old
    }

    public enum COLORS {
        Red(10), White(5), Yellow(7), Blue(6);//cost of each flower color.
        int value;
        COLORS(int i){value=i;}
        public int getValue(){
            return value;
        }
    }

    @Override
    public String toString() {
        return ", stemLength=" + stemLength + ", freshness=" + fresh;
    }

    @Override
    public int compareTo(Color o) {
        if (this.fresh.ordinal() > o.fresh.ordinal())//ordinal(): order of enum constants
            return 1;
        else if (this.fresh.ordinal() < o.fresh.ordinal())
            return -1;
        else
            return 0;
    }
}
