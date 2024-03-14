package com.example.goldminecompanies.companies;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class NuggetVentures extends GoldMineCompany {
    public static NuggetVentures of(String name,
                                    String country,
                                    String foundingDate,
                                    int goldMinerCount) {
        AtomicInteger goldMineReservesKilograms = new AtomicInteger();
        goldMineReservesKilograms.set(1600);

        NuggetVentures nuggetVentures = new NuggetVentures();
        nuggetVentures.setName(name);
        nuggetVentures.setCountry(country);
        nuggetVentures.setFoundingDate(foundingDate);
        nuggetVentures.setGoldMinerCount(goldMinerCount);
        nuggetVentures.setGoldMineReservesKilograms(goldMineReservesKilograms);

        return nuggetVentures;
    }
}
