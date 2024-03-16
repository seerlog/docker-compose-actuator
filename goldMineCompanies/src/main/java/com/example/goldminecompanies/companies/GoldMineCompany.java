package com.example.goldminecompanies.companies;

import com.example.goldminecompanies.request.GoldStatusRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class GoldMineCompany {
    private String name;
    private String country;
    private String foundingDate;
    private int goldMinerCount;
    private AtomicInteger goldMineReservesKilograms;
    private WebClient webClient;

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
        goldMineCompany.setWebClient(WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
        );

        return goldMineCompany;
    }

    synchronized public void mining() {
        final int beforeMiningKilograms = this.goldMineReservesKilograms.get();
        final int afterMiningKilograms = this.goldMineReservesKilograms.decrementAndGet();
        if (afterMiningKilograms < 0) return;
        this.goldMineReservesKilograms.set(afterMiningKilograms);
        System.out.println(String.format("[%s] %d 광부가 금을 채굴함 %d → %d", name, Thread.currentThread().getId(), beforeMiningKilograms, afterMiningKilograms));

        GoldStatusRequest goldStatusRequest = GoldStatusRequest.builder()
                .name(this.getName())
                .country(this.getCountry())
                .goldMiningKilograms(1)
                .build();

        webClient.post()
                .uri("/gold-status")
                .body(Mono.just(goldStatusRequest), GoldStatusRequest.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
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
