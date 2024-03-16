package com.example.goldminecompanies.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoldStatusRequest {
    private String name;
    private String country;
    private int goldMiningKilograms;
}
