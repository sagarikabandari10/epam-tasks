package com.epam.collections.main.flowergirl;

import java.util.List;

public class Bouquet {
    private final List<Color> colors;
    private final Wrapper wrap;
    private final Card card;
    private final Design design;
    private final Doll doll;
    private String name;

    public Bouquet(String _name, List<Color> _colors, Wrapper _wrap, Card _card, Design _bouDesign, Doll _doll) {
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

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Bouquet Name: ").append(name).append("\n*******************\n");
        double cost = 0;
        for (Color c : colors) {
            s.append(c.toString()).append("\n"); // calls toString() method based on color.
            cost += c.getCost(); // cost of each flower.
        }
        cost += this.wrap.value + this.card.value + this.design.value + this.doll.value;// flower cost + accessories.
        s.append("\nAccessories: ");
        s.append("Wrapper - ").append(this.wrap).append("(").append(this.wrap.value).append("$)");
        s.append(", Card - ").append(this.card).append("(").append(this.card.value).append("$)");
        s.append(", Type - ").append(this.design).append("(").append(this.design.value).append("$)");
        s.append(", Doll - ").append(this.doll).append("(").append(this.doll.value).append("$)");
        s.append("\nTotal Cost for Bouquet: %s$");
        return String.format(s.toString(), cost);
    }

    //enums
    public enum Wrapper {
        CrepePaper(2), PlasticPaper(3), PolyDecor(5);

        private final int value;

        Wrapper(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Card {
        Anniversary(1.5), BestWisher(1), Birthday(2), NoCard(0);

        private final double value;

        Card(double i) {
            this.value = i;
        }

        public double getValue() {
            return value;
        }
    }

    public enum Design {
        Classic(1.8), Fancy(2.5), Normal(1);

        private final double value;

        Design(double d) {
            this.value = d;
        }

        public double getValue() {
            return value;
        }
    }

    public enum Doll {
        Bunny(1.2), Cat(2.2), Teddie(4);

        private final double value;

        Doll(double d1) {
            this.value = d1;
        }

        public double getValue() {
            return value;
        }
    }

}
