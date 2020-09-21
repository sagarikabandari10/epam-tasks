package com.epam.collections.main.flowergirl;

public abstract class Color implements Comparable <Color>{
    //private variables
    private int stemLength;
    private FreshnessLevel fresh;//enum
    private double cost;

    public Color(int _stemLength, FreshnessLevel _fresh){
        this.stemLength=_stemLength;
        this.fresh=_fresh;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        this.stemLength = stemLength;
    }

    public FreshnessLevel getFresh() {
        return fresh;
    }

    public void setFresh(FreshnessLevel fresh) {
        this.fresh = fresh;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double _cost) {
        costByFreshness(_cost, fresh); // set cost value based on freshness.
    }

    public double costByFreshness(double _cost, Color.FreshnessLevel fresh){
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

    @Override
    public String toString() {
        return ", stemLength=" + stemLength + ", freshness=" + fresh;
    }

    @Override
    public int compareTo(Color o) {
        if (this.fresh.ordinal() > o.fresh.ordinal())//order of enum constants
            return 1;
        else if (this.fresh.ordinal() < o.fresh.ordinal())
            return -1;
        else
            return 0;
    }
}
