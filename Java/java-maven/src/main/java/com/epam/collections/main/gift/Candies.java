package com.epam.collections.main.gift;

public abstract class Candies implements Comparable<Candies>{
    private final double weight;
    private final double price;
    private final double sugars;

    public Candies(double weight, double price, double sugars) {
        this.weight = weight;
        this.price = price;
        this.sugars = sugars;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getSugars() {
        return sugars;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+ ": " +
                "weight=" + weight +"kg"+
                ", price=" + price +"$"+
                ", sugars=" + sugars +"g";

    }

    @Override
    public int compareTo(Candies o) {
        return (int) (this.weight-o.weight);
    }
}
