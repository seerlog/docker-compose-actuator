package com.example.worldgoldassociation.domain.goldStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class GoldStatus {

    @Id
    @Column(name = "NO", nullable = false)
    private Long no;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "GOLD_MINING_KILOGRAMS", nullable = false)
    private int goldMiningKilograms;

    public static GoldStatus of(String name, String country, int goldMiningKilograms) {
        return GoldStatus.builder()
                .name(name)
                .country(country)
                .goldMiningKilograms(goldMiningKilograms)
                .build();
    }
}
