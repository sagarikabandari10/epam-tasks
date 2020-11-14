package com.epam.collections.main.flowergirl;

import java.util.List;

public class Bouquet {
    private final List<Color> colors;
    private final Wrapper wrap;
    private final Card card;
    private final Design design;
    private String name;

    public Bouquet(String name, List<Color> colors, Wrapper wrap, Card card, Design bouDesign) {
        this.name = name;
        this.colors = colors;
        this.wrap = wrap;
        this.card = card;
        this.design = bouDesign;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bouquet Name: ").append(name).append("\n*******************\n");
        double cost = 0;
        for (Color color : colors) {
            stringBuilder.append(color.toString()).append("\n");
            cost += color.getCost();
        }
        cost += this.wrap.value + this.card.value + this.design.value;
        stringBuilder.append("\nAccessories: ");
        stringBuilder.append("Wrapper - ").append(this.wrap).append("(").append(this.wrap.value).append("$)");
        stringBuilder.append(", Card - ").append(this.card).append("(").append(this.card.value).append("$)");
        stringBuilder.append(", Type - ").append(this.design).append("(").append(this.design.value).append("$)");
        stringBuilder.append("\nTotal Cost for Bouquet: %s$");
        return String.format(stringBuilder.toString(), cost);
    }

    public enum Wrapper {
        CREPEPAPER(2), PLASTICPAPER(3), POLYDECOR(5);
        private final int value;
        Wrapper(int i) {
            this.value = i;
        }
    }

    public enum Card {
        ANNIVERSARY(1.5), BESTWISHER(1), BIRTHDAY(2), NOCARD(0);
        private final double value;
        Card(double i) {
            this.value = i;
        }
    }

    public enum Design {
        CLASSIC(1.8), FANCY(2.5), NORMAL(1);
        private final double value;
        Design(double d) {
            this.value = d;
        }
    }

}
