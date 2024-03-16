package com.example.goldminecompanies.mining;

import com.example.goldminecompanies.companies.*;

public class RealTimeGoldMining {
    private GoldMineCompany mineralMint;
    private GoldMineCompany nuggetVentures;
    private GoldMineCompany oreProsEnterprises;
    private GoldMineCompany treasureVein;

    public RealTimeGoldMining() {
        this.mineralMint = GoldMineCompany.of("mineralMint", "australia", "1975-03-14", 5, 120);
        this.nuggetVentures = GoldMineCompany.of("nuggetVentures", "russia", "1987-06-22", 4, 160);
        this.oreProsEnterprises = GoldMineCompany.of("oreProsEnterprises", "usa", "1981-12-11", 7, 110);
        this.treasureVein = GoldMineCompany.of("treasureVein", "peru", "1991-07-23", 12, 230);
    }

    public void goldMining() {
        this.mineralMint.startMining();
        this.nuggetVentures.startMining();
        this.oreProsEnterprises.startMining();
        this.treasureVein.startMining();
    }
}
