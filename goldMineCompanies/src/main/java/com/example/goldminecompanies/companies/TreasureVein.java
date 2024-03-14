package com.example.goldminecompanies.companies;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class TreasureVein extends GoldMineCompany {
    public static TreasureVein of(String name,
                                  String country,
                                  String foundingDate,
                                  int goldMinerCount) {
        AtomicInteger goldMineReservesKilograms = new AtomicInteger();
        goldMineReservesKilograms.set(2300);

        TreasureVein treasureVein = new TreasureVein();
        treasureVein.setName(name);
        treasureVein.setCountry(country);
        treasureVein.setFoundingDate(foundingDate);
        treasureVein.setGoldMinerCount(goldMinerCount);
        treasureVein.setGoldMineReservesKilograms(goldMineReservesKilograms);

        return treasureVein;
    }
}
