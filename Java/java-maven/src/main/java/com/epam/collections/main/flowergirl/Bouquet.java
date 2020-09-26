package com.epam.collections.main.flowergirl;

import java.util.List;

public class Bouquet {
    private String name;
    private List<Color> colors;
    private Wrapper wrap;
    private CARD card;
    private Design design;
    private DOLL doll;

    public Bouquet(String _name, List<Color> _colors, Wrapper _wrap, CARD _card, Design _bouDesign, DOLL _doll){
        this.name = _name;
        this.colors = _colors;
        this.wrap = _wrap;
        this.card = _card;
        this.design = _bouDesign;
        this.doll = _doll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    //enums
    public enum Wrapper {
        NewPaper(0), CrepePaper(2), PlasticPaper(3), PolyDecore(5);

        private int value;

        Wrapper(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }
    }

    public enum CARD {
        Birthday(2), Anniversery(1.5), BestWisher(1), NoCard(0);

        private double value;

        CARD(double i) {
            this.value = i;
        }

        public double getValue() {
            return value;
        }
    }

    public enum Design {
        Classic(1.8), Fancy(2.5), Normal(1);

        private double value;

        Design(double d) {
            this.value = d;
        }

        public double getValue() {
            return value;
        }
    }

    public enum DOLL {
        Teddybear(4), Bunny(1.2), Cat(2.2);

        private double value;

        DOLL(double d1) {
            this.value = d1;
        }

        public double getValue() {
            return value;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Bouquet Name: " + name + "\n*******************\n");
        double cost = 0;
        for (Color c : colors) {
            s.append(c.toString()+"\n"); // calls toString() method based on color.
            cost += c.getCost(); // cost of each flower.
        }
        cost += this.wrap.value + this.card.value + this.design.value + this.doll.value;// flower cost + accessories.
        s.append("\nAccessories: ");
        s.append("Wrapper - " + this.wrap + "(" + this.wrap.value + "$)");
        s.append(", Card - " + this.card + "(" + this.card.value + "$)");
        s.append(", Type - " + this.design + "(" + this.design.value + "$)");
        s.append(", Doll - " + this.doll + "(" + this.doll.value + "$)");
        s.append("\nTotal Cost for Bouquet: %s$");
        return String.format(s.toString(), cost);
    }

}
