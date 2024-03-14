package com.example.goldminecompanies.mining;

import com.example.goldminecompanies.companies.MineralMint;
import com.example.goldminecompanies.companies.NuggetVentures;
import com.example.goldminecompanies.companies.OreProsEnterprises;
import com.example.goldminecompanies.companies.TreasureVein;

public class RealTimeGoldMining {
    private MineralMint mineralMint;
    private NuggetVentures nuggetVentures;
    private OreProsEnterprises oreProsEnterprises;
    private TreasureVein treasureVein;

    public RealTimeGoldMining() {
        this.mineralMint = MineralMint.of("mineralMint", "australia", "1975-03-14", 5);
        this.nuggetVentures = NuggetVentures.of("nuggetVentures", "russia", "1987-06-22", 4);
        this.oreProsEnterprises = OreProsEnterprises.of("oreProsEnterprises", "usa", "1981-12-11", 7);
        this.treasureVein = TreasureVein.of("treasureVein", "peru", "1991-07-23", 12);
    }

    public void goldMining() {
        this.mineralMint.startMining();
    }
}
