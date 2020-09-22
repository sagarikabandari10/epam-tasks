package com.epam.collections.main.flowergirl;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Run {
    public static void main(String[] args) {
        List<Color> colors = new ArrayList<>();
        colors.add(new Red(10, Color.FreshnessLevel.Middle));
        colors.add(new Yellow(7, Color.FreshnessLevel.Middle));
        colors.add(new White(6,Color.FreshnessLevel.Old));
        Bouquet bouquet = new Bouquet("Designer", colors, Bouquet.Wrapper.PolyDecore, Bouquet.CARD.Birthday, Bouquet.TYPE.Fancy,
                Bouquet.DOLL.Bunny);
        System.out.println(bouquet);
    }
}
/* output:
Bouquet Name: Designer
*******************
Camellia(Red): 9.0$, stemLength=10, freshness=Middle
Carnation(Yellow):6.0$, stemLength=7, freshness=Middle
Daffodil(White):3.0$, stemLength=6, freshness=Old

Accessories: Wrapper - PolyDecore(5$), Card - Birthday(2.0$), Type - Fancy(2.5$), Doll - Bunny(1.2$)
Total Cost for Bouquet: 28.7$ */
