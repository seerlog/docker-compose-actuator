package com.example.goldminecompanies.companies;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class MineralMint extends GoldMineCompany {
    public static MineralMint of(String name,
                                 String country,
                                 String foundingDate,
                                 int goldMinerCount) {
        AtomicInteger goldMineReservesKilograms = new AtomicInteger();
        goldMineReservesKilograms.set(1200);

        MineralMint mineralMint = new MineralMint();
        mineralMint.setName(name);
        mineralMint.setCountry(country);
        mineralMint.setFoundingDate(foundingDate);
        mineralMint.setGoldMinerCount(goldMinerCount);
        mineralMint.setGoldMineReservesKilograms(goldMineReservesKilograms);

        return mineralMint;
    }

    synchronized public void mining() {
        final int beforeMiningKilograms = this.goldMineReservesKilograms.get();
        final int afterMiningKilograms = this.goldMineReservesKilograms.decrementAndGet();
        this.goldMineReservesKilograms.set(afterMiningKilograms);
        System.out.println(String.format("%d 광부가 금을 채굴함 %d → %d", Thread.currentThread().getId(), beforeMiningKilograms, afterMiningKilograms));
    }

    public void startMining() {
        ExecutorService executor = Executors.newFixedThreadPool(this.getGoldMinerCount());
        for (int i = 0; i < this.getGoldMinerCount(); i++) {
            executor.execute(() -> {
                while(0 < this.goldMineReservesKilograms.intValue()) {
                    try {
                        Thread.sleep(1000);
                        mining();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executor.shutdown();
    }

}
