package com.epam.collections.main.flowergirl;

import java.util.ArrayList;
import java.util.List;

public class Run {
    private static List<Color> colors = new ArrayList<>();

    private static void SetDefaultData() {
        colors.add(new Red(10, Color.FreshnessLevel.Middle));
        colors.add(new White(6,Color.FreshnessLevel.Old));
        colors.add(new Yellow(7, Color.FreshnessLevel.Middle));
    }

    public static void main(String[] args) {
        SetDefaultData();
        Bouquet bouquet = new Bouquet("Designer", colors, Bouquet.Wrapper.PolyDecore,
                Bouquet.CARD.Birthday, Bouquet.Design.Fancy, Bouquet.DOLL.Bunny);
        System.out.println(bouquet);
    }
}
/* output:
Bouquet Name: Designer
*******************
Rose(Red): 9.0$, stemLength=10, freshness=Middle
Camellia(White): 3.0$, stemLength=6, freshness=Old
Yarrow(Yellow): 6.0$, stemLength=7, freshness=Middle

Accessories: Wrapper - PolyDecore(5$), Card - Birthday(2.0$), Type - Fancy(2.5$), Doll - Bunny(1.2$)
Total Cost for Bouquet: 28.7$ */
