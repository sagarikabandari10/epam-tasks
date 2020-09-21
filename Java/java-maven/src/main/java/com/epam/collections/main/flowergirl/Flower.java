package com.epam.collections.main.flowergirl;

import java.util.Random;

public class Flower {
    private String name;

    public Flower(COLORS _color) {
        getFlowerByColor(_color);//sets flower name
    }

    public String getName() {
        return name;
    }

    public String getFlowerByColor(COLORS color){
        switch(color){
            case Red:
                name = getRandomFlower(new String[]{"Rose", "Anemone", "Chrysanthemum"});
            case White:
                name = getRandomFlower(new String[] { "Camellia", "Daffodil", "Daisy" });
                break;
            case Yellow:
                name = getRandomFlower(new String[] { "Sunflower", "Yarrow", "Hibiscus", "Carnation" });
                break;
            case Blue:
                //name = getRandomFlower(new String[] { "Sunflower", "Yarrow", "Hibiscus", "Carnation" });
                break;
            default:
                name = "No Color";
                break;
        }
        return name;
    }

    private String getRandomFlower(String[] flowers){
        Random random = new Random();
        int n = random.nextInt(flowers.length);
        return flowers[n];
    }

    public enum COLORS {
        Red(10), White(5), Yellow(7), Blue(6);//cost of each flower color.
        int value;
        COLORS(int i){value=i;}
        public int getValue(){
            return value;
        }
    }
}
