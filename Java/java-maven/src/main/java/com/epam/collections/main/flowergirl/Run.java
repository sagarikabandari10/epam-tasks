package com.epam.collections.main.flowergirl;

import com.epam.collections.main.flowergirl.models.Card;
import com.epam.collections.main.flowergirl.models.Design;
import com.epam.collections.main.flowergirl.models.Freshness;
import com.epam.collections.main.flowergirl.models.Wrapper;

import java.util.ArrayList;
import java.util.List;

public class Run {
    private static final List<Color> colors = new ArrayList<>();

    public static void main(String[] args) {
        SetDefaultData();
        Bouquet bouquet = new Bouquet("Designer", colors, Wrapper.POLYDECOR,
                Card.BIRTHDAY, Design.FANCY);
        System.out.println(bouquet);
    }

    private static void SetDefaultData() {
        colors.add(new Red(10, Freshness.Middle));
        colors.add(new White(6, Freshness.Old));
        colors.add(new Yellow(7, Freshness.Middle));
    }
}