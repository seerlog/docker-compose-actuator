package com.example.goldminecompanies.companies;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class GoldMineCompany {
    protected String name;
    protected String country;
    protected String foundingDate;
    protected int goldMinerCount;
    protected AtomicInteger goldMineReservesKilograms;
}
