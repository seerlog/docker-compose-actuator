package com.example.worldgoldassociation.response;

import com.example.worldgoldassociation.domain.goldStatus.GoldStatus;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoldStatusResponse {
    private String name;
    private String country;
    private int goldMiningKilograms;

    public static GoldStatusResponse of(GoldStatus goldStatus) {
        return GoldStatusResponse.builder()
                .name(goldStatus.getName())
                .country(goldStatus.getCountry())
                .goldMiningKilograms(goldStatus.getGoldMiningKilograms())
                .build();
    }

}
