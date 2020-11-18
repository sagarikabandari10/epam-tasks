package com.epam.collections.main.flowergirl;

import com.epam.collections.main.flowergirl.models.Card;
import com.epam.collections.main.flowergirl.models.Design;
import com.epam.collections.main.flowergirl.models.Wrapper;

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
        cost += this.wrap.getValue() + this.card.getValue() + this.design.getValue();
        stringBuilder.append("\nAccessories: ");
        stringBuilder.append("Wrapper - ").append(this.wrap).append("(").append(this.wrap.getValue()).append("$)");
        stringBuilder.append(", Card - ").append(this.card).append("(").append(this.card.getValue()).append("$)");
        stringBuilder.append(", Type - ").append(this.design).append("(").append(this.design.getValue()).append("$)");
        stringBuilder.append("\nTotal Cost for Bouquet: %s$");
        return String.format(stringBuilder.toString(), cost);
    }

}
