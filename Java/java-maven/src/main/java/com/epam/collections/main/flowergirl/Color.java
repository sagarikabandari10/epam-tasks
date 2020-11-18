package com.epam.collections.main.flowergirl;

import com.epam.collections.main.flowergirl.models.Freshness;

import java.util.Random;

public abstract class Color implements Comparable<Color> {
    private final int stemLength;
    private final Freshness fresh;
    private String name;
    private double cost;

    public Color(int stemLength, Freshness fresh) {
        this.stemLength = stemLength;
        this.fresh = fresh;
    }

    public abstract void setFlowerName();

    public abstract void setFlowerCost();

    public double getCost() {
        return cost;
    }

    protected void getRandomFlower(String[] flowers) {
        Random random = new Random();
        int n = random.nextInt(flowers.length);
        name = flowers[n];
    }

    protected void costByFreshness(double cost) {
        switch (fresh) {
            case Full:
                this.cost = cost;
                break;
            case Middle:
                this.cost = cost - 1;
                break;
            case Old:
                this.cost = cost - 2;
                break;
        }
    }

    @Override
    public String toString() {
        return name + "(" + getClass().getSimpleName() + "): " +
                "cost=" + cost + "$" +
                ", stemLength=" + stemLength +
                ", freshness=" + fresh;
    }

    @Override
    public int compareTo(Color o) {
        return Integer.compare(this.fresh.ordinal(), o.fresh.ordinal());
    }
}
