package com.example.goldminecompanies.companies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class GoldMineCompany {
    protected String name;
    protected String country;
    protected String foundingDate;
    protected int goldMinerCount;
    protected AtomicInteger goldMineReservesKilograms;

    public static GoldMineCompany of(String name,
                                     String country,
                                     String foundingDate,
                                     int goldMinerCount,
                                     int goldMineReservesKilograms) {
        AtomicInteger atomicGoldMineReservesKilograms = new AtomicInteger();
        atomicGoldMineReservesKilograms.set(goldMineReservesKilograms);

        GoldMineCompany goldMineCompany = new GoldMineCompany();
        goldMineCompany.setName(name);
        goldMineCompany.setCountry(country);
        goldMineCompany.setFoundingDate(foundingDate);
        goldMineCompany.setGoldMinerCount(goldMinerCount);
        goldMineCompany.setGoldMineReservesKilograms(atomicGoldMineReservesKilograms);

        return goldMineCompany;
    }

    synchronized public void mining() {
        final int beforeMiningKilograms = this.goldMineReservesKilograms.get();
        final int afterMiningKilograms = this.goldMineReservesKilograms.decrementAndGet();
        if (afterMiningKilograms < 0) return;
        this.goldMineReservesKilograms.set(afterMiningKilograms);
        System.out.println(String.format("[%s] %d 광부가 금을 채굴함 %d → %d", name, Thread.currentThread().getId(), beforeMiningKilograms, afterMiningKilograms));
    }

    public void startMining() {
        ExecutorService executor = Executors.newFixedThreadPool(this.getGoldMinerCount());
        for (int i = 0; i < this.getGoldMinerCount(); i++) {
            executor.execute(() -> {
                while (0 < this.goldMineReservesKilograms.intValue()) {
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
