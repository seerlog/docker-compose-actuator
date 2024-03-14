package com.example.goldminecompanies.companies;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class OreProsEnterprises extends GoldMineCompany {
    public static OreProsEnterprises of(String name,
                                        String country,
                                        String foundingDate,
                                        int goldMinerCount) {
        AtomicInteger goldMineReservesKilograms = new AtomicInteger();
        goldMineReservesKilograms.set(1100);

        OreProsEnterprises oreProsEnterprises = new OreProsEnterprises();
        oreProsEnterprises.setName(name);
        oreProsEnterprises.setCountry(country);
        oreProsEnterprises.setFoundingDate(foundingDate);
        oreProsEnterprises.setGoldMinerCount(goldMinerCount);
        oreProsEnterprises.setGoldMineReservesKilograms(goldMineReservesKilograms);

        return oreProsEnterprises;
    }
}
