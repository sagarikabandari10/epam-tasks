package com.epam.collections.main.flowergirl;

import java.util.ArrayList;
import java.util.List;

public class Run {
    private static final List<Color> colors = new ArrayList<>();

    public static void main(String[] args) {
        SetDefaultData();
        Bouquet bouquet = new Bouquet("Designer", colors, Bouquet.Wrapper.POLYDECOR,
                Bouquet.Card.BIRTHDAY, Bouquet.Design.FANCY);
        System.out.println(bouquet);
    }

    private static void SetDefaultData() {
        colors.add(new Red(10, Color.Freshness.Middle));
        colors.add(new White(6, Color.Freshness.Old));
        colors.add(new Yellow(7, Color.Freshness.Middle));
    }
}